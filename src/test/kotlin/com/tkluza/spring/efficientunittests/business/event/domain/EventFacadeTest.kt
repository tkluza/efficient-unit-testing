package com.tkluza.spring.efficientunittests.business.event.domain

import com.tkluza.spring.efficientunittests.business.event.domain.exception.TicketAlreadySoldException
import com.tkluza.spring.efficientunittests.business.event.domain.gateway.EventGateway
import com.tkluza.spring.efficientunittests.business.event.domain.model.TicketEntity
import com.tkluza.spring.efficientunittests.business.event.dto.command.BuyTicketCommand
import com.tkluza.spring.efficientunittests.business.event.test.EventTestFactory
import com.tkluza.spring.efficientunittests.business.place.domain.model.SeatEntity
import com.tkluza.spring.efficientunittests.business.user.domain.model.UserEntity
import com.tkluza.spring.efficientunittests.common.BaseTest
import io.kotest.assertions.assertSoftly
import io.kotest.matchers.date.shouldBeAfter
import io.kotest.matchers.date.shouldBeBefore
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.SpyBean
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.EntityNotFoundException

internal class EventFacadeTest : BaseTest() {

    @Autowired
    private lateinit var eventFacade: EventFacade

    @SpyBean
    private lateinit var eventGateway: EventGateway

    @BeforeEach
    override fun init() {
        super.init()

        EventTestFactory.saveEvents(
            placeRows = arrayOf(
                "| KEY | Place | Name         | Date             |",
                "| E-1 | P-1   | Beer wih Us! | 2022-09-15T19:00 |"
            ),
            testDataContext = testDataContext
        )

        EventTestFactory.saveTickets(
            placeRows = arrayOf(
                "| KEY | Event | Seat | User | Price | Sale date         |",
                "| T-1 | E-1   | S-1  |      | 200   |                   |",
                "| T-2 | E-1   | S-2  |      | 150   |                   |",
                "| T-3 | E-1   | S-3  | U-1  | 100   | 2022-06-15T11:11  |",
                "| T-4 | E-1   | S-4  | U-2  | 50    | 2022-07-15T22:22  |",
            ),
            testDataContext = testDataContext
        )
    }

    @Nested
    inner class BuyTicketTest {

        @Test
        fun `should buy ticket successfully`() {
            // given
            val command = buildCommand(ticketKey = "T-1", userKey = "U-3")

            // when
            val result = eventFacade.buyTicket(command)

            // then
            assertSoftly(result) {
                eventName shouldBe "Beer wih Us!"
                placeName shouldBe "Allianz Arena"
                seatInfo shouldBe "Section: A | Row: 1 | Seat: 5"
                userFullName shouldBe "LeBron James"
                price shouldBe BigDecimal(200)
                saleDate shouldBeBefore LocalDateTime.now()
                saleDate shouldBeAfter LocalDateTime.now().minusMinutes(1)
            }
        }

        @Test
        fun `should buy another ticket successfully`() {
            // given
            val command = buildCommand(ticketKey = "T-2", userKey = "U-1")

            // when
            val result = eventFacade.buyTicket(command)

            // then
            assertSoftly(result) {
                eventName shouldBe "Beer wih Us!"
                placeName shouldBe "Allianz Arena"
                seatInfo shouldBe "Section: B | Row: 10 | Seat: 15"
                userFullName shouldBe "Michael Jordan"
                price shouldBe BigDecimal(150)
                saleDate shouldBeBefore LocalDateTime.now()
                saleDate shouldBeAfter LocalDateTime.now().minusMinutes(1)
            }
        }

        @Test
        fun `should throw exception if ticket already sold`() {
            // given
            val command = buildCommand(ticketKey = "T-4", userKey = "U-3")

            // when & then
            assertThrows<TicketAlreadySoldException> {
                eventFacade.buyTicket(command)
            }
        }

        @Test
        fun `should throw exception if ticket was not found`() {
            // given
            val command = BuyTicketCommand(
                ticketId = Long.MAX_VALUE,
                userId = testDataContext["U-1", UserEntity::class.java]!!.id
            )

            // when & then
            assertThrows<EntityNotFoundException> {
                eventFacade.buyTicket(command)
            }
        }
    }

    @Nested
    inner class BuyTicketTestCommunicationViaGateway {

        @Captor
        private lateinit var findUserByIdArgumentCaptor: ArgumentCaptor<Long>

        @Captor
        private lateinit var findSeatByIdArgumentCaptor: ArgumentCaptor<Long>

        @Test
        fun `should get user information from user domain via gateway`() {
            // given
            val command = buildCommand(ticketKey = "T-1", userKey = "U-1")

            // when
            eventFacade.buyTicket(command)

            // then
            val user = testDataContext["U-1", UserEntity::class.java]!!

            verify(eventGateway).findUserById(findUserByIdArgumentCaptor.capture())
            findUserByIdArgumentCaptor.getValue() shouldBe user.id
        }

        @Test
        fun `should get seat information from place domain via gateway`() {
            // given
            val command = buildCommand(ticketKey = "T-1", userKey = "U-1")

            // when
            eventFacade.buyTicket(command)

            // then
            val seat = testDataContext["S-1", SeatEntity::class.java]!!

            verify(eventGateway).findSeatById(findSeatByIdArgumentCaptor.capture())
            findSeatByIdArgumentCaptor.getValue() shouldBe seat.id
        }
    }

    private fun buildCommand(ticketKey: String, userKey: String): BuyTicketCommand =
        BuyTicketCommand(
            ticketId = testDataContext[ticketKey, TicketEntity::class.java]!!.id,
            userId = testDataContext[userKey, UserEntity::class.java]!!.id,
        )
}
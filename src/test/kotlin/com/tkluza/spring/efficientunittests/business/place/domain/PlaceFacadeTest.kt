package com.tkluza.spring.efficientunittests.business.place.domain

import com.tkluza.spring.efficientunittests.business.place.domain.model.PlaceEntity
import com.tkluza.spring.efficientunittests.business.place.domain.model.SeatEntity
import com.tkluza.spring.efficientunittests.business.place.test.PlaceTestFactory
import com.tkluza.spring.efficientunittests.common.BaseTest
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.EntityNotFoundException

class PlaceFacadeTest : BaseTest() {

    @Autowired
    private lateinit var placeFacade: PlaceFacade

    @Nested
    inner class PlaceTests {

        @Test
        fun `should find place by name`() {
            // given
            val placeName = "Allianz Arena"

            // when
            val placeQuery = placeFacade.findPlaceByName(placeName)

            // then
            assertSoftly(placeQuery) {
                name shouldBe placeName
                address shouldBe "Werner-Heisenberg-Allee 25, 80939 München"
            }
        }

        @Test
        fun `should find place by id - other possibility`() {
            // given
            val place = testDataContext["P-1", PlaceEntity::class.java]!!

            // when
            val placeQuery = placeFacade.findPlaceByName(placeName = place.name)

            // then
            assertSoftly(placeQuery) {
                id shouldBe place.id
                name shouldBe place.name
                address shouldBe place.address
            }
        }

        @Test
        fun `should find another place by id`() {
            // given
            PlaceTestFactory.savePlaces(
                placeRows = arrayOf(
                    "| KEY | Name                  | Address                                  |",
                    "| P-3 | Madison Square Garden | 4 Pennsylvania Plaza, New York, NY 10001 |",
                ),
                testDataContext = testDataContext
            )
            val place = testDataContext["P-3", PlaceEntity::class.java]!!

            // when
            val placeQuery = placeFacade.findPlaceByName(placeName = place.name)

            // then
            assertSoftly(placeQuery) {
                id shouldBe place.id
                name shouldBe place.name
                address shouldBe place.address
            }
        }

        @Test
        fun `should throw exception if place by a given name was not found`() {
            // given
            val placeName = "Helm's Deep"

            // when & then
            shouldThrow<EntityNotFoundException> {
                placeFacade.findPlaceByName(placeName)
            }
        }
    }

    @Nested
    inner class SeatTests {

        @Test
        fun `should find seat by id`() {
            // given
            val seatEntity = testDataContext["S-1", SeatEntity::class.java]!!

            // when
            val seatQuery = placeFacade.findSeatById(seatEntity.id)

            // then
            assertSoftly(seatQuery) {
                id shouldBe seatEntity.id
                placeId shouldBe seatEntity.placeId
                section shouldBe "A"
                rowNumber shouldBe 1
                seatNumber shouldBe 5
                isStanding shouldBe false
            }
        }

        @Test
        fun `should throw exception if seat by id was not found`() {
            // given
            val seatId = Long.MAX_VALUE

            // when & then
            assertThrows<EntityNotFoundException> {
                placeFacade.findSeatById(seatId)
            }
        }

        // TODO - Nested class for parametrized tests - let us benchmark it!
    }
}
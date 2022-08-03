package com.tkluza.spring.efficientunittests.business.event.test

import com.tkluza.spring.efficientunittests.business.event.domain.model.EventEntity
import com.tkluza.spring.efficientunittests.business.event.domain.model.TicketEntity
import com.tkluza.spring.efficientunittests.business.place.domain.model.PlaceEntity
import com.tkluza.spring.efficientunittests.business.place.domain.model.SeatEntity
import com.tkluza.spring.efficientunittests.business.user.domain.model.UserEntity
import com.tkluza.spring.efficientunittests.common.test.TestDataContext
import com.tkluza.spring.efficientunittests.common.test.factory.TestFactory
import java.math.BigDecimal
import java.time.LocalDateTime

object EventTestFactory {

    private const val COLUMN_PLACE = "Place"
    private const val COLUMN_NAME = "Name"
    private const val COLUMN_DATE = "Date"
    private const val COLUMN_EVENT = "Event"
    private const val COLUMN_SEAT = "Seat"
    private const val COLUMN_USER = "User"
    private const val COLUMN_PRICE = "Price"
    private const val COLUMN_SALE_DATE = "Sale date"

    /**
     * Structure for [EventEntity] in tests
     *
     * | KEY | Place | Name | Date |
     */
    fun saveEvents(placeRows: Array<String>, testDataContext: TestDataContext) {
        TestFactory.saveTestData(
            rows = placeRows,
            testDataContext = testDataContext,
            singleEntityCreator = this::createEvent
        )
    }

    private fun createEvent(userRow: Map<String, String>, testDataContext: TestDataContext): EventEntity {
        val placeEntity = testDataContext[userRow.getValue(COLUMN_PLACE), PlaceEntity::class.java]!!
        return EventEntity(
            placeId = placeEntity.id,
            placeEntity = placeEntity,
            name = userRow[COLUMN_NAME] ?: "",
            date = LocalDateTime.parse(userRow[COLUMN_DATE])
        )
    }

    /**
     * Structure for [TicketEntity] in tests
     *
     * | KEY | Event | Seat | User | Price | Sale date |
     */
    fun saveTickets(placeRows: Array<String>, testDataContext: TestDataContext) {
        TestFactory.saveTestData(
            rows = placeRows,
            testDataContext = testDataContext,
            singleEntityCreator = this::createTicket
        )
    }

    private fun createTicket(userRow: Map<String, String>, testDataContext: TestDataContext): TicketEntity {
        val eventEntity = testDataContext[userRow.getValue(COLUMN_EVENT), EventEntity::class.java]!!
        val seatEntity = testDataContext[userRow.getValue(COLUMN_SEAT), SeatEntity::class.java]!!
        val userEntity = testDataContext[userRow.getValue(COLUMN_USER), UserEntity::class.java]
        return TicketEntity(
            eventId = eventEntity.id,
            eventEntity = eventEntity,
            seatId = seatEntity.id,
            userId = userEntity?.id,
            price = BigDecimal(userRow[COLUMN_PRICE]),
            saleDate = userRow[COLUMN_SALE_DATE]?.run { if (isNotBlank()) LocalDateTime.parse(this) else null }
        )
    }
}
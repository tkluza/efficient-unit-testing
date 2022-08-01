package com.tkluza.spring.efficientunittests.business.place.test

import com.tkluza.spring.efficientunittests.business.place.domain.model.PlaceEntity
import com.tkluza.spring.efficientunittests.business.place.domain.model.SeatEntity
import com.tkluza.spring.efficientunittests.common.test.TestContext
import com.tkluza.spring.efficientunittests.common.test.factory.TestFactory

object PlaceTestFactory {

    private const val COLUMN_NAME = "Name"
    private const val COLUMN_ADDRESS = "Address"
    private const val COLUMN_PLACE = "Place"
    private const val COLUMN_SECTION = "Section"
    private const val COLUMN_ROW_NUMBER = "Row number"
    private const val COLUMN_SEAT_NUMBER = "Seat number"

    /**
     * Structure for [PlaceEntity] in tests
     * <p>
     * | KEY | First name | Last name | Email |
     */
    fun savePlaces(placeRows: Array<String>, testContext: TestContext) {
        TestFactory.saveTestData(
            rows = placeRows,
            testContext = testContext,
            singleEntityCreator = this::createPlace
        )
    }

    private fun createPlace(userRow: Map<String, String>, testContext: TestContext): PlaceEntity =
        PlaceEntity(
            name = userRow[COLUMN_NAME] ?: "",
            address = userRow[COLUMN_ADDRESS] ?: "",
        )

    /**
     * Structure for [PlaceEntity] in tests
     * <p>
     * | KEY | Place | Section | Row number | Seat number |
     */
    fun saveSeats(placeRows: Array<String>, testContext: TestContext) {
        TestFactory.saveTestData(
            rows = placeRows,
            testContext = testContext,
            singleEntityCreator = this::createPlace
        )
    }

    private fun createSeat(userRow: Map<String, String>, testContext: TestContext): SeatEntity {
        val placeEntity = testContext[userRow.getValue(COLUMN_PLACE), PlaceEntity::class.java]!!
        return SeatEntity(
            placeId = placeEntity.id,
            placeEntity = placeEntity,
            section = userRow[COLUMN_SECTION],
            rowNumber = userRow[COLUMN_ROW_NUMBER]?.toInt(),
            seatNumber = userRow[COLUMN_SEAT_NUMBER]?.toInt() ?: 0,
        )
    }
}
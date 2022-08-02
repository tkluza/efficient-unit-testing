package com.tkluza.spring.efficientunittests.business.place.domain

import com.tkluza.spring.efficientunittests.business.place.dto.query.PlaceQuery
import com.tkluza.spring.efficientunittests.business.place.dto.query.SeatQuery

/**
 * Main facade for Place domain
 */
interface PlaceFacade {

    /**
     * Finds [PlaceQuery] by its name
     */
    fun findPlaceByName(placeName: String): PlaceQuery

    /**
     * Finds [SeatQuery] by its id
     */
    fun findSeatById(seatId: Long): SeatQuery
}
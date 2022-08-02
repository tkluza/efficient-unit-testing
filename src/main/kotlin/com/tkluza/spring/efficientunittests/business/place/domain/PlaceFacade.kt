package com.tkluza.spring.efficientunittests.business.place.domain

import com.tkluza.spring.efficientunittests.business.place.dto.query.PlaceQuery
import com.tkluza.spring.efficientunittests.business.place.dto.query.SeatQuery

interface PlaceFacade {

    fun findPlaceByName(name: String): PlaceQuery

    fun findSeatById(id: Long): SeatQuery
}
package com.tkluza.spring.efficientunittests.business.place.domain

import com.tkluza.spring.efficientunittests.business.place.domain.service.PlaceService
import com.tkluza.spring.efficientunittests.business.place.domain.service.SeatService
import com.tkluza.spring.efficientunittests.business.place.dto.query.PlaceQuery
import com.tkluza.spring.efficientunittests.business.place.dto.query.SeatQuery

class PlaceFacadeAdapter(
    private val placeService: PlaceService,
    private val seatService: SeatService
) : PlaceFacade {

    override fun findPlaceByName(name: String): PlaceQuery =
        placeService.findPlaceByName(name)

    override fun findSeatById(id: Long): SeatQuery =
        seatService.findSeatById(id)
}
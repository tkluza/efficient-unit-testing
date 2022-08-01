package com.tkluza.spring.efficientunittests.business.place.domain

import com.tkluza.spring.efficientunittests.business.place.domain.service.PlaceService
import com.tkluza.spring.efficientunittests.business.place.domain.service.SeatService

class PlaceFacadeAdapter(
    private val placeService: PlaceService,
    private val seatService: SeatService
) : PlaceFacade {
}
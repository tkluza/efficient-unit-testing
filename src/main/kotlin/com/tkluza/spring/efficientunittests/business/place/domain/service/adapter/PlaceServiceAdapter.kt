package com.tkluza.spring.efficientunittests.business.place.domain.service.adapter

import com.tkluza.spring.efficientunittests.business.place.domain.repository.PlaceRepository
import com.tkluza.spring.efficientunittests.business.place.domain.service.PlaceService

class PlaceServiceAdapter(
    private val placeRepository: PlaceRepository
) : PlaceService {
}
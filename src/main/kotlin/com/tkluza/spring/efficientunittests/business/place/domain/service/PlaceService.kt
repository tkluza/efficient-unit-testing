package com.tkluza.spring.efficientunittests.business.place.domain.service

import com.tkluza.spring.efficientunittests.business.place.dto.query.PlaceQuery

interface PlaceService {

    fun findPlaceByName(name: String): PlaceQuery
}
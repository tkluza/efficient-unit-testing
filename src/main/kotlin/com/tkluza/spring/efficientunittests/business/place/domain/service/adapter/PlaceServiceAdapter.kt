package com.tkluza.spring.efficientunittests.business.place.domain.service.adapter

import com.tkluza.spring.efficientunittests.business.place.domain.mapper.PlaceMapper
import com.tkluza.spring.efficientunittests.business.place.domain.repository.PlaceRepository
import com.tkluza.spring.efficientunittests.business.place.domain.service.PlaceService
import com.tkluza.spring.efficientunittests.business.place.dto.query.PlaceQuery
import javax.persistence.EntityNotFoundException

class PlaceServiceAdapter(
    private val placeRepository: PlaceRepository,
    private val placeMapper: PlaceMapper
) : PlaceService {

    override fun findPlaceByName(name: String): PlaceQuery =
        placeRepository.findByName(name)
            .map { placeMapper.map(it) }
            .orElseThrow { EntityNotFoundException("[PlaceEntity] with [Name]: $name was not found.") }
}
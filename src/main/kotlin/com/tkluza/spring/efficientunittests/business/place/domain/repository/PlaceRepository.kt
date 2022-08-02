package com.tkluza.spring.efficientunittests.business.place.domain.repository

import com.tkluza.spring.efficientunittests.business.place.domain.model.PlaceEntity
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface PlaceRepository : CrudRepository<PlaceEntity, Long> {

    fun findByName(name: String): Optional<PlaceEntity>
}
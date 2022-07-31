package com.tkluza.spring.efficientunittests.business.place.domain.repository

import com.tkluza.spring.efficientunittests.business.place.domain.model.PlaceEntity
import org.springframework.data.repository.CrudRepository

interface PlaceRepository : CrudRepository<PlaceEntity, Long>
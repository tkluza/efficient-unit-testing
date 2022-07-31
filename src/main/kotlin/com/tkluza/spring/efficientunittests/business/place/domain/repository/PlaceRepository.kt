package com.tkluza.spring.efficientunittests.business.place.domain.repository

import com.tkluza.spring.efficientunittests.business.place.domain.model.PlaceEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PlaceRepository : JpaRepository<PlaceEntity, Long>
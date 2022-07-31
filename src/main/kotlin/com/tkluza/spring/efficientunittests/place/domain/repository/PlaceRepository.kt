package com.tkluza.spring.efficientunittests.place.domain.repository

import com.tkluza.spring.efficientunittests.place.domain.model.PlaceEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PlaceRepository : JpaRepository<PlaceEntity, Long>
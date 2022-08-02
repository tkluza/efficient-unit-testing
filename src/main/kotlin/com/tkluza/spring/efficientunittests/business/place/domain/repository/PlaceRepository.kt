package com.tkluza.spring.efficientunittests.business.place.domain.repository

import com.tkluza.spring.efficientunittests.business.place.domain.model.PlaceEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface PlaceRepository : CrudRepository<PlaceEntity, Long> {

    @Query("SELECT p FROM PlaceEntity p WHERE p.name = #{name}")
    fun findByName(name: String): Optional<PlaceEntity>
}
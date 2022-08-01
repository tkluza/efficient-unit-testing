package com.tkluza.spring.efficientunittests.business.place.domain.repository

import com.tkluza.spring.efficientunittests.business.place.domain.model.SeatEntity
import org.springframework.data.repository.CrudRepository

interface SeatRepository : CrudRepository<SeatEntity, Long>
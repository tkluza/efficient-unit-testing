package com.tkluza.spring.efficientunittests.business.event.domain.repository

import com.tkluza.spring.efficientunittests.business.event.domain.model.EventEntity
import org.springframework.data.repository.CrudRepository

interface EventRepository : CrudRepository<EventEntity, Long>
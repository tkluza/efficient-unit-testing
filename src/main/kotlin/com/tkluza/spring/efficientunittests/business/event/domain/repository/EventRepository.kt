package com.tkluza.spring.efficientunittests.business.event.domain.repository

import com.tkluza.spring.efficientunittests.business.event.domain.model.EventEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository : JpaRepository<EventEntity, Long>
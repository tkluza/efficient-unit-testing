package com.tkluza.spring.efficientunittests.business.place.domain.repository

import com.tkluza.spring.efficientunittests.business.event.domain.model.TicketEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TicketRepository : JpaRepository<TicketEntity, Long>
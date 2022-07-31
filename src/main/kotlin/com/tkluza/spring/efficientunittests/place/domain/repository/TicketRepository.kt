package com.tkluza.spring.efficientunittests.place.domain.repository

import com.tkluza.spring.efficientunittests.event.domain.model.TicketEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TicketRepository : JpaRepository<TicketEntity, Long>
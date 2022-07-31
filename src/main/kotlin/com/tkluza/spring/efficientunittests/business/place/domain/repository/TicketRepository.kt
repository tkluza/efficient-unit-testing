package com.tkluza.spring.efficientunittests.business.place.domain.repository

import com.tkluza.spring.efficientunittests.business.event.domain.model.TicketEntity
import org.springframework.data.repository.CrudRepository

interface TicketRepository : CrudRepository<TicketEntity, Long>
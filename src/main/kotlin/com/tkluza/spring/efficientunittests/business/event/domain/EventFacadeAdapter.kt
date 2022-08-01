package com.tkluza.spring.efficientunittests.business.event.domain

import com.tkluza.spring.efficientunittests.business.event.domain.service.EventService
import com.tkluza.spring.efficientunittests.business.event.domain.service.TicketService

class EventFacadeAdapter(
    private val eventService: EventService,
    private val ticketService: TicketService
) : EventFacade {
}
package com.tkluza.spring.efficientunittests.business.event.domain.service.adapter

import com.tkluza.spring.efficientunittests.business.event.domain.repository.TicketRepository
import com.tkluza.spring.efficientunittests.business.event.domain.service.TicketService

class TicketServiceAdapter(
    private val ticketRepository: TicketRepository
) : TicketService {
}
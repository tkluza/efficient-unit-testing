package com.tkluza.spring.efficientunittests.business.event.domain

import com.tkluza.spring.efficientunittests.business.event.domain.service.TicketService
import com.tkluza.spring.efficientunittests.business.event.dto.command.BuyTicketCommand
import com.tkluza.spring.efficientunittests.business.event.dto.command.result.BuyTicketResult

class EventFacadeAdapter(
    private val ticketService: TicketService
) : EventFacade {

    override fun buyTicket(command: BuyTicketCommand): BuyTicketResult =
        ticketService.buyTicket(command)
}
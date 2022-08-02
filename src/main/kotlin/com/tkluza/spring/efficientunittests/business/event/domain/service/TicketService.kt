package com.tkluza.spring.efficientunittests.business.event.domain.service

import com.tkluza.spring.efficientunittests.business.event.dto.command.BuyTicketCommand
import com.tkluza.spring.efficientunittests.business.event.dto.command.result.BuyTicketResult

interface TicketService {

    fun buyTicket(command: BuyTicketCommand): BuyTicketResult
}
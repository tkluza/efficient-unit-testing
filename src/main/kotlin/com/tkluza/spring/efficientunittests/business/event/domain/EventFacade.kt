package com.tkluza.spring.efficientunittests.business.event.domain

import com.tkluza.spring.efficientunittests.business.event.dto.command.BuyTicketCommand
import com.tkluza.spring.efficientunittests.business.event.dto.command.result.BuyTicketResult

/**
 * Main facade for Event domain
 */
interface EventFacade {

    /**
     * Buys ticket with required information in form of [BuyTicketCommand].
     * Result contains response to this command in form of [BuyTicketResult]
     */
    fun buyTicket(command: BuyTicketCommand): BuyTicketResult
}
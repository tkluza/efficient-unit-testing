package com.tkluza.spring.efficientunittests.business.event.domain.service.adapter

import com.tkluza.spring.efficientunittests.business.event.domain.exception.TicketAlreadySoldException
import com.tkluza.spring.efficientunittests.business.event.domain.gateway.EventGateway
import com.tkluza.spring.efficientunittests.business.event.domain.model.TicketEntity
import com.tkluza.spring.efficientunittests.business.event.domain.repository.TicketRepository
import com.tkluza.spring.efficientunittests.business.event.domain.service.TicketService
import com.tkluza.spring.efficientunittests.business.event.dto.command.BuyTicketCommand
import com.tkluza.spring.efficientunittests.business.event.dto.command.result.BuyTicketResult
import com.tkluza.spring.efficientunittests.business.place.dto.query.SeatQuery
import com.tkluza.spring.efficientunittests.business.user.dto.query.UserQuery
import java.time.LocalDateTime
import javax.persistence.EntityNotFoundException

class TicketServiceAdapter(
    private val eventGateway: EventGateway,
    private val ticketRepository: TicketRepository
) : TicketService {

    override fun buyTicket(command: BuyTicketCommand): BuyTicketResult {
        val ticketEntity: TicketEntity = findTicketById(command.ticketId)
        val user: UserQuery = eventGateway.findUserById(command.userId)
        val seat: SeatQuery = eventGateway.findSeatById(command.seatId)

        validateTicket(ticket = ticketEntity)

        updateTicket(
            ticket = ticketEntity,
            userId = user.id,
            seatId = seat.id
        )

        with(ticketEntity) {
            return BuyTicketResult(
                eventName = eventEntity.name,
                placeName = seat.placeName,
                seatInfo = seat.seatInfo,
                userFullName = user.userFullName,
                price = price,
                saleDate = saleDate ?: LocalDateTime.now()
            )
        }
    }

    private fun findTicketById(ticketId: Long) =
        ticketRepository.findById(ticketId)
            .orElseThrow { EntityNotFoundException("[TicketEntity] with [Id]: $ticketId was not found.") }

    private fun updateTicket(ticket: TicketEntity, userId: Long, seatId: Long): TicketEntity =
        ticket.apply {
            this.userId = userId
            this.seatId = seatId
            this.saleDate = LocalDateTime.now()
        }

    private fun validateTicket(ticket: TicketEntity) {
        if (ticket.isSold()) {
            throw TicketAlreadySoldException("[Ticket] with [Id]: ${ticket.id} was already sold.")
        }
    }
}
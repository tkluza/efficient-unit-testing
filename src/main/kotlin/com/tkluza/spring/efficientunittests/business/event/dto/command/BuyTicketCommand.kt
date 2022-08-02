package com.tkluza.spring.efficientunittests.business.event.dto.command

data class BuyTicketCommand(
    val ticketId: Long,
    val seatId: Long,
    val userId: Long
)

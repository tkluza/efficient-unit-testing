package com.tkluza.spring.efficientunittests.business.event.dto.command.result

import java.math.BigDecimal
import java.time.LocalDateTime

data class BuyTicketResult(
    val eventName: String,
    val placeName: String,
    val seatInfo: String,
    val userFullName: String,
    val price: BigDecimal,
    val saleDate: LocalDateTime,
)

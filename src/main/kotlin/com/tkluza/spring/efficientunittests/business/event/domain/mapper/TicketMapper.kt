package com.tkluza.spring.efficientunittests.business.event.domain.mapper

import com.tkluza.spring.efficientunittests.business.event.domain.model.TicketEntity
import com.tkluza.spring.efficientunittests.business.event.dto.command.result.BuyTicketResult
import com.tkluza.spring.efficientunittests.business.place.dto.query.SeatQuery
import com.tkluza.spring.efficientunittests.business.user.dto.query.UserQuery
import java.time.LocalDateTime

class TicketMapper {

    fun mapToBuyTicketResult(ticketEntity: TicketEntity, userQuery: UserQuery, seatQuery: SeatQuery): BuyTicketResult =
        with(ticketEntity) {
            BuyTicketResult(
                eventName = eventEntity.name,
                placeName = seatQuery.placeName,
                seatInfo = seatQuery.seatInfo,
                userFullName = userQuery.userFullName,
                price = price,
                saleDate = saleDate ?: LocalDateTime.now()
            )
        }
}
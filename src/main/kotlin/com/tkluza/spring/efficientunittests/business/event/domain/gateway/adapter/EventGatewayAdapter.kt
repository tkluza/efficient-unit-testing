package com.tkluza.spring.efficientunittests.business.event.domain.gateway.adapter

import com.tkluza.spring.efficientunittests.business.event.domain.gateway.EventGateway
import com.tkluza.spring.efficientunittests.business.place.domain.PlaceFacade
import com.tkluza.spring.efficientunittests.business.place.dto.query.SeatQuery
import com.tkluza.spring.efficientunittests.business.user.domain.UserFacade
import com.tkluza.spring.efficientunittests.business.user.dto.query.UserQuery

class EventGatewayAdapter(
    private val placeFacade: PlaceFacade,
    private val userFacade: UserFacade,
) : EventGateway {

    override fun findSeatById(seatId: Long): SeatQuery =
        placeFacade.findSeatById(seatId)

    override fun findUserById(userId: Long): UserQuery =
        userFacade.findUserById(userId)
}
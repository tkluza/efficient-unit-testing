package com.tkluza.spring.efficientunittests.business.event.domain.gateway

import com.tkluza.spring.efficientunittests.business.place.dto.query.SeatQuery
import com.tkluza.spring.efficientunittests.business.user.dto.query.UserQuery

/**
 * Gateway to provide communication with other domains
 */
interface EventGateway {

    fun findSeatById(seatId: Long): SeatQuery

    fun findUserById(userId: Long): UserQuery
}
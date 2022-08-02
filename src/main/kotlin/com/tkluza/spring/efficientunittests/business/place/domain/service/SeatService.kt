package com.tkluza.spring.efficientunittests.business.place.domain.service

import com.tkluza.spring.efficientunittests.business.place.dto.query.SeatQuery

interface SeatService {

    fun findSeatById(id: Long): SeatQuery
}
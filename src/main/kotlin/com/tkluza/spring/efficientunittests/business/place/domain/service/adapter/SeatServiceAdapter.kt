package com.tkluza.spring.efficientunittests.business.place.domain.service.adapter

import com.tkluza.spring.efficientunittests.business.place.domain.repository.SeatRepository
import com.tkluza.spring.efficientunittests.business.place.domain.service.SeatService

class SeatServiceAdapter(
    private val seatRepository: SeatRepository
) : SeatService {
}
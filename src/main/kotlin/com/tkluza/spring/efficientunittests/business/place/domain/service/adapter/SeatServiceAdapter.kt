package com.tkluza.spring.efficientunittests.business.place.domain.service.adapter

import com.tkluza.spring.efficientunittests.business.place.domain.mapper.SeatMapper
import com.tkluza.spring.efficientunittests.business.place.domain.repository.SeatRepository
import com.tkluza.spring.efficientunittests.business.place.domain.service.SeatService
import com.tkluza.spring.efficientunittests.business.place.dto.query.SeatQuery
import javax.persistence.EntityNotFoundException

class SeatServiceAdapter(
    private val seatRepository: SeatRepository,
    private val seatMapper: SeatMapper
) : SeatService {

    override fun findSeatById(id: Long): SeatQuery =
        seatRepository.findById(id)
            .map { seatMapper.map(it) }
            .orElseThrow { EntityNotFoundException("[SeatEntity] with [Id]: $id was not found.") }
}
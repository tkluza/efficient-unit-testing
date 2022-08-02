package com.tkluza.spring.efficientunittests.business.place.domain.mapper

import com.tkluza.spring.efficientunittests.business.place.domain.model.SeatEntity
import com.tkluza.spring.efficientunittests.business.place.dto.query.SeatQuery
import com.tkluza.spring.efficientunittests.common.mapper.BaseMapper

class SeatMapper : BaseMapper<SeatEntity, SeatQuery> {

    override fun map(input: SeatEntity): SeatQuery =
        with(input) {
            SeatQuery(
                id = id,
                placeId = placeId,
                placeName = placeEntity.name,
                section = section,
                rowNumber = rowNumber,
                seatNumber = seatNumber,
                isStanding = isStanding
            )
        }
}
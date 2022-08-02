package com.tkluza.spring.efficientunittests.business.place.domain.mapper

import com.tkluza.spring.efficientunittests.business.place.domain.model.PlaceEntity
import com.tkluza.spring.efficientunittests.business.place.dto.query.PlaceQuery
import com.tkluza.spring.efficientunittests.common.mapper.BaseMapper

class PlaceMapper : BaseMapper<PlaceEntity, PlaceQuery> {

    override fun map(input: PlaceEntity): PlaceQuery =
        with(input) {
            PlaceQuery(
                id = id,
                name = name,
                address = address
            )
        }
}
package com.tkluza.spring.efficientunittests.business.place.test

import com.tkluza.spring.efficientunittests.business.place.domain.model.SeatEntity
import com.tkluza.spring.efficientunittests.common.test.id.IdGenerator
import com.tkluza.spring.efficientunittests.common.test.inmemory.InMemoryRepository

class SeatInMemoryRepository(
    idGenerator: IdGenerator<Long>
) : InMemoryRepository<SeatEntity, Long>(
    entityClass = SeatEntity::class.java,
    idGenerator = idGenerator,
    keyPrefix = "S"
)
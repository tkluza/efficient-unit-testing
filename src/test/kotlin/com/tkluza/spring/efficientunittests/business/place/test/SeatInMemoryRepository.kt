package com.tkluza.spring.efficientunittests.business.place.test

import com.tkluza.spring.efficientunittests.business.place.domain.model.SeatEntity
import com.tkluza.spring.efficientunittests.common.test.id.IdGenerator
import com.tkluza.spring.efficientunittests.common.test.inmemory.InMemoryTestDataRepository

class SeatInMemoryRepository(
    idGenerator: IdGenerator<Long>
) : InMemoryTestDataRepository<SeatEntity, Long>(
    entityClass = SeatEntity::class.java,
    idGenerator = idGenerator,
    keyPrefix = "S"
)
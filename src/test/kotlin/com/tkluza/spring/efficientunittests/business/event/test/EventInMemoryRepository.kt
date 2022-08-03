package com.tkluza.spring.efficientunittests.business.event.test

import com.tkluza.spring.efficientunittests.business.event.domain.model.EventEntity
import com.tkluza.spring.efficientunittests.common.test.id.IdGenerator
import com.tkluza.spring.efficientunittests.common.test.inmemory.InMemoryTestDataRepository

class EventInMemoryRepository(
    idGenerator: IdGenerator<Long>
) : InMemoryTestDataRepository<EventEntity, Long>(
    entityClass = EventEntity::class.java,
    idGenerator = idGenerator,
    keyPrefix = "E"
)
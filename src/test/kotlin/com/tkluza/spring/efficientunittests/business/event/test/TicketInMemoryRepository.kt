package com.tkluza.spring.efficientunittests.business.event.test

import com.tkluza.spring.efficientunittests.business.event.domain.model.TicketEntity
import com.tkluza.spring.efficientunittests.common.test.id.IdGenerator
import com.tkluza.spring.efficientunittests.common.test.inmemory.InMemoryTestDataRepository

class TicketInMemoryRepository(
    idGenerator: IdGenerator<Long>
) : InMemoryTestDataRepository<TicketEntity, Long>(
    entityClass = TicketEntity::class.java,
    idGenerator = idGenerator,
    keyPrefix = "T"
)
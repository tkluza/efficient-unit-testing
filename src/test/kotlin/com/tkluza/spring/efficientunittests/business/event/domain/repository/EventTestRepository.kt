package com.tkluza.spring.efficientunittests.business.event.domain.repository

import com.tkluza.spring.efficientunittests.business.event.domain.model.EventEntity
import com.tkluza.spring.efficientunittests.common.repository.CrudTestRepository
import com.tkluza.spring.efficientunittests.common.test.TestContext

class EventTestRepository(
    testContext: TestContext
) : CrudTestRepository<EventEntity, Long>(testContext = testContext, entityClass = EventEntity::class.java),
    EventRepository
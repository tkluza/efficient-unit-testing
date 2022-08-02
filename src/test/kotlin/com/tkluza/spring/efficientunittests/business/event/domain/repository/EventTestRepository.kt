package com.tkluza.spring.efficientunittests.business.event.domain.repository

import com.tkluza.spring.efficientunittests.business.event.domain.model.EventEntity
import com.tkluza.spring.efficientunittests.common.repository.CrudTestRepository
import com.tkluza.spring.efficientunittests.common.test.TestDataContext

class EventTestRepository(
    testDataContext: TestDataContext
) : CrudTestRepository<EventEntity, Long>(testDataContext = testDataContext, entityClass = EventEntity::class.java),
    EventRepository
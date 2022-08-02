package com.tkluza.spring.efficientunittests.business.event.domain.repository

import com.tkluza.spring.efficientunittests.business.event.domain.model.TicketEntity
import com.tkluza.spring.efficientunittests.common.repository.CrudTestRepository
import com.tkluza.spring.efficientunittests.common.test.TestDataContext

class TicketTestRepository(
    testDataContext: TestDataContext
) : CrudTestRepository<TicketEntity, Long>(testDataContext = testDataContext, entityClass = TicketEntity::class.java),
    TicketRepository
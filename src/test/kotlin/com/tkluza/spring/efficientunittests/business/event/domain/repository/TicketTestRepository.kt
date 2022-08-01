package com.tkluza.spring.efficientunittests.business.event.domain.repository

import com.tkluza.spring.efficientunittests.business.event.domain.model.TicketEntity
import com.tkluza.spring.efficientunittests.common.repository.CrudTestRepository
import com.tkluza.spring.efficientunittests.common.test.TestContext

class TicketTestRepository(
    testContext: TestContext
) : CrudTestRepository<TicketEntity, Long>(testContext = testContext, entityClass = TicketEntity::class.java),
    TicketRepository
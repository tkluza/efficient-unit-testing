package com.tkluza.spring.efficientunittests.business.place.domain.repository

import com.tkluza.spring.efficientunittests.business.place.domain.model.SeatEntity
import com.tkluza.spring.efficientunittests.common.repository.CrudTestRepository
import com.tkluza.spring.efficientunittests.common.test.TestContext

class SeatTestRepository(
    testContext: TestContext
) : CrudTestRepository<SeatEntity, Long>(testContext = testContext, entityClass = SeatEntity::class.java),
    SeatRepository
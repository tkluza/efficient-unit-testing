package com.tkluza.spring.efficientunittests.business.place.domain.repository

import com.tkluza.spring.efficientunittests.business.place.domain.model.SeatEntity
import com.tkluza.spring.efficientunittests.common.repository.CrudTestRepository
import com.tkluza.spring.efficientunittests.common.test.TestDataContext

class SeatTestRepository(
    testDataContext: TestDataContext
) : CrudTestRepository<SeatEntity, Long>(testDataContext = testDataContext, entityClass = SeatEntity::class.java),
    SeatRepository
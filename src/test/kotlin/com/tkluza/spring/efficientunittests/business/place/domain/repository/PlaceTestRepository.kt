package com.tkluza.spring.efficientunittests.business.place.domain.repository

import com.tkluza.spring.efficientunittests.business.place.domain.model.PlaceEntity
import com.tkluza.spring.efficientunittests.common.repository.CrudTestRepository
import com.tkluza.spring.efficientunittests.common.test.TestContext

class PlaceTestRepository(
    testContext: TestContext
) : CrudTestRepository<PlaceEntity, Long>(testContext = testContext, entityClass = PlaceEntity::class.java),
    PlaceRepository
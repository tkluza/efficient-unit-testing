package com.tkluza.spring.efficientunittests.business.place.domain.repository

import com.tkluza.spring.efficientunittests.business.place.domain.model.PlaceEntity
import com.tkluza.spring.efficientunittests.common.repository.CrudTestRepository
import com.tkluza.spring.efficientunittests.common.test.TestDataContext
import java.util.Optional

class PlaceTestRepository(
    testDataContext: TestDataContext
) : CrudTestRepository<PlaceEntity, Long>(testDataContext = testDataContext, entityClass = PlaceEntity::class.java),
    PlaceRepository {

    override fun findByName(name: String): Optional<PlaceEntity> =
        Optional.ofNullable(
            testDataContext.findAll(entityClass)
                .find { it.name == name }
        )
}

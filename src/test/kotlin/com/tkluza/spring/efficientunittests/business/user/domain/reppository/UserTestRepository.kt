package com.tkluza.spring.efficientunittests.business.user.domain.reppository

import com.tkluza.spring.efficientunittests.business.user.domain.model.UserEntity
import com.tkluza.spring.efficientunittests.business.user.domain.repository.UserRepository
import com.tkluza.spring.efficientunittests.common.repository.CrudTestRepository
import com.tkluza.spring.efficientunittests.common.test.TestDataContext

class UserTestRepository(
    testDataContext: TestDataContext
) : CrudTestRepository<UserEntity, Long>(testDataContext = testDataContext, entityClass = UserEntity::class.java),
    UserRepository
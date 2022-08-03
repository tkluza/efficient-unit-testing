package com.tkluza.spring.efficientunittests.business.user.test

import com.tkluza.spring.efficientunittests.business.user.domain.model.UserEntity
import com.tkluza.spring.efficientunittests.common.test.id.IdGenerator
import com.tkluza.spring.efficientunittests.common.test.inmemory.InMemoryTestDataRepository

class UserInMemoryRepository(
    idGenerator: IdGenerator<Long>
) : InMemoryTestDataRepository<UserEntity, Long>(
    entityClass = UserEntity::class.java,
    idGenerator = idGenerator,
    keyPrefix = "U"
)
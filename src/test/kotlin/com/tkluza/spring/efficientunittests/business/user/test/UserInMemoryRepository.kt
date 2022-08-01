package com.tkluza.spring.efficientunittests.business.user.test

import com.tkluza.spring.efficientunittests.business.user.domain.model.UserEntity
import com.tkluza.spring.efficientunittests.common.test.id.IdGenerator
import com.tkluza.spring.efficientunittests.common.test.inmemory.InMemoryRepository

class UserInMemoryRepository(
    idGenerator: IdGenerator<Long>
) : InMemoryRepository<UserEntity, Long>(
    entityClass = UserEntity::class.java,
    idGenerator = idGenerator,
    keyPrefix = "U"
)
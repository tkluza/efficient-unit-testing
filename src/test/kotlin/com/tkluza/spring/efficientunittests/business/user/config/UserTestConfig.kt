package com.tkluza.spring.efficientunittests.business.user.config

import com.tkluza.spring.efficientunittests.business.user.domain.repository.UserRepository
import com.tkluza.spring.efficientunittests.business.user.domain.reppository.UserTestRepository
import com.tkluza.spring.efficientunittests.business.user.test.UserInMemoryRepository
import com.tkluza.spring.efficientunittests.common.test.TestContext
import com.tkluza.spring.efficientunittests.common.test.id.IdGenerator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

@Import(UserConfig::class)
class UserTestConfig {

    @Bean
    fun userRepository(testContext: TestContext): UserRepository =
        UserTestRepository(testContext)

    @Bean
    fun userInMemoryTestRepository(idGenerator: IdGenerator<Long>): UserInMemoryRepository =
        UserInMemoryRepository(idGenerator)
}
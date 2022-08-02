package com.tkluza.spring.efficientunittests.common.config

import com.tkluza.spring.efficientunittests.common.test.TestContext
import com.tkluza.spring.efficientunittests.common.test.TestRepository
import com.tkluza.spring.efficientunittests.common.test.id.IdGenerator
import com.tkluza.spring.efficientunittests.common.test.id.LongIdGenerator
import com.tkluza.spring.efficientunittests.common.test.inmemory.InMemoryTestContext
import org.springframework.context.annotation.Bean

class BaseTestConfig {

    @Bean
    fun idGenerator(): IdGenerator<Long> = LongIdGenerator()

    @Bean
    fun testContext(testRepositories: List<TestRepository<*, *>>): TestContext =
        InMemoryTestContext(testRepositories)
}
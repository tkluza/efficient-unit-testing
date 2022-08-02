package com.tkluza.spring.efficientunittests.common.config

import com.tkluza.spring.efficientunittests.common.test.TestDataContext
import com.tkluza.spring.efficientunittests.common.test.TestDataRepository
import com.tkluza.spring.efficientunittests.common.test.id.IdGenerator
import com.tkluza.spring.efficientunittests.common.test.id.LongIdGenerator
import com.tkluza.spring.efficientunittests.common.test.inmemory.InMemoryTestDataContext
import org.springframework.context.annotation.Bean

class BaseTestConfig {

    @Bean
    fun idGenerator(): IdGenerator<Long> = LongIdGenerator()

    @Bean
    fun testContext(testRepositories: List<TestDataRepository<*, *>>): TestDataContext =
        InMemoryTestDataContext(testRepositories)
}
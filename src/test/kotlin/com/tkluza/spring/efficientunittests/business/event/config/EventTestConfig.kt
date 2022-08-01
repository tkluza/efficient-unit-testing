package com.tkluza.spring.efficientunittests.business.event.config

import com.tkluza.spring.efficientunittests.business.event.domain.repository.EventRepository
import com.tkluza.spring.efficientunittests.business.event.domain.repository.EventTestRepository
import com.tkluza.spring.efficientunittests.business.event.domain.repository.TicketRepository
import com.tkluza.spring.efficientunittests.business.event.domain.repository.TicketTestRepository
import com.tkluza.spring.efficientunittests.business.event.test.EventInMemoryRepository
import com.tkluza.spring.efficientunittests.business.event.test.TicketInMemoryRepository
import com.tkluza.spring.efficientunittests.common.test.TestContext
import com.tkluza.spring.efficientunittests.common.test.id.IdGenerator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

@Import(EventConfig::class)
class EventTestConfig {

    @Bean
    fun eventRepository(testContext: TestContext): EventRepository =
        EventTestRepository(testContext)

    @Bean
    fun ticketRepository(testContext: TestContext): TicketRepository =
        TicketTestRepository(testContext)

    @Bean
    fun eventInMemoryTestRepository(idGenerator: IdGenerator<Long>): EventInMemoryRepository =
        EventInMemoryRepository(idGenerator)

    @Bean
    fun ticketInMemoryTestRepository(idGenerator: IdGenerator<Long>): TicketInMemoryRepository =
        TicketInMemoryRepository(idGenerator)
}
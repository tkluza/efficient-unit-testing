package com.tkluza.spring.efficientunittests.business.event.domain

import com.tkluza.spring.efficientunittests.common.BaseTest
import org.springframework.beans.factory.annotation.Autowired

internal class EventFacadeTest : BaseTest() {

    @Autowired
    private lateinit var eventFacade: EventFacade

    // TODO - Custom @BeforeEach with additional event test data
    // TODO - Nested class for main business logic
    // TODO - Nested class for testing gateway
}
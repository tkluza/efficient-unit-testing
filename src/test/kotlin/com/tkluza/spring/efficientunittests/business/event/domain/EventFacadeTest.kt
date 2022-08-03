package com.tkluza.spring.efficientunittests.business.event.domain

import com.tkluza.spring.efficientunittests.business.event.test.EventTestFactory
import com.tkluza.spring.efficientunittests.common.BaseTest
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired

internal class EventFacadeTest : BaseTest() {

    @Autowired
    private lateinit var eventFacade: EventFacade

    @BeforeEach
    override fun init() {
        super.init()

        EventTestFactory.saveEvents(
            placeRows = arrayOf(
                "| KEY | Place | Name         | Date             |",
                "| E-1 | P-1   | Beer wih Us! | 2022-09-15T19:00 |"
            ),
            testDataContext = testDataContext
        )

        EventTestFactory.saveTickets(
            placeRows = arrayOf(
                "| KEY | Event | Seat | User | Price | Sale date         |",
                "| T-1 | E-1   | S-1  |      | 200   |                   |",
                "| T-2 | E-1   | S-2  |      | 150   |                   |",
                "| T-3 | E-1   | S-3  | U-1  | 100   | 2022-06-15T11:11  |",
                "| T-4 | E-1   | S-4  | U-2  | 50    | 2022-07-15T22:22  |",
            ),
            testDataContext = testDataContext
        )
    }

    // TODO - Nested class for main business logic
    // TODO - Nested class for testing gateway
}
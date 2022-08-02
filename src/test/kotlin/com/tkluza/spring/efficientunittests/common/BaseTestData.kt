package com.tkluza.spring.efficientunittests.common

import com.tkluza.spring.efficientunittests.business.place.test.PlaceTestFactory
import com.tkluza.spring.efficientunittests.business.user.test.UserTestFactory
import com.tkluza.spring.efficientunittests.common.test.TestDataContext
import com.tkluza.spring.efficientunittests.common.test.TestDataInitializer

class BaseTestData : TestDataInitializer {

    override fun init(testDataContext: TestDataContext) {
        UserTestFactory.saveUsers(
            userRows = arrayOf(
                "| KEY | First name | Last name | Email                            |",
                "| U-1 | Michael    | Jordan    | michael.jordan@chicago.bulls.com |",
                "| U-2 | Magic      | Johnson   | magic.johnson@la.lakers.com      |",
                "| U-3 | LeBron     | James     | lebron.james@la.lakers.com       |",
            ),
            testDataContext = testDataContext
        )
        PlaceTestFactory.savePlaces(
            placeRows = arrayOf(
                "| KEY | Name             | Address                                     |",
                "| P-1 | Allianz Arena    | Werner-Heisenberg-Allee 25, 80939 München   |",
                "| P-2 | Spotify Camp Nou | C. d'Arístides Maillol, 12, 08028 Barcelona |",
            ),
            testDataContext = testDataContext
        )
        PlaceTestFactory.saveSeats(
            placeRows = arrayOf(
                "| KEY | Place | Section | Row number | Seat number | Is standing |",
                "| S-1 | P-1   | A       | 1          | 5           | false       |",
                "| S-2 | P-1   | B       | 10         | 15          | false       |",
                "| S-3 | P-1   | C       | 20         | 25          | false       |",
                "| S-4 | P-1   | D       | 30         | 35          | false       |",
                "| S-5 | P-2   |         |            | 100         | true        |",
                "| S-6 | P-2   |         |            | 200         | true        |",
            ),
            testDataContext = testDataContext
        )
    }
}
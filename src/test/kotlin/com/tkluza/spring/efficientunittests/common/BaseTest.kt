package com.tkluza.spring.efficientunittests.common

import com.tkluza.spring.efficientunittests.business.event.config.EventTestConfig
import com.tkluza.spring.efficientunittests.business.place.config.PlaceTestConfig
import com.tkluza.spring.efficientunittests.business.place.test.PlaceTestFactory.savePlaces
import com.tkluza.spring.efficientunittests.business.place.test.PlaceTestFactory.saveSeats
import com.tkluza.spring.efficientunittests.business.user.config.UserTestConfig
import com.tkluza.spring.efficientunittests.business.user.test.UserTestFactory.saveUsers
import com.tkluza.spring.efficientunittests.common.config.BaseTestConfig
import com.tkluza.spring.efficientunittests.common.test.TestContext
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ContextConfiguration(
    classes = [
        BaseTestConfig::class,
        EventTestConfig::class,
        PlaceTestConfig::class,
        UserTestConfig::class
    ]
)
abstract class BaseTest {

    @Autowired
    protected lateinit var testContext: TestContext

    @BeforeEach
    protected open fun init() {
        testContext.apply {
            deleteAll()
            initBaseTestData()
        }
    }

    private fun TestContext.initBaseTestData() {
        saveUsers(
            userRows = arrayOf(
                "| KEY | First name | Last name | Email                            |",
                "| U-1 | Michael    | Jordan    | michael.jordan@chicago.bulls.com |",
                "| U-2 | Magic      | Johnson   | magic.johnson@la.lakers.com      |",
                "| U-3 | LeBron     | James     | lebron.james@la.lakers.com       |",
            ),
            testContext = this
        )
        savePlaces(
            placeRows = arrayOf(
                "| KEY | Name             | Address                                     |",
                "| P-1 | Allianz Arena    | Werner-Heisenberg-Allee 25, 80939 München   |",
                "| P-2 | Spotify Camp Nou | C. d'Arístides Maillol, 12, 08028 Barcelona |",
            ),
            testContext = this
        )
        saveSeats(
            placeRows = arrayOf(
                "| KEY | Place | Section | Row number | Seat number | Is standing |",
                "| S-1 | P-1   | A       | 1          | 5           | false       |",
                "| S-2 | P-1   | B       | 10         | 15          | false       |",
                "| S-3 | P-1   | C       | 20         | 25          | false       |",
                "| S-4 | P-1   | D       | 30         | 35          | false       |",
                "| S-5 | P-2   |         |            | 100         | true        |",
                "| S-6 | P-2   |         |            | 200         | true        |",
            ),
            testContext = this
        )
    }
}
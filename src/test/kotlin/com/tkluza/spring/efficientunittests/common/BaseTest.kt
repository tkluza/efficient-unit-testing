package com.tkluza.spring.efficientunittests.common

import com.tkluza.spring.efficientunittests.business.event.config.EventTestConfig
import com.tkluza.spring.efficientunittests.business.place.config.PlaceTestConfig
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
        testContext.deleteAll()
        initBaseTestData()
    }

    private fun initBaseTestData() {
        saveUsers(
            userRows = arrayOf(
                "| KEY | First name | Last name | Email                            |",
                "| U-1 | Michael    | Jordan    | michael.jordan@chicago.bulls.com |",
                "| U-2 | Magic      | Johnson   | magic.johnson@la.lakers.com      |",
                "| U-3 | LeBron     | James     | lebron.james@la.lakers.com       |",
            ),
            testContext = testContext
        )
    }
}
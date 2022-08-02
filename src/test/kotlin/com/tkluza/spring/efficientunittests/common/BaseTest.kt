package com.tkluza.spring.efficientunittests.common

import com.tkluza.spring.efficientunittests.business.event.config.EventTestConfig
import com.tkluza.spring.efficientunittests.business.place.config.PlaceTestConfig
import com.tkluza.spring.efficientunittests.business.user.config.UserTestConfig
import com.tkluza.spring.efficientunittests.common.config.BaseTestConfig
import com.tkluza.spring.efficientunittests.common.test.TestDataContext
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
    protected lateinit var testDataContext: TestDataContext

    private val baseTestData = BaseTestData()

    @BeforeEach
    protected open fun init() {
        testDataContext.deleteAll()
        baseTestData.init(testDataContext)
    }
}
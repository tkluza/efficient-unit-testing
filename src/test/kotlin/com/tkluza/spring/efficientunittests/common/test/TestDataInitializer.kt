package com.tkluza.spring.efficientunittests.common.test

/**
 * Functional interface to init test data using [TestContext]]
 */
fun interface TestDataInitializer {
    fun init(testContext: TestContext)
}
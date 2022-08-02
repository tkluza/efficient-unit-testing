package com.tkluza.spring.efficientunittests.common.test

/**
 * Functional interface to init test data using [TestDataContext]]
 */
fun interface TestDataInitializer {
    fun init(testDataContext: TestDataContext)
}
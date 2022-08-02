package com.tkluza.spring.efficientunittests.business.user.test

import com.tkluza.spring.efficientunittests.business.user.domain.model.UserEntity
import com.tkluza.spring.efficientunittests.common.test.TestDataContext
import com.tkluza.spring.efficientunittests.common.test.factory.TestFactory

object UserTestFactory {

    private const val COLUMN_FIRST_NAME = "First name"
    private const val COLUMN_LAST_NAME = "Last name"
    private const val COLUMN_EMAIL = "Email"

    /**
     * Structure for [UserEntity] in tests
     *
     * | KEY | First name | Last name | Email |
     */
    fun saveUsers(userRows: Array<String>, testDataContext: TestDataContext) {
        TestFactory.saveTestData(
            rows = userRows,
            testDataContext = testDataContext,
            singleEntityCreator = this::createUser
        )
    }

    private fun createUser(userRow: Map<String, String>, testDataContext: TestDataContext): UserEntity =
        UserEntity(
            firstName = userRow[COLUMN_FIRST_NAME] ?: "",
            lastName = userRow[COLUMN_LAST_NAME] ?: "",
            email = userRow[COLUMN_EMAIL] ?: "",
        )
}
package com.tkluza.spring.efficientunittests.common.test.factory

import com.google.common.collect.Table
import com.tkluza.spring.efficientunittests.common.model.EntityWithId
import com.tkluza.spring.efficientunittests.common.test.TestDataContext
import com.tkluza.spring.efficientunittests.common.test.factory.TestTable.COLUMN_KEY

typealias SingleEntityCreator<T> = (Map<String, String>, TestDataContext) -> T

object TestFactory {

    fun saveTestData(
        rows: Array<String>,
        testDataContext: TestDataContext,
        singleEntityCreator: SingleEntityCreator<EntityWithId<*>>
    ) {
        val testTable: Table<String, String, String> = TestTable.mapToTable(rows)
        for (row in testTable.rowMap().values) {
            testDataContext.save(
                key = row[COLUMN_KEY] ?: throw IllegalStateException("[KEY] was not found for row: $row"),
                entity = singleEntityCreator(row, testDataContext)
            )
        }
    }
}
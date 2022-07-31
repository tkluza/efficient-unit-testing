package com.tkluza.spring.efficientunittests.common.test.factory

import com.google.common.collect.HashBasedTable
import com.google.common.collect.Table
import com.tkluza.spring.efficientunittests.common.extension.removeWhitespaces

object TestTable {

    const val COLUMN_KEY: String = "KEY"
    private const val COLUMN_SEPARATOR: String = "|"

    fun mapToTable(rows: Array<String>): Table<String, String, String> =
        if (rows.size >= 2) {
            mapToTable(
                header = createHeader(rows.first()),
                rows = rows.sliceArray(IntRange(1, rows.size))
            )
        } else
            throw IllegalStateException("Test data should have must have [Header] and at least one [Row]")

    private fun createHeader(headerRow: String): Array<String> =
        toSingleRow(headerRow)
            .also {
                val key = it[0]
                require(COLUMN_KEY == key) { "[KEY] column must be first! Instead: $key was found." }
            }

    private fun mapToTable(header: Array<String>, rows: Array<String>): Table<String, String, String> {
        val resultTable: Table<String, String, String> = HashBasedTable.create()
        rows.map {
            val currentRow: Array<String> = toSingleRow(it)
            require(currentRow.size <= header.size) { "Provided [Row]: $currentRow cannot have more values than [Header]: $header " }

            for (j in currentRow.indices) {
                resultTable.put(currentRow[0], header[j], currentRow[j])
            }
        }
        return resultTable
    }

    private fun toSingleRow(input: String): Array<String> =
        input.split(COLUMN_SEPARATOR)
            .map { it.removeWhitespaces() }
            .toTypedArray()
}
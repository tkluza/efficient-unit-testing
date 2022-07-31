package com.tkluza.spring.efficientunittests.test

import com.tkluza.spring.efficientunittests.common.model.EntityWithId

/**
 * Main test context class for providing clear separation between data and repositories
 */
interface TestContext {

    fun <ID, T : EntityWithId<ID>> add(entity: T): T

    fun <ID, T : EntityWithId<ID>> add(key: String, data: T)

    operator fun <ID, T : EntityWithId<ID>> get(key: String, dataClass: Class<T>): T

    fun <ID, T : EntityWithId<ID>> getById(id: ID, dataClass: Class<T>): T

    fun <ID, T : EntityWithId<ID>> getAll(dataClass: Class<T>): List<T>

    fun <ID, T : EntityWithId<ID>> delete(entity: T)

    fun <ID, T : EntityWithId<ID>> deleteAll()
}
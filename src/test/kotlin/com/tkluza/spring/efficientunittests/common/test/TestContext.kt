package com.tkluza.spring.efficientunittests.common.test

import com.tkluza.spring.efficientunittests.common.model.EntityWithId

/**
 * Main test context class for providing clear separation between data and repositories
 */
interface TestContext {

    fun <ID, T : EntityWithId<ID>> save(entity: T): T

    fun <ID, T : EntityWithId<ID>> save(key: String, entity: T): T

    operator fun <ID, T : EntityWithId<ID>> get(key: String, entityClass: Class<T>): T?

    operator fun <ID, T : EntityWithId<ID>> get(id: ID, entityClass: Class<T>): T?

    fun <ID, T : EntityWithId<ID>> findAll(entityClass: Class<T>): List<T>

    fun <ID, T : EntityWithId<ID>> delete(entity: T)

    fun deleteAll()
}
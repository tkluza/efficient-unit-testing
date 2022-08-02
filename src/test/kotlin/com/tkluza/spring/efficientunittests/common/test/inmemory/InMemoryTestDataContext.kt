package com.tkluza.spring.efficientunittests.common.test.inmemory

import com.tkluza.spring.efficientunittests.common.model.EntityWithId
import com.tkluza.spring.efficientunittests.common.test.TestDataContext
import com.tkluza.spring.efficientunittests.common.test.TestDataRepository

class InMemoryTestDataContext(
    private val testRepositories: List<TestDataRepository<*, *>>
) : TestDataContext {

    override fun <ID, T : EntityWithId<ID>> save(entity: T): T =
        getTestRepository(entity.javaClass).save(entity)

    override fun <ID, T : EntityWithId<ID>> save(key: String, entity: T): T =
        getTestRepository(entity.javaClass).save(key, entity)

    override operator fun <ID, T : EntityWithId<ID>> get(key: String, entityClass: Class<T>): T? =
        getTestRepository(entityClass)[key]

    override operator fun <ID, T : EntityWithId<ID>> get(id: ID, entityClass: Class<T>): T? =
        getTestRepository(entityClass)[id]

    override fun <ID, T : EntityWithId<ID>> findAll(entityClass: Class<T>): List<T> =
        getTestRepository(entityClass).findAll()

    override fun <ID, T : EntityWithId<ID>> delete(entity: T) {
        getTestRepository(entity.javaClass).delete(entity.id)
    }

    override fun <ID, T : EntityWithId<ID>> deleteAll(entities: List<T>) {
        entities.forEach {
            delete(it)
        }
    }

    private fun <ID, T : EntityWithId<ID>> getTestRepository(entityClass: Class<T>): TestDataRepository<T, ID> =
        (testRepositories.find {
            it.entityClass == entityClass
        } ?: IllegalArgumentException("Cannot find test repository for: $entityClass.")) as TestDataRepository<T, ID>

    override fun deleteAll() {
        testRepositories.forEach(TestDataRepository<*, *>::deleteAll)
    }
}
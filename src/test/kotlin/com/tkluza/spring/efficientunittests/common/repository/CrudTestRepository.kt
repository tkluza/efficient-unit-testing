package com.tkluza.spring.efficientunittests.common.repository

import com.tkluza.spring.efficientunittests.common.model.EntityWithId
import com.tkluza.spring.efficientunittests.common.test.TestDataContext
import org.springframework.data.repository.CrudRepository
import java.util.Optional

abstract class CrudTestRepository<T : EntityWithId<ID>, ID> protected constructor(
    protected val testDataContext: TestDataContext,
    protected val entityClass: Class<T>
) : CrudRepository<T, ID> {

    override fun <S : T> save(entity: S): S =
        testDataContext.save(entity)

    override fun <S : T> saveAll(entities: MutableIterable<S>): MutableIterable<S> =
        entities
            .map { testDataContext.save(it) }
            .toMutableList()

    override fun findById(id: ID): Optional<T> =
        Optional.ofNullable(
            testDataContext[id, entityClass]
        )

    override fun existsById(id: ID): Boolean =
        testDataContext.findAll(entityClass)
            .any { it.id == id }

    override fun findAll(): List<T> =
        testDataContext.findAll(entityClass).toMutableList()

    override fun findAllById(ids: MutableIterable<ID>): MutableIterable<T> =
        ids
            .mapNotNull { testDataContext[it, entityClass] }
            .toMutableList()

    override fun count(): Long =
        this.findAll().size.toLong()

    override fun deleteAll() {
        testDataContext.deleteAll()
    }

    override fun deleteAll(entities: MutableIterable<T>) {
        testDataContext.deleteAll(entities.toList())
    }

    override fun deleteAllById(ids: MutableIterable<ID>) {
        deleteAll(findAll().toMutableList())
    }

    override fun delete(entity: T) {
        testDataContext.delete(entity)
    }

    override fun deleteById(id: ID) {
        findById(id).ifPresent {
            delete(it)
        }
    }
}
package com.tkluza.spring.efficientunittests.common.test

import com.tkluza.spring.efficientunittests.common.model.EntityWithId

interface TestRepository<T : EntityWithId<ID>, ID> {

    val entityClass: Class<T>

    fun save(entity: T): T

    fun save(key: String, entity: T): T

    operator fun get(key: String): T?

    operator fun get(id: ID): T?

    fun findAll(): List<T>

    fun delete(entity: T)

    fun delete(key: String)

    fun delete(id: ID)

    fun deleteAll()
}
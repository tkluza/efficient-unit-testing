package com.tkluza.spring.efficientunittests.common.test.inmemory

import com.tkluza.spring.efficientunittests.common.extension.isNull
import com.tkluza.spring.efficientunittests.common.model.EntityWithId
import com.tkluza.spring.efficientunittests.common.test.TestRepository
import com.tkluza.spring.efficientunittests.common.test.id.IdGenerator

abstract class InMemoryTestRepository<T : EntityWithId<ID>, ID>(
    override val entityClass: Class<T>,
    private val byId: MutableMap<ID, T> = mutableMapOf(),
    private val byKey: MutableMap<String, T> = mutableMapOf(),
    private val identityGenerator: IdGenerator<ID>,
    private val keyPrefix: String,
) : TestRepository<T, ID> {

    override fun save(entity: T): T {
        saveEntity(entity)
        val key = generateKeyForId(entity.id)
        byKey[key] = entity

        return entity
    }

    private fun saveEntity(entity: T): T {
        if (entity.id.isNull()) {
            entity.id = identityGenerator.nextId()
        }

        byId[entity.id] = entity

        return entity
    }

    private fun generateKeyForId(id: ID): String {
        return "$keyPrefix-$id"
    }

    override fun save(key: String, entity: T): T {
        if (!key.startsWith(keyPrefix)) {
            throw java.lang.IllegalStateException("Key: $key must start with given keyPrefix: $keyPrefix.")
        }

        byKey[key]?.let {
            byId.remove(it.id)
        }

        byKey[key] = entity

        return saveEntity(entity)
    }

    override operator fun get(key: String): T? {
        return byKey[key]
    }

    override operator fun get(id: ID): T? {
        return byId[id]
    }

    override fun delete(key: String) {
        get(key)?.let {
            byKey.remove(key)
            byId.values.remove(it)
        }
    }

    override fun delete(id: ID) {
        get(id)?.let {
            byKey.values.remove(it)
            byId.remove(id)
        }
    }

    override fun delete(entity: T) {
        byKey.values.remove(entity)
        byId.values.remove(entity)
    }

    override fun deleteAll() {
        byId.clear()
        byKey.clear()
    }
}
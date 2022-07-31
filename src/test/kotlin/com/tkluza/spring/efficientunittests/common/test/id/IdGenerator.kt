package com.tkluza.spring.efficientunittests.common.test.id

abstract class IdGenerator<ID>(
    protected var id: ID
) {
    abstract fun increment()

    abstract fun clear()

    fun nextId(): ID {
        increment()
        return id
    }
}
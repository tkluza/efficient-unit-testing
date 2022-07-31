package com.tkluza.spring.efficientunittests.common.test.id

class LongIdGenerator : IdGenerator<Long?>(0L) {

    override fun increment() {
        id = id?.inc()
    }

    override fun clear() {
        id = 0L
    }
}
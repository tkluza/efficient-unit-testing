package com.tkluza.spring.efficientunittests.common.test.id

import com.tkluza.spring.efficientunittests.common.extension.notAssignedId

class LongIdGenerator : IdGenerator<Long>(id = Long.notAssignedId()) {

    override fun increment() {
        id = id.inc()
    }

    override fun clear() {
        id = Long.notAssignedId()
    }
}
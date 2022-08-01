package com.tkluza.spring.efficientunittests.common.model

import com.tkluza.spring.efficientunittests.common.extension.notAssignedId

interface EntityWithLongId : EntityWithId<Long> {
    override fun isIdAssigned(): Boolean = id > Long.notAssignedId()
}
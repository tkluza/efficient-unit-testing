package com.tkluza.spring.efficientunittests.business.user.domain

import com.tkluza.spring.efficientunittests.business.user.dto.query.UserQuery

interface UserFacade {

    fun findUserById(id: Long): UserQuery
}
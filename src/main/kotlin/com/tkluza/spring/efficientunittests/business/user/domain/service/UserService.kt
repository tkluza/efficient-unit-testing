package com.tkluza.spring.efficientunittests.business.user.domain.service

import com.tkluza.spring.efficientunittests.business.user.dto.query.UserQuery

interface UserService {

    fun findUserById(id: Long): UserQuery
}
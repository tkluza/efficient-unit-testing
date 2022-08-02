package com.tkluza.spring.efficientunittests.business.user.domain.service

import com.tkluza.spring.efficientunittests.business.user.dto.UserQuery

interface UserService {

    fun findUserById(id: Long): UserQuery
}
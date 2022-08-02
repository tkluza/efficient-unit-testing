package com.tkluza.spring.efficientunittests.business.user.domain

import com.tkluza.spring.efficientunittests.business.user.domain.service.UserService
import com.tkluza.spring.efficientunittests.business.user.dto.UserQuery

class UserFacadeAdapter(
    private val userService: UserService
) : UserFacade {

    override fun findUserById(id: Long): UserQuery =
        userService.findUserById(id)
}
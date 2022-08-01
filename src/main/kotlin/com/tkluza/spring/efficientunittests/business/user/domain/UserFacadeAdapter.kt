package com.tkluza.spring.efficientunittests.business.user.domain

import com.tkluza.spring.efficientunittests.business.user.domain.service.UserService

class UserFacadeAdapter(
    private val userService: UserService
) : UserFacade {
}
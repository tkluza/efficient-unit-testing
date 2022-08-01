package com.tkluza.spring.efficientunittests.business.user.domain.service.adapter

import com.tkluza.spring.efficientunittests.business.user.domain.repository.UserRepository
import com.tkluza.spring.efficientunittests.business.user.domain.service.UserService

class UserServiceAdapter(
    private val userRepository: UserRepository
) : UserService {
}
package com.tkluza.spring.efficientunittests.business.user.domain.service.adapter

import com.tkluza.spring.efficientunittests.business.user.domain.mapper.UserMapper
import com.tkluza.spring.efficientunittests.business.user.domain.repository.UserRepository
import com.tkluza.spring.efficientunittests.business.user.domain.service.UserService
import com.tkluza.spring.efficientunittests.business.user.dto.query.UserQuery
import javax.persistence.EntityNotFoundException

class UserServiceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : UserService {

    override fun findUserById(id: Long): UserQuery =
        userRepository.findById(id)
            .map { userMapper.map(it) }
            .orElseThrow { EntityNotFoundException("[UserEntity] with [Id]: $id was not found") }
}
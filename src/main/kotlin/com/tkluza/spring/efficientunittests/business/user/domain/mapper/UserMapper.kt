package com.tkluza.spring.efficientunittests.business.user.domain.mapper

import com.tkluza.spring.efficientunittests.business.user.domain.model.UserEntity
import com.tkluza.spring.efficientunittests.business.user.dto.UserQuery

class UserMapper {

    fun map(userEntity: UserEntity): UserQuery =
        with(userEntity) {
            UserQuery(
                id = id,
                firstName = firstName,
                lastName = lastName,
                email = email
            )
        }
}
package com.tkluza.spring.efficientunittests.business.user.domain.mapper

import com.tkluza.spring.efficientunittests.business.user.domain.model.UserEntity
import com.tkluza.spring.efficientunittests.business.user.dto.query.UserQuery
import com.tkluza.spring.efficientunittests.common.mapper.BaseMapper

class UserMapper : BaseMapper<UserEntity, UserQuery> {

    override fun map(input: UserEntity): UserQuery =
        with(input) {
            UserQuery(
                id = id,
                firstName = firstName,
                lastName = lastName,
                email = email
            )
        }
}
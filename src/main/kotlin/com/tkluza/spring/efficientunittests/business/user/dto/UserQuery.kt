package com.tkluza.spring.efficientunittests.business.user.dto

data class UserQuery(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String
)

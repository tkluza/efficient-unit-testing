package com.tkluza.spring.efficientunittests.business.user.domain

import com.tkluza.spring.efficientunittests.business.user.dto.query.UserQuery

/**
 * Main facade for User domain
 */
interface UserFacade {

    /**
     * Finds [UserQuery] by its id
     */
    fun findUserById(userId: Long): UserQuery
}
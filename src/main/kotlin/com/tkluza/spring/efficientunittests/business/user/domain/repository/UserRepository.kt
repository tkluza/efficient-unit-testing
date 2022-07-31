package com.tkluza.spring.efficientunittests.business.user.domain.repository

import com.tkluza.spring.efficientunittests.business.user.domain.model.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, Long>
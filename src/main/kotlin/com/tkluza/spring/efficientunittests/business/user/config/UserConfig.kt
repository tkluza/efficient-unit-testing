package com.tkluza.spring.efficientunittests.business.user.config

import com.tkluza.spring.efficientunittests.business.user.domain.UserFacade
import com.tkluza.spring.efficientunittests.business.user.domain.UserFacadeAdapter
import com.tkluza.spring.efficientunittests.business.user.domain.repository.UserRepository
import com.tkluza.spring.efficientunittests.business.user.domain.service.adapter.UserServiceAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserConfig {

    @Bean
    fun userFacade(userRepository: UserRepository): UserFacade {
        val userService = UserServiceAdapter(userRepository)
        return UserFacadeAdapter(userService = userService)
    }
}
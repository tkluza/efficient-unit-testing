package com.tkluza.spring.efficientunittests.business.user.domain

import com.tkluza.spring.efficientunittests.business.user.domain.model.UserEntity
import com.tkluza.spring.efficientunittests.common.BaseTest
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.EntityNotFoundException

class UserFacadeTest : BaseTest() {

    @Autowired
    private lateinit var userFacade: UserFacade

    @Test
    fun `should find user by id`() {
        // given
        val userId = testDataContext["U-1", UserEntity::class.java]?.id!!

        // when
        val user = userFacade.findUserById(userId)

        // then
        assertSoftly(user) {
            id shouldBe userId
            firstName shouldBe "Michael"
            lastName shouldBe "Jordan"
            email shouldBe "michael.jordan@chicago.bulls.com"
        }
    }

    @Test
    fun `should throw exception if user not found`() {
        // given
        val userId = Long.MAX_VALUE

        // when & then
        shouldThrow<EntityNotFoundException> {
            userFacade.findUserById(userId)
        }
    }
}
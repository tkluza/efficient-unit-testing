package com.tkluza.spring.efficientunittests.business.user.domain

import com.tkluza.spring.efficientunittests.common.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserTest : BaseTest() {

    @Test
    fun `test of framework initialisation`() {
        val t = true
        assertThat(t).isTrue()
    }
}
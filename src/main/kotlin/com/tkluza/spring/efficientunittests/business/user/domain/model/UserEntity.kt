package com.tkluza.spring.efficientunittests.business.user.domain.model

import com.tkluza.spring.efficientunittests.common.model.EntityWithId
import javax.persistence.*

@Entity
@Table(name = "t_user")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long? = null,

    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "last_name")
    var lastName: String,

    @Column(name = "email")
    var email: String,
) : EntityWithId<Long?> {
    fun getFullName(): String = "$firstName $lastName"
}

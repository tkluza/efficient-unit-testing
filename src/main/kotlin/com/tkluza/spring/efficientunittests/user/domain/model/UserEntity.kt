package com.tkluza.spring.efficientunittests.user.domain.model

import javax.persistence.*

@Entity
@Table(name = "t_user")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "last_name")
    var lastName: String,

    @Column(name = "email")
    var email: String,
) {
    fun getFullName(): String = "$firstName $lastName"
}

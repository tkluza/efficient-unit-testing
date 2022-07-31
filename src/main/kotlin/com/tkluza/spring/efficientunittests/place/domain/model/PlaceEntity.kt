package com.tkluza.spring.efficientunittests.place.domain.model

import javax.persistence.*

@Entity
@Table(name = "t_place")
class PlaceEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "address")
    var address: String,

    @OneToMany(mappedBy = "id")
    var seats: MutableSet<SeatEntity> = mutableSetOf(),
)
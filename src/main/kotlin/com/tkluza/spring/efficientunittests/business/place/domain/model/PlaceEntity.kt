package com.tkluza.spring.efficientunittests.business.place.domain.model

import com.tkluza.spring.efficientunittests.common.model.EntityWithId
import javax.persistence.*

@Entity
@Table(name = "t_place")
class PlaceEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "address")
    var address: String,

    @OneToMany(mappedBy = "id")
    var seats: MutableSet<SeatEntity> = mutableSetOf(),
): EntityWithId<Long?>
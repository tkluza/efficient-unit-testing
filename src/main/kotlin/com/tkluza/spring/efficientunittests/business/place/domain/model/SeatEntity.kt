package com.tkluza.spring.efficientunittests.business.place.domain.model

import com.tkluza.spring.efficientunittests.common.model.EntityWithId
import javax.persistence.*

@Entity
@Table(name = "t_seat")
class SeatEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long? = null,

    @Column(name = "section")
    var section: String? = null,

    @Column(name = "row_number")
    var rowNumber: Int? = null,

    @Column(name = "seat_number")
    var seatNumber: Int,
): EntityWithId<Long?>
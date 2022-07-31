package com.tkluza.spring.efficientunittests.place.domain.model

import javax.persistence.*

@Entity
@Table(name = "t_seat")
class SeatEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "section")
    var section: String? = null,

    @Column(name = "row_number")
    var rowNumber: Int? = null,

    @Column(name = "seat_number")
    var seatNumber: Int,
)
package com.tkluza.spring.efficientunittests.business.place.domain.model

import com.tkluza.spring.efficientunittests.common.extension.notAssignedId
import com.tkluza.spring.efficientunittests.common.model.EntityWithLongId
import javax.persistence.*

@Entity
@Table(name = "t_seat")
class SeatEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long = Long.notAssignedId(),

    @Column(name = "place_id")
    val placeId: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", updatable = false, insertable = false)
    val placeEntity: PlaceEntity,

    @Column(name = "section")
    var section: String? = null,

    @Column(name = "row_number")
    var rowNumber: Int? = null,

    @Column(name = "seat_number")
    var seatNumber: Int,

    @Column(name = "is_standing")
    val isStanding: Boolean = false
) : EntityWithLongId
package com.tkluza.spring.efficientunittests.business.event.domain.model

import com.tkluza.spring.efficientunittests.business.place.domain.model.PlaceEntity
import com.tkluza.spring.efficientunittests.common.extension.notAssignedId
import com.tkluza.spring.efficientunittests.common.model.EntityWithLongId
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "t_event")
class EventEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long = Long.notAssignedId(),

    @Column(name = "place_id")
    val placeId: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", insertable = false, updatable = false)
    val placeEntity: PlaceEntity,

    @Column(name = "name")
    var name: String,

    @OneToMany(mappedBy = "id")
    var tickets: MutableSet<TicketEntity> = mutableSetOf(),

    @Column(name = "date")
    var date: LocalDate,
) : EntityWithLongId
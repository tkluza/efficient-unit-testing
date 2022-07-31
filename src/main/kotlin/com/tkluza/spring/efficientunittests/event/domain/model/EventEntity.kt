package com.tkluza.spring.efficientunittests.event.domain.model

import com.tkluza.spring.efficientunittests.place.domain.model.PlaceEntity
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "t_event")
class EventEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name")
    var name: Int? = null,

    @Column(name = "place_id")
    var placeId: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", insertable = false, updatable = false)
    var place: PlaceEntity,

    @OneToMany(mappedBy = "id")
    var tickets: MutableSet<TicketEntity> = mutableSetOf(),

    @Column(name = "date")
    var date: LocalDate,
)
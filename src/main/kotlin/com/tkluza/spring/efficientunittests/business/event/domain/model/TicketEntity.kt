package com.tkluza.spring.efficientunittests.business.event.domain.model

import com.tkluza.spring.efficientunittests.business.place.domain.model.SeatEntity
import com.tkluza.spring.efficientunittests.business.user.domain.model.UserEntity
import com.tkluza.spring.efficientunittests.common.model.EntityWithId
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "t_ticket")
class TicketEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long? = null,

    @Column(name = "seat_id")
    var seatId: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", insertable = false, updatable = false)
    var seat: SeatEntity,

    @Column(name = "participant_id")
    var participantId: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id", insertable = false, updatable = false)
    var participant: UserEntity,

    @Column(name = "price")
    var price: BigDecimal,

    @Column(name = "sale_date")
    var saleDate: LocalDateTime? = null
): EntityWithId<Long?>
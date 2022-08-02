package com.tkluza.spring.efficientunittests.business.event.domain.model

import com.tkluza.spring.efficientunittests.common.extension.isNotNull
import com.tkluza.spring.efficientunittests.common.extension.notAssignedId
import com.tkluza.spring.efficientunittests.common.model.EntityWithLongId
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "t_ticket")
class TicketEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long = Long.notAssignedId(),

    @Column(name = "event_id")
    val eventId: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", updatable = false, insertable = false)
    val eventEntity: EventEntity,

    @Column(name = "seat_id")
    var seatId: Long,

    @Column(name = "user_id")
    var userId: Long? = null,

    @Column(name = "price")
    var price: BigDecimal,

    @Column(name = "sale_date")
    var saleDate: LocalDateTime? = null
) : EntityWithLongId {
    fun isSold(): Boolean =
        userId.isNotNull().and(saleDate.isNotNull())
}
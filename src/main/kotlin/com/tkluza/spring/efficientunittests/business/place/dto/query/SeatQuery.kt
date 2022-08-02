package com.tkluza.spring.efficientunittests.business.place.dto.query

data class SeatQuery(
    val id: Long,
    val placeId: Long,
    val section: String?,
    val rowNumber: Int?,
    val seatNumber: Int,
    val isStanding: Boolean
)

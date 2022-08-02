package com.tkluza.spring.efficientunittests.business.place.dto.query

data class SeatQuery(
    val id: Long,
    val placeId: Long,
    val placeName: String,
    val section: String?,
    val rowNumber: Int?,
    val seatNumber: Int,
    val isStanding: Boolean
) {
    val seatInfo: String = "Section: ${section ?: ""} | Row: ${rowNumber ?: ""} | Seat: $seatNumber"
}

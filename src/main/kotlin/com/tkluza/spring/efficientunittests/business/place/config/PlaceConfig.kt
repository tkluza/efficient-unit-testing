package com.tkluza.spring.efficientunittests.business.place.config

import com.tkluza.spring.efficientunittests.business.place.domain.PlaceFacade
import com.tkluza.spring.efficientunittests.business.place.domain.PlaceFacadeAdapter
import com.tkluza.spring.efficientunittests.business.place.domain.repository.PlaceRepository
import com.tkluza.spring.efficientunittests.business.place.domain.repository.SeatRepository
import com.tkluza.spring.efficientunittests.business.place.domain.service.adapter.PlaceServiceAdapter
import com.tkluza.spring.efficientunittests.business.place.domain.service.adapter.SeatServiceAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PlaceConfig {

    @Bean
    fun userFacade(
        placeRepository: PlaceRepository,
        seatRepository: SeatRepository
    ): PlaceFacade {
        val placeService = PlaceServiceAdapter(placeRepository = placeRepository)
        val seatService = SeatServiceAdapter(seatRepository = seatRepository)
        return PlaceFacadeAdapter(
            placeService = placeService,
            seatService = seatService
        )
    }
}
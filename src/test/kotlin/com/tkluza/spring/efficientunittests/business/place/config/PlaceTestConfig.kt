package com.tkluza.spring.efficientunittests.business.place.config

import com.tkluza.spring.efficientunittests.business.place.domain.repository.PlaceRepository
import com.tkluza.spring.efficientunittests.business.place.domain.repository.PlaceTestRepository
import com.tkluza.spring.efficientunittests.business.place.domain.repository.SeatRepository
import com.tkluza.spring.efficientunittests.business.place.domain.repository.SeatTestRepository
import com.tkluza.spring.efficientunittests.business.place.test.PlaceInMemoryRepository
import com.tkluza.spring.efficientunittests.business.place.test.SeatInMemoryRepository
import com.tkluza.spring.efficientunittests.common.test.TestContext
import com.tkluza.spring.efficientunittests.common.test.id.IdGenerator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

@Import(PlaceConfig::class)
class PlaceTestConfig {

    @Bean
    fun placeRepository(testContext: TestContext): PlaceRepository =
        PlaceTestRepository(testContext)

    @Bean
    fun seatRepository(testContext: TestContext): SeatRepository =
        SeatTestRepository(testContext)

    @Bean
    fun placeInMemoryTestRepository(idGenerator: IdGenerator<Long>): PlaceInMemoryRepository =
        PlaceInMemoryRepository(idGenerator)

    @Bean
    fun seatInMemoryTestRepository(idGenerator: IdGenerator<Long>): SeatInMemoryRepository =
        SeatInMemoryRepository(idGenerator)
}
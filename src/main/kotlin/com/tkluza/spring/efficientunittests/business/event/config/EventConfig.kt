package com.tkluza.spring.efficientunittests.business.event.config

import com.tkluza.spring.efficientunittests.business.event.domain.EventFacade
import com.tkluza.spring.efficientunittests.business.event.domain.EventFacadeAdapter
import com.tkluza.spring.efficientunittests.business.event.domain.gateway.EventGateway
import com.tkluza.spring.efficientunittests.business.event.domain.gateway.adapter.EventGatewayAdapter
import com.tkluza.spring.efficientunittests.business.event.domain.repository.EventRepository
import com.tkluza.spring.efficientunittests.business.event.domain.repository.TicketRepository
import com.tkluza.spring.efficientunittests.business.event.domain.service.adapter.TicketServiceAdapter
import com.tkluza.spring.efficientunittests.business.place.domain.PlaceFacade
import com.tkluza.spring.efficientunittests.business.user.domain.UserFacade
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EventConfig {

    @Bean
    fun eventGateway(
        placeFacade: PlaceFacade,
        userFacade: UserFacade
    ): EventGateway =
        EventGatewayAdapter(
            placeFacade = placeFacade,
            userFacade = userFacade
        )

    @Bean
    fun eventFacade(
        eventGateway: EventGateway,
        eventRepository: EventRepository,
        ticketRepository: TicketRepository
    ): EventFacade {
        val ticketService = TicketServiceAdapter(
            eventGateway = eventGateway,
            ticketRepository = ticketRepository
        )
        return EventFacadeAdapter(
            ticketService = ticketService
        )
    }
}
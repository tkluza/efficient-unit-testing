package com.tkluza.spring.efficientunittests.business.event.config

import com.tkluza.spring.efficientunittests.business.event.domain.EventFacade
import com.tkluza.spring.efficientunittests.business.event.domain.EventFacadeAdapter
import com.tkluza.spring.efficientunittests.business.event.domain.repository.EventRepository
import com.tkluza.spring.efficientunittests.business.event.domain.repository.TicketRepository
import com.tkluza.spring.efficientunittests.business.event.domain.service.adapter.EventServiceAdapter
import com.tkluza.spring.efficientunittests.business.event.domain.service.adapter.TicketServiceAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EventConfig {

    @Bean
    fun eventFacade(
        eventRepository: EventRepository,
        ticketRepository: TicketRepository
    ): EventFacade {
        val eventService = EventServiceAdapter(eventRepository = eventRepository)
        val ticketService = TicketServiceAdapter(ticketRepository = ticketRepository)
        return EventFacadeAdapter(
            eventService = eventService,
            ticketService = ticketService
        )
    }
}
package com.tkluza.spring.efficientunittests.business.event.domain.service.adapter

import com.tkluza.spring.efficientunittests.business.event.domain.repository.EventRepository
import com.tkluza.spring.efficientunittests.business.event.domain.service.EventService

class EventServiceAdapter(
    private val eventRepository: EventRepository
) : EventService {
}
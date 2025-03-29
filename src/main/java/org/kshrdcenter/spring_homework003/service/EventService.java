package org.kshrdcenter.spring_homework003.service;

import org.kshrdcenter.spring_homework003.model.dto.request.EventsRequest;
import org.kshrdcenter.spring_homework003.model.entity.Events;

import java.util.List;

public interface EventService {
    List<Events> getAllEvents(Integer page, Integer size);

    Events createEvent(EventsRequest request);

    Events getEventById(Long eventId);

    Events deleteEventById(Long eventId);

    Events updateEventById(Long eventId, EventsRequest request);
}

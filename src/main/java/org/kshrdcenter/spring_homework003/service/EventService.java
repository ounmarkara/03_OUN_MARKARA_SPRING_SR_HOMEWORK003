package org.kshrdcenter.spring_homework003.service;

import org.kshrdcenter.spring_homework003.model.dto.request.EventsRequest;
import org.kshrdcenter.spring_homework003.model.entity.Events;

import java.util.List;

public interface EventService {
    List<Events> getAllEvents(Integer page, Integer size);

    Events createEvent(EventsRequest request);

    Events getEventById(Integer eventId);

    Events deleteEventById(Integer eventId);

    Events updateEventById(Integer eventId, EventsRequest request);
}

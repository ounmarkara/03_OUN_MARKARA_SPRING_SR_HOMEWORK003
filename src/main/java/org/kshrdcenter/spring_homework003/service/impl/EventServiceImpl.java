package org.kshrdcenter.spring_homework003.service.impl;


import org.kshrdcenter.spring_homework003.exception.NotFoundException;
import org.kshrdcenter.spring_homework003.model.dto.request.EventsRequest;
import org.kshrdcenter.spring_homework003.model.entity.Events;
import org.kshrdcenter.spring_homework003.repository.EventRepository;
import org.kshrdcenter.spring_homework003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Events> getAllEvents(Integer page, Integer size) {
        page = (page - 1) * size;
        return eventRepository.getAllEvents(page,size);
    }

    @Override
    public Events createEvent(EventsRequest request) {
        return eventRepository.createEvent(request);
    }

    @Override
    public Events getEventById(Long eventId) {
        if (eventRepository.getEventById(eventId) == null) {
            throw new NotFoundException("Cannot find event with id " + eventId + " !");
        }
        return eventRepository.getEventById((eventId));
    }

    @Override
    public Events deleteEventById(Long eventId) {
        if (eventRepository.getEventById(eventId) == null) {
            throw new NotFoundException("Cannot find event with id " + eventId + " !");
        }
        return eventRepository.deleteEventById(eventId);
    }

    @Override
    public Events updateEventById(Long eventId, EventsRequest request) {
        if (eventRepository.getEventById(eventId) == null) {
            throw new NotFoundException("Cannot find event with id " + eventId + " !");
        }
        return eventRepository.updateEventById(eventId,request);
    }
}

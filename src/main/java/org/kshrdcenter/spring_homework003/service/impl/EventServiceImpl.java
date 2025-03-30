package org.kshrdcenter.spring_homework003.service.impl;


import org.kshrdcenter.spring_homework003.exception.NotFoundException;
import org.kshrdcenter.spring_homework003.model.dto.request.EventsRequest;
import org.kshrdcenter.spring_homework003.model.entity.Events;
import org.kshrdcenter.spring_homework003.repository.AttendeesRepository;
import org.kshrdcenter.spring_homework003.repository.EventAttendeesRepository;
import org.kshrdcenter.spring_homework003.repository.EventRepository;
import org.kshrdcenter.spring_homework003.repository.VenueRepository;
import org.kshrdcenter.spring_homework003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;
    private final AttendeesRepository attendeesRepository;
    private final EventAttendeesRepository eventAttendeesRepository;

    public EventServiceImpl(EventRepository eventRepository, VenueRepository venueRepository, AttendeesRepository attendeesRepository, EventAttendeesRepository eventAttendeesRepository) {
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
        this.attendeesRepository = attendeesRepository;
        this.eventAttendeesRepository = eventAttendeesRepository;
    }

    @Override
    public List<Events> getAllEvents(Integer page, Integer size) {
        page = (page - 1) * size;
        return eventRepository.getAllEvents(page,size);
    }

    @Override
    public Events createEvent(EventsRequest request) {
        // Validate venue existence
        Integer venueId = request.getVenue_id();
        if (venueId != null && venueRepository.getVenueById(venueId) == null) {
            throw new NotFoundException("Venue with ID " + venueId + " not found");
        }

        // Validate attendee existence
        List<Integer> attendeeIds = request.getAttendeeId();
        if (attendeeIds != null && !attendeeIds.isEmpty()) {
            for (Integer attendeeId : attendeeIds) {
                if (attendeesRepository.getAttendeeById(attendeeId) == null) {
                    throw new NotFoundException("Attendee with ID " + attendeeId + " not found");
                }
            }
        }

        // Insert the event after validation
        Events event = eventRepository.insertEvent(request);

        // Link attendees to the event
        if (attendeeIds != null && !attendeeIds.isEmpty()) {
            for (Integer attendeeId : attendeeIds) {
                eventAttendeesRepository.createEventIdAndAttendeeId(event.getEvent_id(), attendeeId);
            }
        }

        // Return the newly created event
        return eventRepository.getEventById(event.getEvent_id());
    }




    @Override
    public Events getEventById(Integer eventId) {
        if (eventRepository.getEventById(eventId) == null) {
            throw new NotFoundException("Cannot find event with id " + eventId + " !");
        }
        return eventRepository.getEventById((eventId));
    }

    @Override
    public Events deleteEventById(Integer eventId) {
        if (eventRepository.getEventById(eventId) == null) {
            throw new NotFoundException("Cannot find event with id " + eventId + " !");
        }
        return eventRepository.deleteEventById(eventId);
    }

    @Override
    public Events updateEventById(Integer eventId, EventsRequest request) {
        if (eventRepository.getEventById(eventId) == null) {
            throw new NotFoundException("Cannot find event with id " + eventId + " !");
        }
        return eventRepository.updateEventById(eventId,request);
    }
}

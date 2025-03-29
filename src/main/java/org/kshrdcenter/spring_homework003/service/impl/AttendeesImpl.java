package org.kshrdcenter.spring_homework003.service.impl;

import org.kshrdcenter.spring_homework003.exception.NotFoundException;
import org.kshrdcenter.spring_homework003.model.dto.request.AttendeesRequest;
import org.kshrdcenter.spring_homework003.model.entity.Attendees;
import org.kshrdcenter.spring_homework003.repository.AttendeesRepository;
import org.kshrdcenter.spring_homework003.service.AttendeesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeesImpl implements AttendeesService {
    private final AttendeesRepository attendeesRepository;

    public AttendeesImpl(AttendeesRepository attendeesRepository) {
        this.attendeesRepository = attendeesRepository;
    }

    @Override
    public List<Attendees> getAllAttendees(Integer page, Integer size) {
        page = (page - 1) * size;
        return attendeesRepository.getAllAttendees(page,size);
    }

    @Override
    public Attendees createAttendees(AttendeesRequest request) {


        return attendeesRepository.createAttendees(request);
    }

    @Override
    public Attendees getAttendeeById(Long attendeeId) {
        Attendees attendee = attendeesRepository.getAttendeeById(attendeeId);
        if (attendee == null) {
            throw new NotFoundException("Cannot find attendee with id " + attendeeId + " !");
        }
        return attendee;
    }

    @Override
    public Attendees updateAttendeeById(Long attendeeId, AttendeesRequest request) {
        if (attendeesRepository.updateAttendeeById(attendeeId,request) == null) {
            throw new NotFoundException("Cannot find attendee with id " + attendeeId + " !");
        }
        return attendeesRepository.updateAttendeeById(attendeeId,request);
    }

    @Override
    public Attendees deleteAttendeeById(Long attendeeId) {
        if (attendeesRepository.deleteAttendeeById(attendeeId) == null) {
            throw new NotFoundException("Cannot find attendee with id " + attendeeId + " !");
        }
        return attendeesRepository.deleteAttendeeById(attendeeId);
    }

}

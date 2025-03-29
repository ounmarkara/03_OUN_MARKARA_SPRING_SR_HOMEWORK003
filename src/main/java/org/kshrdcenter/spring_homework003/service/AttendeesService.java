package org.kshrdcenter.spring_homework003.service;


import org.kshrdcenter.spring_homework003.model.dto.request.AttendeesRequest;
import org.kshrdcenter.spring_homework003.model.entity.Attendees;
import org.kshrdcenter.spring_homework003.repository.AttendeesRepository;

import java.util.List;

public interface AttendeesService {

    List<Attendees> getAllAttendees(Integer page, Integer size);

    Attendees createAttendees(AttendeesRequest request);


    Attendees getAttendeeById(Long attendeeId);

    Attendees updateAttendeeById(Long attendeeId, AttendeesRequest request);

    Attendees deleteAttendeeById(Long attendeeId);
}

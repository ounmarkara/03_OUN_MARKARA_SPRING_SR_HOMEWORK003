package org.kshrdcenter.spring_homework003.service;


import org.kshrdcenter.spring_homework003.model.dto.request.AttendeesRequest;
import org.kshrdcenter.spring_homework003.model.entity.Attendees;
import org.kshrdcenter.spring_homework003.repository.AttendeesRepository;

import java.util.List;

public interface AttendeesService {

    List<Attendees> getAllAttendees(Integer page, Integer size);

    Attendees createAttendees(AttendeesRequest request);


    Attendees getAttendeeById(Integer attendeeId);

    Attendees updateAttendeeById(Integer attendeeId, AttendeesRequest request);

    Attendees deleteAttendeeById(Integer attendeeId);
}

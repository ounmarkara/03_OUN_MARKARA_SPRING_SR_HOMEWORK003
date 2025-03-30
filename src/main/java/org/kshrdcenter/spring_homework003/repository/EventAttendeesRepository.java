package org.kshrdcenter.spring_homework003.repository;

import org.apache.ibatis.annotations.*;
import org.kshrdcenter.spring_homework003.model.entity.Attendees;

import java.util.List;

@Mapper
public interface EventAttendeesRepository {

    @Result(property = "attendees_id", column = "attendees_id")
    @Select("""
                SELECT * FROM event_attendee sc
                INNER JOIN  attendees a
                ON sc.attendee_id = a.attendees_id
                WHERE event_id = #{attendees_id};
            """)
    List<Attendees> getAllEventAttendeesById(Integer attendees_id);

    @Insert("""
            INSERT INTO event_attendee VALUES (default, #{event_id}, #{attendees_id})
            """)
    void createEventIdAndAttendeeId(Integer event_id, Integer attendees_id);
}

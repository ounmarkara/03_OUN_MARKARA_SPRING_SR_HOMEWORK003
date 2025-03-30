package org.kshrdcenter.spring_homework003.repository;

import org.apache.ibatis.annotations.*;
import org.kshrdcenter.spring_homework003.model.dto.request.EventsRequest;
import org.kshrdcenter.spring_homework003.model.entity.Events;

import java.util.List;

@Mapper
public interface EventRepository {


    @Results(id = "eventMapper", value = {
            @Result(property = "event_id",column = "event_id"),
            @Result(property = "venue", column = "venue_id",
                    one = @One(select = "org.kshrdcenter.spring_homework003.repository.VenueRepository.getVenueById")),
            @Result(property = "attendees", column = "event_id" ,
                    many = @Many(select = "org.kshrdcenter.spring_homework003.repository.EventAttendeesRepository.getAllEventAttendeesById"))
    })
    @Select("SELECT * FROM events OFFSET #{offset} LIMIT #{limit}")
    List<Events> getAllEvents(@Param("offset") Integer page, @Param("limit") Integer size);


    @Select("""
            INSERT INTO events (event_name, event_date, venue_id)
            VALUES (#{request.event_name}, #{request.event_date}, #{request.venue_id})
            RETURNING *; """)
    Events createEvent(@Param("request") EventsRequest request);

    @ResultMap("eventMapper")
    @Select("""
                SELECT * FROM events
                WHERE event_id = #{eventId};
            """)
    Events getEventById(Integer eventId);

    @Select("""
            DELETE FROM events  
            WHERE event_id = #{event_id}
            """)
    Events deleteEventById(@Param("event_id") Integer eventId);

    @Insert("INSERT INTO event_attendee(event_id, attendee_id) VALUES (#{eventId}, #{attendeeId})")
    void insertEventAttendee(Integer eventId, Integer attendeeId);


    @ResultMap("eventMapper")
    @Select("""
              UPDATE events
                            SET event_name = #{request.event_name}
                            WHERE event_id = #{event_id}
                            RETURNING *;
            """)
    Events updateEventById(@Param("event_id") Integer eventId, EventsRequest request);


    @Select("""
            INSERT INTO events VALUES (default, #{req.event_name}, #{req.event_date}, #{req.venue_id})
            RETURNING *;
            """)
    Events insertEvent(@Param("req") EventsRequest request);
}
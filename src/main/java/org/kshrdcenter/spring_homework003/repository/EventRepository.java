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
            INSERT INTO events
            VALUES (default, #{request.event_name}, #{request.event_date}, #{request.attendees_id})
            RETURNING *; """)
    Events createEvent(EventsRequest request);


    @ResultMap("eventMapper")
    @Select("""
                SELECT * FROM events
                WHERE event_id = #{eventId};
            """)
    Events getEventById(Long eventId);

    @Select("""
            DELETE FROM events  
            WHERE event_id = #{event_id}
            """)
    Events deleteEventById(@Param("event_id") Long eventId);


    @ResultMap("eventMapper")
    @Select("""
              UPDATE events
                            SET event_name = #{request.event_name}
                            WHERE event_id = #{event_id}
                            RETURNING *;
            """)
    Events updateEventById(@Param("event_id") Long eventId, EventsRequest request);
}
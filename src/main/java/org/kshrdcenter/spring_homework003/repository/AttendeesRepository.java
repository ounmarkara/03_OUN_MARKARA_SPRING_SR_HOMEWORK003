package org.kshrdcenter.spring_homework003.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.kshrdcenter.spring_homework003.model.dto.request.AttendeesRequest;
import org.kshrdcenter.spring_homework003.model.entity.Attendees;
import org.kshrdcenter.spring_homework003.model.entity.Venue;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface AttendeesRepository {

    @Select("""
    
    SELECT * FROM attendees
    OFFSET #{offset} LIMIT #{limit}
""")

    List<Attendees> getAllAttendees(@Param("offset") Integer page, @Param ("limit") Integer size);

    @Select("""
        INSERT INTO attendees
        VALUES (default, #{request.attendee_name}, #{request.email})
        RETURNING *;
        
""")
    Attendees createAttendees(@Param("request") AttendeesRequest request);


    @Select("""
    SELECT * FROM attendees 
    WHERE attendees_id = #{attendee_id}
""")
    Attendees getAttendeeById(@Param("attendee_id") Long attendeeId);


    @Select("""
        UPDATE attendees
        SET attendee_name = #{request.attendee_name}, email = #{request.email}
        WHERE attendees_id = #{attendee_id}
""")
    Attendees updateAttendeeById(@Param("attendee_id") Long attendeeId,@Param("request") AttendeesRequest request);

    @Select("""
    DELETE FROM attendees
    WHERE attendees_id = #{attendee_id}
""")
    Attendees deleteAttendeeById(@Param("attendee_id") Long attendeeId);


}

package org.kshrdcenter.spring_homework003.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.kshrdcenter.spring_homework003.model.entity.Attendees;

import java.util.List;

@Mapper
public interface EventAttendeesRepository {

    @Result(property = "attendees_id",column = "attendees_id")
    @Select("""
    SELECT * FROM attendees sc 
    INNER JOIN  event_attendee a 
    ON sc.attendees_id = a.attendees_id 
    WHERE event_id = #{attendees_id};
""")
    List <Attendees> getAllEventAttendeesById(Integer attendees_id);
}

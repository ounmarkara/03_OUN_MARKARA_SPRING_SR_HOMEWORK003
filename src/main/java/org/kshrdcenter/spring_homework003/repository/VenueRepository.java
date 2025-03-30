package org.kshrdcenter.spring_homework003.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.kshrdcenter.spring_homework003.model.dto.request.VenueRequest;
import org.kshrdcenter.spring_homework003.model.entity.Venue;

import java.util.List;

@Mapper
public interface VenueRepository {


    @Select("""
                SELECT * FROM venues
                OFFSET #{offset} LIMIT #{limit};
            """)
    List<Venue> getAllVenue(@Param("offset") Integer page, @Param("limit") Integer size);


    @Select("""
                INSERT INTO venues
                VALUES (default, #{request.venue_name}, #{request.location})
                RETURNING *;
            """)
    Venue saveVenue(@Param("request") VenueRequest request);


    @Select("""
                SELECT * FROM venues 
                WHERE venue_id = #{venue_id}
            """)
    Venue getVenueById(@Param("venue_id") Integer venueId);

    @Select("""
                UPDATE venues
                SET venue_name = #{request.venue_name}, location = #{request.location}
                WHERE venue_Id = #{venue_id}
                RETURNING *;
            """)
    Venue updateVenueById(@Param("venue_id") Integer venue_Id, @Param("request") VenueRequest request);


    @Select("""
            
                    DELETE FROM venues
                    WHERE venue_id = #{venue_id}
            """)
    Venue deleteVenueById(@Param("venue_id") Integer venueId);
}

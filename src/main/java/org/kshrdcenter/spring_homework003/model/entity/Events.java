package org.kshrdcenter.spring_homework003.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Events {
    private Integer event_id;
    private String event_name;
    private Timestamp event_date;
    private Venue venue;
    private List <Attendees> attendees    ;
}

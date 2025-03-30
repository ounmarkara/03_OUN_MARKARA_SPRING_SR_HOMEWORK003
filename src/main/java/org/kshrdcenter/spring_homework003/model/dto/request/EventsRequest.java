package org.kshrdcenter.spring_homework003.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.kshrdcenter.spring_homework003.model.entity.Attendees;
import org.kshrdcenter.spring_homework003.model.entity.Venue;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventsRequest {
    @NotBlank(message = "Event's name cannot be empty!")
    @Length(max = 50, message = "Event's name cannot exceed 50 characters!")
    private String event_name;
    @NotNull(message = "Event's date time cannot be null!")
    private Timestamp event_date;

    private Integer venue_id;
    @NotEmpty(message = "Attendee's id list cannot be empty!")
    private List <Integer> attendeeId;

}

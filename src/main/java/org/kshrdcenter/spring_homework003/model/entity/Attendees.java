package org.kshrdcenter.spring_homework003.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendees {
    private  Integer attendees_id;
    private String attendee_name;
    private String email;
}

package org.kshrdcenter.spring_homework003.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeesRequest {
    @NotBlank(message = "Attendee's name cannot be empty!")
    @Length(max = 50, message = "Attendee's name cannot exceed 50 characters!")
    private String attendee_name;

    @Email(message = "Attendee's email must be in a correct format!")
    @NotBlank(message = "Attendee's email cannot be empty!")
    @Length(max = 50, message = "Attendee's email cannot exceed 50 characters!")
    private String email;
}

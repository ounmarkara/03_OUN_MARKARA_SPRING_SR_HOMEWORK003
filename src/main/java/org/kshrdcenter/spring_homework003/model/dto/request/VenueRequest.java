package org.kshrdcenter.spring_homework003.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {
    @NotBlank(message = "Venue's name cannot be empty!")
    @Length(max = 50, message = "Venue's name cannot exceed 50 characters!")
    private String venue_name;
    @NotBlank(message = "Venue's location cannot be empty!")
    @Length(max = 50, message = "Venue's location's name cannot exceed 50 characters!")
    private String location;
}

package org.kshrdcenter.spring_homework003.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.kshrdcenter.spring_homework003.model.dto.request.VenueRequest;
import org.kshrdcenter.spring_homework003.model.dto.response.ApiResponse;
import org.kshrdcenter.spring_homework003.model.entity.Venue;
import org.kshrdcenter.spring_homework003.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @Operation(summary = "Get All Venue")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Venue>>> getAllVenue(@RequestParam(defaultValue = "1") Integer page,
                                                                @RequestParam(defaultValue = "10") Integer size) {
        List<Venue> venues = venueService.getAllVenue(page, size);
        ApiResponse<List<Venue>> response = ApiResponse.<List<Venue>>builder()
                .success(true)
                .message("Get all venue successful!")
                .status(HttpStatus.OK)
                .payload(venues)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Operation(summary = "Save Venue")
    @PostMapping
    public ResponseEntity<ApiResponse<Venue>> saveVenue(@RequestBody VenueRequest request) {
        Venue venue = venueService.saveVenue(request);
        ApiResponse<Venue> response = ApiResponse.<Venue>builder()
                .success(true)
                .message("Saved venue successful!")
                .status(HttpStatus.CREATED)
                .payload(venue)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Get Venue By ID")
    @GetMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<Venue>> getVenueById(@PathVariable("venue-id") Integer venueId) {
        Venue venue = venueService.getVenueById(venueId);
        ApiResponse<Venue> response = ApiResponse.<Venue>builder()
                .success(true)
                .message("Get venue by " + venueId + " Successfully!")
                .status(HttpStatus.OK)
                .payload(venue)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Operation(summary = "Delete Venue By ID")
    @DeleteMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<Venue>> deleteVenueById(@PathVariable("venue-id") Integer venueId) {
        Venue venue = venueService.deleteVenueById(venueId);
        ApiResponse<Venue> response = ApiResponse.<Venue>builder()
                .success(true).message("Delete venue by " + venueId + "Successfully !")
                .status(HttpStatus.OK)
                .payload(venue)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
    @Operation(summary = "Update Venue By Id")
    @PutMapping("/{venue-id}")
    public ResponseEntity<ApiResponse<Venue>> updateVenueById(@PathVariable("venue-id") Integer venueId,
                                                              @RequestBody VenueRequest request) {
        Venue venue = venueService.updateVenueById(venueId, request);
        ApiResponse<Venue> response = ApiResponse.<Venue>builder()
                .success(true)
                .message("Update venue by " + venueId + "successful!")
                .status(HttpStatus.OK)
                .payload(venue)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}



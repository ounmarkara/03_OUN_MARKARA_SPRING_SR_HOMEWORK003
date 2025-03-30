package org.kshrdcenter.spring_homework003.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.kshrdcenter.spring_homework003.model.dto.request.AttendeesRequest;
import org.kshrdcenter.spring_homework003.model.dto.response.ApiResponse;
import org.kshrdcenter.spring_homework003.model.entity.Attendees;
import org.kshrdcenter.spring_homework003.model.entity.Venue;
import org.kshrdcenter.spring_homework003.service.AttendeesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeesController {
    private final AttendeesService attendeesService;
    private final RestClient.Builder builder;

    public AttendeesController(AttendeesService attendeesService, RestClient.Builder builder) {
        this.attendeesService = attendeesService;
        this.builder = builder;
    }
    @Operation(summary = "Get all Attendees")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Attendees>>> getAllAttendees(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        List<Attendees> attendees = attendeesService.getAllAttendees(page, size);
        ApiResponse<List<Attendees>> response = ApiResponse.<List<Attendees>>builder()
                .success(true)
                .message("get AllAttendees is Successfully !")
                .status(HttpStatus.OK)
                .payload(attendees)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Operation(summary = "create Attendees")
    @PostMapping
    public ResponseEntity<ApiResponse<Attendees>> createAttendees(@RequestBody AttendeesRequest request) {
        Attendees attendees = attendeesService.createAttendees(request);
        ApiResponse<Attendees> response = ApiResponse.<Attendees>builder()
                .success(true)
                .status(HttpStatus.CREATED)
                .message("Save Attendees Successfully!")
                .payload(attendees)
                .instant(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Get Attendee By Id")
    @GetMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<Attendees>> getAttendeeById(@PathVariable("attendee-id") Integer attendeeId) {
        Attendees attendees = attendeesService.getAttendeeById(attendeeId);
        ApiResponse<Attendees> response = ApiResponse.<Attendees>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Get Attendee by " + attendeeId + "successfully!")
                .payload(attendees)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Update Attendee By ID")
    @PutMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<Attendees>> updateAttendeeById(@PathVariable("attendee-id") Integer attendeeId, @RequestBody AttendeesRequest request) {
        Attendees attendees = attendeesService.updateAttendeeById(attendeeId, request);
        ApiResponse<Attendees> response = ApiResponse.<Attendees>builder()
                .success(true)
                .message("Update Attendee by id " + attendeeId + " Successfully!")
                .payload(attendees)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Delete Attendee By Id")
    @DeleteMapping("/{attendee-id}")
    public ResponseEntity<ApiResponse<Attendees>> deleteAttendeeById(@PathVariable("attendee-id") Integer attendeeId) {
        Attendees attendees = attendeesService.deleteAttendeeById(attendeeId);
        ApiResponse<Attendees> response = ApiResponse.<Attendees>builder()
                .success(true)
                .message("Delete Attendee by id " + attendeeId + " Successfully!")
                .status(HttpStatus.OK)
                .payload(attendees)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

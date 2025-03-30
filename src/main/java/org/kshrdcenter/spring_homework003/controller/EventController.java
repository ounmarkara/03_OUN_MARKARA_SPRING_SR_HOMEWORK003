package org.kshrdcenter.spring_homework003.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.apache.ibatis.annotations.Param;
import org.kshrdcenter.spring_homework003.model.dto.request.EventsRequest;
import org.kshrdcenter.spring_homework003.model.dto.response.ApiResponse;
import org.kshrdcenter.spring_homework003.model.entity.Events;
import org.kshrdcenter.spring_homework003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @Operation(summary = "Get All Event ")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Events>>> getAllEvent(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        List<Events> events = eventService.getAllEvents(page, size);
        ApiResponse<List<Events>> response = ApiResponse.<List<Events>>builder()
                .success(true)
                .message("Get All Event is Successfully!")
                .status(HttpStatus.OK)
                .payload(events)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Operation(summary = "Create Event")
    @PostMapping
    public ResponseEntity<ApiResponse<Events>> createEvent(@RequestBody EventsRequest request) {
        Events events = eventService.createEvent(request);
        ApiResponse<Events> response = ApiResponse.<Events>builder()
                .success(true)
                .message("Saved Event successful!")
                .status(HttpStatus.CREATED)
                .payload(events)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Get Event By Id")
    @GetMapping("/{event-id}")
    public ResponseEntity<ApiResponse<Events>> getEventById(@PathVariable("event-id") Integer eventId) {
        Events event = eventService.getEventById(eventId);
        ApiResponse<Events> response = ApiResponse.<Events>builder()
                .success(true)
                .message("Get book by " + eventId + " successful!")
                .status(HttpStatus.OK)
                .payload(event)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Delete Event By Id")
    @DeleteMapping("/{event-id}")
    public ResponseEntity<ApiResponse<Events>> deleteEventById(@PathVariable("event-id") Integer event_id) {
        Events events = eventService.deleteEventById(event_id);
        ApiResponse<Events> response = ApiResponse.<Events>builder()
                .success(true)
                .message("Delete Event by" + event_id + "successfully")
                .status(HttpStatus.OK)
                .payload(events)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Update Event By ID")
    @PutMapping("/{event-id}")
    public ResponseEntity<ApiResponse<Events>> updateEventById(@PathVariable("event-id") Integer eventId, @RequestBody EventsRequest request) {
        Events events = eventService.updateEventById(eventId, request);
        ApiResponse<Events> response = ApiResponse.<Events>builder()
                .success(true)
                .message("Update Event by id " + eventId + "successfully")
                .status(HttpStatus.OK)
                .payload(events)
                .instant(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

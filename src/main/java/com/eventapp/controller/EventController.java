package com.eventapp.controller;

import com.eventapp.dto.CreateEventRequest;
import com.eventapp.dto.CreateEventResponse;
import com.eventapp.dto.GetEventResponse;
import com.eventapp.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping("/events")
    public ResponseEntity<CreateEventResponse> createEvent(@RequestBody CreateEventRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.save(request));

    }

    @GetMapping("/events/{eventsId}")
    public ResponseEntity<GetEventResponse> getEvent(@PathVariable Long eventsId) {
        return ResponseEntity.status(HttpStatus.OK).body(eventService.findOne(eventsId));
    }

    @GetMapping("events")
    public ResponseEntity<List<GetEventResponse>> getEvents() {
        return ResponseEntity.status(HttpStatus.OK).body(eventService.findAll());
    }
}

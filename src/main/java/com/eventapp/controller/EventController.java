package com.eventapp.controller;

import com.eventapp.dto.*;
import com.eventapp.entity.Event;
import com.eventapp.repository.EventRepository;
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
    private final EventRepository eventRepository;

    @PostMapping("/events")
    public ResponseEntity<CreateEventResponse> createEvent(@RequestBody CreateEventRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.save(request));

    }

    @GetMapping("/events/{eventsId}")
    public ResponseEntity<GetEventResponse> getEvent(@PathVariable Long eventsId) {
        return ResponseEntity.status(HttpStatus.OK).body(eventService.findOne(eventsId));
    }

    @GetMapping("events") // @RequestParam을 사용함으로써 ?key=value 형태의 값을 받을 수 있게 해줌 (아래의 경우 작성자)
    public ResponseEntity<List<GetEventResponse>> getEvents(@RequestParam String writerName) {
        return ResponseEntity.status(HttpStatus.OK).body(eventService.findAll(writerName));
    }

    @PutMapping("/events/{eventsId}")
    public ResponseEntity<UpdateEventResponse> update(
            @PathVariable Long eventsId,
            @RequestBody UpdateEventRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
                eventService.updateEvent(eventsId, request)
        );
    }
}
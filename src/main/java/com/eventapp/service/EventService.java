package com.eventapp.service;

import com.eventapp.dto.CreateEventRequest;
import com.eventapp.dto.CreateEventResponse;
import com.eventapp.entity.Event;
import com.eventapp.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    @Transactional
    public CreateEventResponse save(CreateEventRequest request) {
        Event event = new Event(
                request.getEventName(),
                request.getDescription(),
                request.getWriterName(),
                request.getPassword()
        );

        Event savedEvent = eventRepository.save(event);
        return new CreateEventResponse(
                savedEvent.getId(),
                savedEvent.getEventName(),
                savedEvent.getDescription(),
                savedEvent.getWriterName(),
                savedEvent.getCreatedAt(),
                savedEvent.getModifiedAt()
        );
    }
}

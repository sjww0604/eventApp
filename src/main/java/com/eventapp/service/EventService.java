package com.eventapp.service;

import com.eventapp.dto.*;
import com.eventapp.entity.Event;
import com.eventapp.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional (readOnly = true)
    public GetEventResponse findOne(Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(
                () -> new IllegalStateException("없는 작성자입니다.")
        );
        return new GetEventResponse(
                event.getId(),
                event.getEventName(),
                event.getDescription(),
                event.getWriterName(),
                event.getCreatedAt(),
                event.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<GetEventResponse> findAll(String writerName) {
        List<Event> events = eventRepository.findByWriterNameOrderByModifiedAtDesc(writerName);

        List<GetEventResponse> dtos = new ArrayList<>();
        for (Event event : events) {
            GetEventResponse dto = new GetEventResponse(
                    event.getId(),
                    event.getEventName(),
                    event.getDescription(),
                    event.getWriterName(),
                    event.getCreatedAt(),
                    event.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional
    public UpdateEventResponse updateEvent(Long eventsId, UpdateEventRequest request) {
        Event event = eventRepository.findById(eventsId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        event.updateEvent(request.getEventName(),request.getWriterName());

        return new UpdateEventResponse(
                event.getId(),
                event.getEventName(),
                event.getWriterName()
        );
    }

    @Transactional
    public void delete(Long eventsId, String password) {
        boolean existence = eventRepository.existsById(eventsId);
        if (!existence) {
            throw new IllegalStateException("없는 일정입니다.");
        }
        eventRepository.deleteById(eventsId);
    }
}

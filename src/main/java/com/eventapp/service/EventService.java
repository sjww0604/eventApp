package com.eventapp.service;

import com.eventapp.dto.comment.CreateCommentResponse;
import com.eventapp.dto.event.*;
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
    public GetEventDetailResponse findOne(Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        List<CreateCommentResponse> commentDtos = event.getCommentList().stream()
                .map(c -> new CreateCommentResponse(
                        c.getId(),
                        c.getContent(),
                        c.getWriter(),
                        c.getCreatedAt(),
                        c.getModifiedAt()
                ))
                .toList();

        return new GetEventDetailResponse(
                event.getId(),
                event.getEventName(),
                event.getDescription(),
                event.getWriterName(),
                event.getCreatedAt(),
                event.getModifiedAt(),
                commentDtos
        );
    }

    @Transactional(readOnly = true)
    public List<GetEventResponse> findAll(String writerName) {
        List<Event> events;

        if (writerName == null || writerName.isBlank()) {
            // 전체 조회
            events = eventRepository.findAllByOrderByModifiedAtDesc();
        } else {
            // 작성자별 조회
            events = eventRepository.findByWriterNameOrderByModifiedAtDesc(writerName);
        }

        List<GetEventResponse> dtos = new ArrayList<>();
        for (Event event : events) {

            dtos.add(new GetEventResponse(
                    event.getId(),
                    event.getEventName(),
                    event.getDescription(),
                    event.getWriterName(),
                    event.getCreatedAt(),
                    event.getModifiedAt()
            ));
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

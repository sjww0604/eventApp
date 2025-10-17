package com.eventapp.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetEventResponse {

    private final Long id;
    private final String eventName;
    private final String description;
    private final String writerName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public GetEventResponse(Long id, String eventName, String description, String writerName, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.eventName = eventName;
        this.description = description;
        this.writerName = writerName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}

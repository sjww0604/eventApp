package com.eventapp.dto.event;

import lombok.Getter;

@Getter
public class CreateEventRequest {

    private final String eventName;
    private final String description;
    private final String writerName;
    private final String password;

    public CreateEventRequest(String eventName, String description, String writerName, String password) {
        this.eventName = eventName;
        this.description = description;
        this.writerName = writerName;
        this.password = password;
    }
}

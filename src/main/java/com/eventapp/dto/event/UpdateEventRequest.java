package com.eventapp.dto.event;

import lombok.Getter;

@Getter
public class UpdateEventRequest {
    private String eventName;
    private String writerName;
    private String password;
}

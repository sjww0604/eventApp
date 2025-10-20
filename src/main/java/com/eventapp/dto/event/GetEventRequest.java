package com.eventapp.dto.event;

import lombok.Getter;

@Getter
public class GetEventRequest {

    private String eventName;
    private String description;
    private String writerName;
    private String password;
}

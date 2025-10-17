package com.eventapp.dto;

import lombok.Getter;

@Getter
public class CreateEventRequest {

    private String eventName;
    private String description;
    private String writerName;
    private String password;
}

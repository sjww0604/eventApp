package com.eventapp.dto;

import lombok.Getter;

@Getter
public class GetEventRequest {

    private String eventName;
    private String description;
    private String writerName;
    private String password;
}

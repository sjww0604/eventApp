package com.eventapp.dto;

import lombok.Getter;

@Getter
public class UpdateEventRequest {
    private String eventName;
    private String writerName;
    private String password;
}

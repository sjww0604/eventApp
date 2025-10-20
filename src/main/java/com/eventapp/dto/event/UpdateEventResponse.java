package com.eventapp.dto.event;

import lombok.Getter;

@Getter
public class UpdateEventResponse {
    private final Long id;
    private final String eventName;
    private final String writerName;


    public UpdateEventResponse(Long id, String eventName,String writerName) {
        this.id = id;
        this.eventName = eventName;
        this.writerName = writerName;
    }
}

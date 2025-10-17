package com.eventapp.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "events")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class Event extends BaseEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String eventName;
    String description;
    String writerName;
    String password;

    public Event(String eventName, String description, String writerName, String password) {
        this.eventName = eventName;
        this.description = description;
        this.writerName = writerName;
        this.password = password;
    }

    public void updateEvent(String eventName, String writerName) {
        this.eventName = eventName;
        this.writerName = writerName;
    }
}

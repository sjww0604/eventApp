package com.eventapp.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "events")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class Event {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String eventName;
    String description;
    @Column(nullable = false)
    String writer;
    @Column(nullable = false)
    String password;

    public Event(String eventName, String description, String writer, String password) {
        this.eventName = eventName;
        this.description = description;
        this.writer = writer;
        this.password = password;
    }

    public void update(String eventName, String description, String writer, String password) {
        this.eventName = eventName;
        this.description = description;
        this.writer = writer;
        this.password = password;
    }
}

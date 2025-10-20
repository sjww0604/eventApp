package com.eventapp.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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

    // 양방향 연관관계 설정
    @OneToMany (mappedBy = "event")
    private List<Comment> commentList;

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

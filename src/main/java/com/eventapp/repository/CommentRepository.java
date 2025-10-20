package com.eventapp.repository;

import com.eventapp.entity.Comment;
import com.eventapp.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Long countByEventId(Long eventId);
}

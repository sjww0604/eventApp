package com.eventapp.service;

import com.eventapp.dto.comment.*;
import com.eventapp.entity.Comment;
import com.eventapp.entity.Event;
import com.eventapp.repository.CommentRepository;
import com.eventapp.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final EventRepository eventRepository;
    private final CommentRepository commentRepository;


    @Transactional
    public CreateCommentResponse create(Long eventId, CreateCommentRequest req) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalStateException("없는 일정입니다."));

        Long commentCount = commentRepository.countByEventId(eventId);
        // 댓글 개수제한 조건문 작성
        if (commentCount >= 10) {
            throw new IllegalStateException("하나의 일정에는 10개의 댓글만 가능합니다.");
        }
        Comment comment = new Comment(
                event,
                req.getContent(),
                req.getWriter(),
                req.getPassword()
        );
        Comment savedComment = commentRepository.save(comment);

        return new CreateCommentResponse(
                savedComment.getId(),
                savedComment.getContent(),
                savedComment.getWriter(),
                savedComment.getCreatedAt(),
                savedComment.getModifiedAt()
        );
    }
}
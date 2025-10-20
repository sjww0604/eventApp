package com.eventapp.controller;

import com.eventapp.dto.comment.CreateCommentRequest;
import com.eventapp.dto.comment.CreateCommentResponse;
import com.eventapp.repository.CommentRepository;
import com.eventapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/events/{eventId}/comments")
    public ResponseEntity<CreateCommentResponse> createComment(
            @PathVariable("eventId") Long eventId,
            @RequestBody CreateCommentRequest request
    ) {
        CreateCommentResponse body = commentService.create(eventId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

}

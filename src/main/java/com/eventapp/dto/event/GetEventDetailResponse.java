package com.eventapp.dto.event;

import com.eventapp.dto.comment.CreateCommentResponse;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GetEventDetailResponse {

    private final Long id;
    private final String eventName;
    private final String description;
    private final String writerName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    // 일정 조회 시 댓글 정보도 같이 응답할 수 있도록 설정
    private final List<CreateCommentResponse> commentList;

    public GetEventDetailResponse(Long id, String eventName, String description, String writerName, LocalDateTime createdAt, LocalDateTime modifiedAt, List<CreateCommentResponse> commentList) {
        this.id = id;
        this.eventName = eventName;
        this.description = description;
        this.writerName = writerName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.commentList = commentList;
    }
}

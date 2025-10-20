package com.eventapp.dto.comment;

import lombok.Getter;

@Getter
public class CreateCommentRequest {

    // 내용 , 작성자, 비밀번호
    private final String content;
    private final String writer;
    private final String password;

    public CreateCommentRequest(String content, String writer, String password) {
        this.content = content;
        this.writer = writer;
        this.password = password;
    }

}

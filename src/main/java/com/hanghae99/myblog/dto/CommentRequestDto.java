package com.hanghae99.myblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class CommentRequestDto {
    private final String comment;
    public CommentRequestDto(String comment){
        this.comment = comment;

    }
}

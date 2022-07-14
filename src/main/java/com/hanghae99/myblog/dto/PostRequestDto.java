package com.hanghae99.myblog.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PostRequestDto {

    private final String title;
    private final String contents;
    private final Long like_count;

    public PostRequestDto(String title, String contents){
        this.title = title;
        this.contents = contents;
        this.like_count = 0L;
    }
}

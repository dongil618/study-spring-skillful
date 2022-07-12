package com.hanghae99.myblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostRequestDto {

    private String title;
    private String contents;
    private Long like_count;
}

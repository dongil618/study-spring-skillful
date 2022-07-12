package com.hanghae99.myblog.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SigninRequestDto {
    private final String nickname;
    private final String password;

    public SigninRequestDto(String nickname, String password){
        this.nickname = nickname;
        this.password = password;
    }
}

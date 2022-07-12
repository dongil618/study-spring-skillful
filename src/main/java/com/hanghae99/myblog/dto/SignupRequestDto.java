package com.hanghae99.myblog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class SignupRequestDto {
    private final String nickname;
    private final String password;
    private final String checkPassword;

    public SignupRequestDto(String nickname, String password, String checkPassword){
        this.nickname = nickname;
        this.password = password;
        this.checkPassword = checkPassword;
    }
}

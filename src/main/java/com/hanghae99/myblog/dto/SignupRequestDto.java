package com.hanghae99.myblog.dto;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ToString
@Getter
public class SignupRequestDto {
    @NotNull(message = "닉네임을 입력해주세요.")
    @Size(min=3, message = "3글자 이상으로 입력해주세요.")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "영어 대소문자, 숫자만 사용가능합니다.")
    private final String nickname;

    @NotNull(message = "비밀번호를 입력해주세요.")
    @Size(min=4, message = "4글자 이상으로 입력해주세요.")
    private final String password;
    @NotNull(message = "비밀번호 확인을 입력해주세요.")
    @Size(min=4, message = "4글자 이상으로 입력해주세요.")
    private final String checkPassword;

    public SignupRequestDto(String nickname, String password, String checkPassword){
        this.nickname = nickname;
        this.password = password;
        this.checkPassword = checkPassword;
    }
}

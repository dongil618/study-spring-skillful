package com.hanghae99.myblog.service;

import com.hanghae99.myblog.dto.SignupRequestDto;
import com.hanghae99.myblog.model.User;
import com.hanghae99.myblog.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public void registerUser(SignupRequestDto requestDto){
        String nickname = requestDto.getNickname();
        String password = requestDto.getPassword();
        String checkPassword = requestDto.getCheckPassword();
        System.out.println(nickname + " " + password + " " + checkPassword); //UserService까지 SignupReqestDto가 잘 전달되는지 확인

    }

//    // 닉네임 유혀성 검사
//    public void validateNickname(User user){
//        String nickname = user.getNickname();
//        Optional<User> found = userRepository.findByNickname(nickname);
//        if(found.isPresent()){
//            throw new IllegalArgumentException("중복된 사용자 닉네임이 존재합니다.");
//        } else if(nickname.length() <= 3){
//
//        }
//    }
//
//    // 비밀번호 유혀성 검사
//    public boolean validatePassword(User user){
//        return true;
//    }
}

package com.hanghae99.myblog.service;

import com.hanghae99.myblog.dto.SignupRequestDto;
import com.hanghae99.myblog.model.User;
import com.hanghae99.myblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(SignupRequestDto requestDto){
        // System.out.println(nickname + " " + password + " " + checkPassword); //UserService까지 SignupReqestDto가 잘 전달되는지 확인
        validateNickname(requestDto);
        validatePassword(requestDto);
        String nickname = requestDto.getNickname();
        String password = passwordEncoder.encode(requestDto.getPassword());
        User user = new User(nickname, password);
        userRepository.save(user);
    }


    public void validateNickname(SignupRequestDto requestDto){
        String nickname = requestDto.getNickname();
        Optional<User> found = userRepository.findByNickname(nickname);
        if(found.isPresent()){
            throw new IllegalArgumentException("중복된 사용자 닉네임이 존재합니다.");
        }
    }


    public void validatePassword(SignupRequestDto requestDto){
        String nickname = requestDto.getNickname();
        String password = requestDto.getPassword();
        String checkPassword = requestDto.getCheckPassword();

        if(password.contains(nickname)){
            throw new IllegalArgumentException("비밀번호 내부에 닉네임이 포함되어 있습니다.");
        }
        if(!password.equals(checkPassword)){
            throw new IllegalArgumentException("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }
    }
}

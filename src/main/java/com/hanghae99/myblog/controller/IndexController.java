package com.hanghae99.myblog.controller;

import com.hanghae99.myblog.dto.SignupRequestDto;
import com.hanghae99.myblog.repository.UserRepository;
import com.hanghae99.myblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserService userService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/signin")
    public String signin(){
        return "signin";
    }

    @PostMapping("/signin")
    public String postSignin(){
        System.out.println("signin post");
        return "redirect:/signin";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(SignupRequestDto requestDto){
        userService.registerUser(requestDto);
        System.out.println(requestDto.toString());
        //User user = new User(requestDto);
        //System.out.println(user.toString());
        //userRepository.save(user);
        return "redirect:/signin";
    }

}

package com.hanghae99.myblog.controller;

import com.hanghae99.myblog.dto.SigninRequestDto;
import com.hanghae99.myblog.dto.SignupRequestDto;
import com.hanghae99.myblog.security.UserDetailsImpl;
import com.hanghae99.myblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserService userService;

    @GetMapping("/")
    public String home(Model model,@AuthenticationPrincipal UserDetailsImpl userDetails){
        try{
            model.addAttribute("nickname", userDetails.getUsername());
            return "index";
        } catch (NullPointerException nullPointerException){
            return "before_signin_index";
        }

    }

    @GetMapping("/signin")
    public String signin(){
        return "signin";
    }


    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(@Valid SignupRequestDto requestDto){
        userService.registerUser(requestDto);
        System.out.println(requestDto.toString());
        return "redirect:/signin";
    }

}

package com.hanghae99.myblog.controller;

import com.hanghae99.myblog.dto.CommentRequestDto;
import com.hanghae99.myblog.dto.PostRequestDto;
import com.hanghae99.myblog.model.Comment;
import com.hanghae99.myblog.model.Post;
import com.hanghae99.myblog.model.User;
import com.hanghae99.myblog.repository.CommentRepository;
import com.hanghae99.myblog.repository.PostRepository;
import com.hanghae99.myblog.security.UserDetailsImpl;
import com.hanghae99.myblog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;
    private final PostRepository postRepository;

    @PostMapping("/comment/{id}")
    public String createPost(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id, CommentRequestDto requestDto){
        User user = userDetails.getUser();
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            Comment comment = new Comment(requestDto, user, post.get());
            System.out.println(requestDto.toString());
            System.out.println(user.toString());
            System.out.println(comment.toString());
            commentRepository.save(comment);
        }
        return "redirect:/posts/" + Long.toString(id);
    }
}

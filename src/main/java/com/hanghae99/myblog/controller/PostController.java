package com.hanghae99.myblog.controller;

import com.hanghae99.myblog.dto.PostRequestDto;
import com.hanghae99.myblog.model.Comment;
import com.hanghae99.myblog.model.Post;
import com.hanghae99.myblog.model.User;
import com.hanghae99.myblog.repository.CommentRepository;
import com.hanghae99.myblog.repository.PostRepository;
import com.hanghae99.myblog.security.UserDetailsImpl;
import com.hanghae99.myblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final PostService postService;

    @GetMapping("/posts/write")
    public String wirtePost(){
        return "write";
    }

    @PostMapping("/posts")
    public String createPost(@AuthenticationPrincipal UserDetailsImpl userDetails, PostRequestDto requestDto){
        User user = userDetails.getUser();
        Post post = new Post(requestDto, user);
        System.out.println(user.toString());
        System.out.println(post.toString());
        postRepository.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String getPostList(Model model){
        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();
        // List<Comment> comments = commentRepository.
        System.out.println(Arrays.toString(posts.toArray()));
        System.out.println(Arrays.toString(posts.toArray()));
        model.addAttribute("posts", posts);
        return "postList";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model){
        Optional<Post> post = postRepository.findById(id);
        post.ifPresent(value -> model.addAttribute("post", value));
        return "detail";
    }

    @DeleteMapping("/posts/{id}")
    @ResponseBody
    public Long deletePost(@PathVariable Long id){
        System.out.println("deletePost 호출");
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            postRepository.deleteById(id);
        }
        return id;
    }

    @PutMapping("posts/{id}")
    @ResponseBody
    public  Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            postService.update(id, requestDto);
        }
        return id;
    }
}

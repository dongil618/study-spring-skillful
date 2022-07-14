package com.hanghae99.myblog.service;

import com.hanghae99.myblog.dto.PostRequestDto;
import com.hanghae99.myblog.model.Post;
import com.hanghae99.myblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;


    public Long update(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("존재하지 않는 아이디입니다.")
        );
        post.update(requestDto);
        return post.getId();
    }
}

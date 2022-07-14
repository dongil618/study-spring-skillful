package com.hanghae99.myblog.repository;

import com.hanghae99.myblog.model.Comment;
import com.hanghae99.myblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    //List<Comment> findAllByOrderByCreatedAtDesc(Long post_id);
}

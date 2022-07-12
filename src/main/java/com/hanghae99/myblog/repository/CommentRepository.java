package com.hanghae99.myblog.repository;

import com.hanghae99.myblog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

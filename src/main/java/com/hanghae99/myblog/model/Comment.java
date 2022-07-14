package com.hanghae99.myblog.model;

import com.hanghae99.myblog.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Optional;

@ToString
@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENT_ID")
    private  Long id;

    @ManyToOne
    @JoinColumn(name="POST_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;


    @Column(nullable = false)
    private String comment;

    public Comment(CommentRequestDto requestDto, User user, Post post){
        this.comment = requestDto.getComment();
        this.user = user;
        this.post = post;
    }

    // 댓글 수정
    public void update(CommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
    }
}

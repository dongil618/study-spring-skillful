package com.hanghae99.myblog.model;

import com.hanghae99.myblog.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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

    public Comment(String comment){
        this.comment = comment;
    }

    public Comment(CommentRequestDto requestDto){
        this.comment = requestDto.getComment();
    }

}

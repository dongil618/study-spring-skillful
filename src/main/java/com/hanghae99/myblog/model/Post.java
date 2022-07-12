package com.hanghae99.myblog.model;

import com.hanghae99.myblog.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@Entity
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "POST_ID")
    private  Long id;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @Column(nullable = false)
    private String title;

    private String contents;

    @Column
    private Long like_count;

    public Post(String title, String contents, Long like_count){
        this.title = title;
        this.contents = contents;
        this.like_count = like_count;
    }

    public Post(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.like_count = requestDto.getLike_count();
    }

}

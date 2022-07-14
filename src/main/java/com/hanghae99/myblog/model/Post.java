package com.hanghae99.myblog.model;

import com.hanghae99.myblog.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Setter
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "POST_ID")
    private  Long id;

//    @OneToMany
//    @JoinColumn(name = "POST_ID")
//    private List<User> users = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @Column(nullable = false)
    private String title;

    private String contents;

    @Column
    private Long like_count;


    public Post(PostRequestDto requestDto, User user){
        this.title = requestDto.getTitle();
        this.user = user;
        this.contents = requestDto.getContents();
        this.like_count = requestDto.getLike_count();
    }


    // 게시글 수정
    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

}

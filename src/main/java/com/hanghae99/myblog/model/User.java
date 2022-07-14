package com.hanghae99.myblog.model;

import com.hanghae99.myblog.dto.SignupRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor
@Entity
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private  Long id;

//    @OneToMany
//    @Column(name="USER_ID")
//    private List<Post> posts = new ArrayList<>();
//
//    @OneToMany
//    @Column(name="USER_ID")
//    private List<Comment> comments = new ArrayList<>();


    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    public User(String nickname, String password){
        this.nickname = nickname;
        this.password = password;
    }


}

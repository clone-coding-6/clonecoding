package com.example.clonecoding.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class User {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(unique = true)
    private Long kakaoId;

    @Column
    private String imageUrl;

    public User(String username, String nickname, String enPassword, String imageUrl) {
        this.email = username;
        this.nickname = nickname;
        this.password = enPassword;
        this.imageUrl = imageUrl;
    }

    public User(String username){
        this.email = username;
    }
}

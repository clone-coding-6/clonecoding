package com.example.clonecoding.dto;

import lombok.Getter;

@Getter
public class SignupRequestDto {
    private String email;
    private String nickname;
    private String password;
//    private String passwordCheck;
    private String imageUrl;
}

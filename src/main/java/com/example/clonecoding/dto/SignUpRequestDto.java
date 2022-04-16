package com.example.clonecoding.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    private String email;
    private String password;
    private String passwordCheck;
    private String nickname;
    private boolean admin = false;
    private String adminToken = "";
}

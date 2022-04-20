package com.example.clonecoding.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoResponseDto {
    boolean result;

    public UserInfoResponseDto(boolean checkedresult) {
        this.result = checkedresult;
    }
}

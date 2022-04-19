package com.example.clonecoding.controller;

import com.example.clonecoding.dto.*;
import com.example.clonecoding.model.User;
import com.example.clonecoding.security.UserDetailsImpl;
import com.example.clonecoding.security.jwt.JwtTokenUtils;
import com.example.clonecoding.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/user/signup")
    public void registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
    }

    // 로그인 확인
    @PostMapping("/user/login")
    public UserInfoResponseDto userLogin(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        Map<String, String> result = new HashMap<>();
        String token = JwtTokenUtils.generateJwtToken(userDetails);
//        System.out.println("email : " + user.getEmail());
//        System.out.println("nickname : " + user.getNickname());
        new UserResponseDto(user.getEmail(), user.getNickname());
        result.put("token", token);
        result.put("result", "success");
        return new UserInfoResponseDto(true);
    }

    // 아이디 중복확인
    @GetMapping("/user/idCheck/{username}")
    public ResultResponseDto duplicateUsername(@PathVariable("username") String username) {
        System.out.println("idCheck input username : " + username);
        System.out.println("idCheck result : " + userService.duplicateUsername(username).isResult());
        System.out.println("idCheck result reverse : " + userService.duplicateUsername(username));
        return userService.duplicateUsername(username);
    }

    // 닉네임 중복확인
    @GetMapping("/user/nicknameCheck/{nickname}")
    public ResultResponseDto duplicateNickname(@PathVariable("nickname") String nickname) {
        System.out.println("nicknameCheck input nickname : " + nickname);
        System.out.println("nicknameCheck result : " + userService.duplicatecNickname(nickname).isResult());
        return userService.duplicatecNickname(nickname);
    }

    // 회원정보 수정
    @PutMapping("/user/update/{id}")
    public UserInfoResponseDto editUserInfo(@PathVariable Long id, @RequestBody UserInfoRequestDto userInfoRequestDto
                                            ){
        log.info("nickname :{}", userInfoRequestDto.getNickname());

        userService.updateUserInfo(id, userInfoRequestDto);
        return new UserInfoResponseDto(true);
    }
    // 비밀번호 찾기


}




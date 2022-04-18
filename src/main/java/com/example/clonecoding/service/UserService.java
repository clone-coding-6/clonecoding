package com.example.clonecoding.service;

import com.example.clonecoding.dto.ResultResponseDto;
import com.example.clonecoding.dto.SignupRequestDto;
import com.example.clonecoding.model.User;
import com.example.clonecoding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(SignupRequestDto requestDto) {

        String username = requestDto.getEmail();
        String nickname = requestDto.getNickname();
        String imageUrl = requestDto.getImageUrl();

        // 패스워드
        String enPassword = passwordEncoder.encode(requestDto.getPassword());
        User user = new User(username,nickname,enPassword,imageUrl);
        userRepository.save(user); // DB 저장

    }

    // 아이디 중복확인
    public ResultResponseDto duplicateUsername(String username) {
        return new ResultResponseDto(userRepository.existsByEmail(username));
    }
    // 닉네임 중복확인
    public ResultResponseDto duplicatecNickname(String nickname) {
        return new ResultResponseDto(userRepository.existsByNickname(nickname));
    }
}

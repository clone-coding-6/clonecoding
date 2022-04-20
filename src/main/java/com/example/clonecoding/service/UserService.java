package com.example.clonecoding.service;

import com.example.clonecoding.dto.ResultResponseDto;
import com.example.clonecoding.dto.SignupRequestDto;
import com.example.clonecoding.dto.UserInfoRequestDto;
import com.example.clonecoding.model.User;
import com.example.clonecoding.repository.UserRepository;
import com.example.clonecoding.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //회원등 록
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

    //회원 정보 수정
    @Transactional
    public void updateUserInfo(Long id, UserInfoRequestDto userInfoRequestDto){
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("회원 id 를 찾을 수 없습니다")
        );

        user.updateUser(userInfoRequestDto);
    }
    //전체 회원정보 리스트 불러오기
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    // 내 정보 불러오기
    public List<User> getuser(UserDetailsImpl userDetails) {
        return userRepository.findByNickname(userDetails.getNickname());
    }
}

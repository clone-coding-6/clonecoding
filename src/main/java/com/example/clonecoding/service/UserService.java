package com.example.clonecoding.service;

import com.example.clonecoding.dto.SignUpRequestDto;
import com.example.clonecoding.dto.UserRequestDto;
import com.example.clonecoding.exception.ErrorCode;
import com.example.clonecoding.exception.HanghaeMiniException;
import com.example.clonecoding.model.User;
import com.example.clonecoding.model.UserRoleEnum;
import com.example.clonecoding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User registerUser(SignUpRequestDto requestDto) throws HanghaeMiniException {

        // 패스워드 암호화
        String pw = passwordEncoder.encode(requestDto.getPassword());

        //가입 email(id) 중복체크
        String userId = requestDto.getEmail();
//        Optional<User> found = userRepository.findByUserId(userId);
//        if (found.isPresent()){
//            throw new HanghaeMiniException(ErrorCode.EMAIL_DUPLICATE);
//        }


        //가입 nickname 중복체크
        String nickname = requestDto.getNickname();
//        Optional<User> found2 = userRepository.findByNickname(nickname);
//        if (found2.isPresent()) {
//            throw new HanghaeMiniException(ErrorCode.NICKNAME_DUPLICATE);
//        }

        //비밀번호확인
        String password = requestDto.getPassword();
        String passwordCheck = requestDto.getPasswordCheck();

//        if (!password.isEmpty() && !passwordCheck.isEmpty()) {
//            if (password.length() >= 6 && password.length() <= 20) {
//                if (!password.equals(passwordCheck)) {
//                    throw new HanghaeMiniException(ErrorCode.USER_NOT_FOUND);
//                }
//            } else {
//                throw new HanghaeMiniException(ErrorCode.PASSWORD_PATTERN_LENGTH);
//
//            }
//        } else {
//            throw new HanghaeMiniException(ErrorCode.PASSWORD_ENTER);
//        }



        //사용자 ROLE 확인
        UserRoleEnum role = UserRoleEnum.USER;
//        if (requestDto.isAdmin()) {
//            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
//                throw new HanghaeMiniException(ErrorCode.ADMIN_PASSWORD_DISCORDANCE);
//            }
//            role = UserRoleEnum.ADMIN;
//        }

        User user = new User(userId, pw, nickname, role);
        return userRepository.save(user);
    }

    public User login(UserRequestDto requestDto) throws HanghaeMiniException {
        User user = userRepository.findByEmail(requestDto.getUserId()).orElseThrow(
                () -> new HanghaeMiniException(ErrorCode.USER_NOT_FOUND)
        );

        // 패스워드 암호화
        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new HanghaeMiniException(ErrorCode.USER_NOT_FOUND);
        }

        return user;
    }

    // 로그인 중복 id
    public Map<String, String> duplicateId(UserRequestDto userRequestDto) {
        User user = userRepository.findByEmail(userRequestDto.getUserId()).orElse(null);

        Map<String, String> result = new HashMap<>();
        if (user == null) {
            result.put("result", "success");
            return result;
        }

        result.put("result", "fail");
        result.put("message", "중복된 id가 존재합니다.");
        return result;
    }

    //로그인 중복 닉네임
    public Map<String, String> duplicateNickname(SignUpRequestDto signUpRequestDto) {
        User user = userRepository.findByNickname(signUpRequestDto.getNickname()).orElse(null);
        Map<String, String> result = new HashMap<>();
        if (user == null) {
            result.put("result", "success");
            return result;
        }

        result.put("result", "fail");
        result.put("message", "중복된 닉네임이 있습니다.");
        return result;
    }
}




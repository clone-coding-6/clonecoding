package com.example.clonecoding.repository;

import com.example.clonecoding.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String userId);
    Optional<User> findByKakaoId(Long kakaoId);
    Optional<User> findByNickname(String nickname);
}

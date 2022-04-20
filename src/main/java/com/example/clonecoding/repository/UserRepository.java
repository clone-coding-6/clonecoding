package com.example.clonecoding.repository;

import com.example.clonecoding.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByEmail(String username);
    boolean existsByNickname(String nickname);
    Optional<User> findByEmail(String username);
    Optional<User> findById(Long id);
    List<User> findByNickname(String nickname);
}

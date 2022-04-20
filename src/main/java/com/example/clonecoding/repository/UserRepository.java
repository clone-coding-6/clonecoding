package com.example.clonecoding.repository;

import com.example.clonecoding.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> bb1b0a094289d09f80c703abec24d4e696d7aa4f
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByEmail(String username);
    boolean existsByNickname(String nickname);
    Optional<User> findByEmail(String username);
    Optional<User> findById(Long id);
<<<<<<< HEAD
=======
    List<User> findByNickname(String nickname);
>>>>>>> bb1b0a094289d09f80c703abec24d4e696d7aa4f
}

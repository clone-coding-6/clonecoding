package com.example.clonecoding.security;

import com.example.clonecoding.model.User;
import com.example.clonecoding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userId)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + userId));

        return new UserDetailsImpl(user);
    }
}

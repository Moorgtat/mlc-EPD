package com.mlc.portfolio.security.services;

import com.mlc.portfolio.entity.User;
import com.mlc.portfolio.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.UndeclaredThrowableException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = (User) userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
            return UserDetailsImpl.build(user);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}


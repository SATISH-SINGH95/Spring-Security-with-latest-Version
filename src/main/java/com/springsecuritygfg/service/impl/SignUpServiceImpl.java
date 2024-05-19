package com.springsecuritygfg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecuritygfg.constants.UserConstants;
import com.springsecuritygfg.model.User;
import com.springsecuritygfg.model.requestObject.UserRequestObject;
import com.springsecuritygfg.repository.UserRepository;
import com.springsecuritygfg.service.SignUpService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SignUpServiceImpl implements SignUpService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(UserRequestObject userRequestObject) {
        log.debug("createUser starts | userRequestObject : {}", userRequestObject);
        User user = new User();
        user.setAuthority(UserConstants.Authority.USER_AUTHORITY);
        user.setUsername(userRequestObject.getUsername());
        user.setPassword(passwordEncoder.encode(userRequestObject.getPassword()));
        user.setEmail(userRequestObject.getEmail());
        user.setPhoneNumber(userRequestObject.getPhoneNumber());
        User savedUser = userRepository.save(user);
        log.debug("createUser end | savedUser : {}", savedUser);
    }



}

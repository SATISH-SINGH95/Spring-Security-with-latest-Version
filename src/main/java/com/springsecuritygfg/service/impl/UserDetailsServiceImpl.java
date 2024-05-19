package com.springsecuritygfg.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecuritygfg.constants.UserConstants;
import com.springsecuritygfg.exception.EntityNotFoundException;
import com.springsecuritygfg.model.User;
import com.springsecuritygfg.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageSource messageSource;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("loadUserByUsername start | username = {}", username);
        User user = userRepository.findByUsername(username);
        if(user != null){
            return user;
        }
        log.debug("Exception : User not found");
        throw new EntityNotFoundException(HttpStatus.NOT_FOUND, messageSource.getMessage(UserConstants.MESSAGE_USER_NOT_FOUND, null, Locale.getDefault()));
    }

}

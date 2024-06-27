package com.springsecuritygfg.config;

import java.util.Locale;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.jaas.JaasAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.springsecuritygfg.constants.UserConstants;
import com.springsecuritygfg.exception.BadCredentialsException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AppAuthenticationProvider implements AuthenticationProvider{

    // Authentication Object - It will hold the details of username and password which has been provided by the user.

    private final UserDetailsService userDetailsService;

    private final MessageSource messageSource;

    private final PasswordEncoder passwordEncoder;

    public AppAuthenticationProvider(UserDetailsService userDetailsService, MessageSource messageSource,
            PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.messageSource = messageSource;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.debug("AppAuthenticationProvider | authenticate starts");
        String username = authentication.getName();
        log.debug("username : {}", username);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(Objects.nonNull(userDetails)){
            if(passwordEncoder.matches(authentication.getCredentials().toString(), userDetails.getPassword())){
                //authentication is successfully
                log.debug("Authentication Success");
                return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), passwordEncoder.encode(userDetails.getPassword()), userDetails.getAuthorities());
            }
        }
        throw new BadCredentialsException(HttpStatus.BAD_REQUEST, messageSource.getMessage(UserConstants.MESSAGE_INVALID_USERNAME_PASSWORD, null, Locale.getDefault()));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        if(UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication)){
            return true;
        }
        return JaasAuthenticationProvider.class.isAssignableFrom(authentication);
    }

}

package com.springsecuritygfg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
            .csrf(c -> c.ignoringRequestMatchers("/signup/**"))
            .authorizeHttpRequests(auth ->
                auth
                    .requestMatchers("/admin/**").hasAuthority("ADMIN")
                    .requestMatchers("/user/**").hasAuthority("USER")
                    .requestMatchers("/public/**").permitAll()
                    .requestMatchers("/signup/**").permitAll()
                    .anyRequest().authenticated()
            ).oauth2Login(Customizer.withDefaults()).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
            /*
            This both httpBasic and formLogin are done because when we use browser then form will be open but
             when we use postman the we can select basic authentication and pass username and password.
             */

        return httpSecurity.build();
    }
}

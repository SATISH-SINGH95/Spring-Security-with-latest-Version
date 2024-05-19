package com.springsecuritygfg.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/greet/{username}")
    public ResponseEntity<String> greetAdmin(@PathVariable String username){
        return ResponseEntity.ok().body("Welcome admin "+username);
    }

}

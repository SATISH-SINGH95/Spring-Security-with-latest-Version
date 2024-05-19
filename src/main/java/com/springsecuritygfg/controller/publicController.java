package com.springsecuritygfg.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class publicController {

    @GetMapping("/greet/{username}")
    public ResponseEntity<String> greetAdmin(@PathVariable String username){
        return ResponseEntity.ok().body("Welcome public "+username);
    }

    @GetMapping("/home/dashboard")
    public ResponseEntity<String> dashboard(){
        return ResponseEntity.ok().body("You are redirected to home page!!!!");
    }


}

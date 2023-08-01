package com.learnwithankit.springbootsecurityankit.springsecurity.controller;

import com.learnwithankit.springbootsecurityankit.springsecurity.entity.UserInfo;
import com.learnwithankit.springbootsecurityankit.springsecurity.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    @Autowired
    UserInfoRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome";
    }

    //secure, only admin http://localhost:8080/api/v1/admin
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String getMessageAdmin(){
        return "Secure Login for ADMIN";
    }

    //secure, user http://localhost:8080/api/v1/user
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/user")
    public String getMessageUser(){
        return "Secure Login for USER";
    }

    @PostMapping("/adduser")
    public void addUser(@RequestBody UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        System.out.println("user added");
    }

    @GetMapping("/oauth2")
    public String oauth(){
        return "User authenticated via OAuth from github";
    }
}

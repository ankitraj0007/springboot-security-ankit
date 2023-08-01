package com.learnwithankit.springbootsecurityankit.oauth2.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class MessageControllerOAuth2 {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome without OAuth2";
    }

    @GetMapping("/oauth2")
    public String oauth(){
        return "User authenticated via OAuth2";
    }
}

package com.learnwithankit.springbootsecurityankit.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityOAuth2 {

    @Bean
    public SecurityFilterChain securityFilterChainOAuth2(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth ->{
                    auth.requestMatchers("/api/v2/welcome").permitAll();
                    auth.requestMatchers("/api/v2/**").authenticated();
                        })
                .oauth2Login(Customizer.withDefaults()) // github or google oauth2 login
                .formLogin(Customizer.withDefaults()) //spring provided form login
                .build();
    }
}

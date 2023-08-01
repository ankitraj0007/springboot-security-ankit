package com.learnwithankit.springbootsecurityankit.springsecurity.repository;

import com.learnwithankit.springbootsecurityankit.springsecurity.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    public Optional<UserInfo> findByName(String name);
}

package com.lib.main.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.lib.main.dto.UserRegistrationDto;
import com.lib.main.entity.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}

package com.wissen.authservice.login;

import com.wissen.authservice.appuser.AppUser;
import com.wissen.authservice.appuser.AppUserService;
import com.wissen.authservice.login.dto.LoginRequest;
import com.wissen.authservice.login.dto.LoginResponse;
import com.wissen.authservice.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return new LoginResponse(loginService.login(loginRequest));
    }
}
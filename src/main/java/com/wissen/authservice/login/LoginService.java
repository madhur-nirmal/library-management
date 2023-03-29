package com.wissen.authservice.login;

import com.wissen.authservice.appuser.AppUser;
import com.wissen.authservice.appuser.AppUserService;
import com.wissen.authservice.login.dto.LoginRequest;
import com.wissen.authservice.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AppUserService appUserService;
    public String login(LoginRequest loginRequest) throws BadCredentialsException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException bce) {
            throw new BadCredentialsException("Incorrect username or password", bce);
        }

        final AppUser appUser = (AppUser) appUserService.loadUserByUsername(loginRequest.getUsername());
        return jwtUtility.generateToken(appUser);
    }
}

package com.wissen.authservice.registration;

import com.wissen.authservice.appuser.AppUser;
import com.wissen.authservice.appuser.AppUserRole;
import com.wissen.authservice.appuser.AppUserService;
import com.wissen.authservice.utility.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public ResponseEntity<String> register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            return ResponseEntity
                    .status(400)
                    .body("email not valid");
        }
        try{
            appUserService.signUpUser(new AppUser(
                    request.getEmail(),
                    request.getPassword(),
                    request.getName(),
                    request.getPhone(),
                    AppUserRole.USER
            ));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
        return ResponseEntity.ok("User registered successfully");
    }
}

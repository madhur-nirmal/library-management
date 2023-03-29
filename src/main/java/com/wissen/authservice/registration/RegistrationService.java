package com.wissen.authservice.registration;

import com.wissen.authservice.appuser.AppUser;
import com.wissen.authservice.appuser.AppUserRole;
import com.wissen.authservice.appuser.AppUserService;
import com.wissen.authservice.utility.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return appUserService.signUpUser(new AppUser(
                request.getEmail(),
                request.getPassword(),
                request.getName(),
                request.getPhone(),
                AppUserRole.USER
        ));
    }
}

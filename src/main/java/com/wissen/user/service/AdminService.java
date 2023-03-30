package com.wissen.user.service;

import com.wissen.user.entity.AppUserRole;
import com.wissen.user.entity.User;
import com.wissen.user.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public void createLibrarian(User user) {
        if(Objects.nonNull(user.getEmail()) &&
                        Objects.nonNull(user.getPassword()) &&
                        Objects.nonNull(user.getName()) &&
                        Objects.nonNull(user.getPhone())) {
            user.setROLE(AppUserRole.LIBRARIAN);
            adminRepository.save(user);
        } else {
            throw new RuntimeException("Invalid user details");
        }
    }

    public void deleteLibrarian(Long id) {
        adminRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        List<User> users = adminRepository.findAll();
        return users.
                stream()
                .filter(user -> user.getROLE().equals(AppUserRole.LIBRARIAN) || user.getROLE().equals(AppUserRole.USER))
                .peek(user -> user.setPassword(null))
                .collect(Collectors.toList());
    }

    public List<User> getAllLibrarians() {
        List<User> users = adminRepository.findAll();
        return users.
                stream()
                .filter(user -> user.getROLE().equals(AppUserRole.LIBRARIAN))
                .peek(user -> user.setPassword(null))
                .collect(Collectors.toList());
    }

    public void updateLibrarian(User user) {
        adminRepository.getReferenceById(user.getId()).setName(user.getName());
    }
}

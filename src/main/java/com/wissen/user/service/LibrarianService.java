package com.wissen.user.service;

import com.wissen.user.entity.AppUserRole;
import com.wissen.user.entity.User;
import com.wissen.user.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;

    public List<User> getAllCustomers() {
        List<User> customers = librarianRepository.findAll();
        return customers
                .stream()
                .filter(user -> user.getROLE().equals(AppUserRole.USER))
                .peek(user -> user.setPassword(null))
                .collect(Collectors.toList());
    }
}

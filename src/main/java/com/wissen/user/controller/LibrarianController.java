package com.wissen.user.controller;

import com.wissen.user.entity.User;
import com.wissen.user.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;

    @GetMapping("/getAllCustomers")
    public List<User> getAllCustomer() {
        return librarianService.getAllCustomers();
    }
}

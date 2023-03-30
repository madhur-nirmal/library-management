package com.wissen.user.controller;

import com.wissen.user.entity.User;
import com.wissen.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/createLibrarian")
    public ResponseEntity<String> createLibrarian(@RequestBody User user) {
        try {
            adminService.createLibrarian(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Librarian created");
    }

    @DeleteMapping("/deleteLibrarian/{id}")
    public ResponseEntity<String> deleteLibrarian(@PathVariable String id) {
        try {
            adminService.deleteLibrarian(Long.parseLong(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Librarian deleted");
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return ResponseEntity.ok(adminService.getAllUsers());
        } catch (RuntimeException e) {
            throw new RuntimeException("Error while getting all users");
        }
    }

    @GetMapping("/getAllLibrarians")
    public ResponseEntity<List<User>> getAllLibrarians() {
        try {
            return ResponseEntity.ok(adminService.getAllLibrarians());
        } catch (RuntimeException e) {
            throw new RuntimeException("Error while getting all librarians");
        }
    }

    @PutMapping("/updateLibrarian")
    public ResponseEntity<String> updateLibrarian(@RequestBody User user) {
        try {
            adminService.updateLibrarian(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("User updated");
    }
}

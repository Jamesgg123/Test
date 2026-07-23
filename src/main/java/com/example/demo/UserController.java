package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    @GetMapping("/api/users/{id}")
    public User getUser(@PathVariable("id") String userId) {
        return userService.getUserDetail(userId);
    }
    
}

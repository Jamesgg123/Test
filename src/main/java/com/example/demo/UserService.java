package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserDetail(String userId){
        String formattedId = userId.trim().toUpperCase();
        User user = userRepository.findById(formattedId);
        return user;
    }
}

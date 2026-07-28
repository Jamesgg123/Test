package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserDetail(String userId){
        String formattedId = userId.trim().toUpperCase();
        User user = userRepository.findById(formattedId).orElse(null);
        return user;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository.findById(id).orElse(null);
    }
    public void deleteUserById(String id){
        userRepository.deleteById(id);
    }
    
}

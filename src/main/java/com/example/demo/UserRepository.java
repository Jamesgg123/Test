package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private static final Map<String, User>userDatabase = new HashMap<>();

    static{
        userDatabase.put("U001",new User("U001", "Ming", "Ming@e.com"));
        userDatabase.put("U002",new User("U002", "Lee", "Lee@e.com"));
        userDatabase.put("U003",new User("U003", "Wang", "Wang@e.com"));
    }
    public User findById(String id){
        return userDatabase.get(id);
    }
}

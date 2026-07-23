package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
    @GetMapping("/api/hello")
    public String sayhello(
        @RequestParam(value = "name" , defaultValue = "World")
        String name
    ){
        return String.format("HI,%s! WELCOME",name);
    
    }
    @GetMapping("/api/user/{id}/profile")
    public String getUserProfile(
        @PathVariable("id") String userID
    ){
        return "searching userID :" + userID + " Document detail...";
    }
    @GetMapping("/api/bmi")
    public String getBmi(@RequestParam("height") double height ,@RequestParam("weight") double weight) {
        double h;
        double aws ;
        h= height/100.0;
        aws = weight/(h*h);

        return String.format("Bmi: %.2f ",aws );
    }
    
    
    
}

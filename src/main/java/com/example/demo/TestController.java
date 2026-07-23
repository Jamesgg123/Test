package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TestController {
    @GetMapping("/api/bmitest")
    public String bmi(@RequestParam("weight") double weight,
    @RequestParam("height") double heightM ) {
        double heightCm = heightM /100.0;
        double bmi = weight/(heightCm*heightCm);
        double bmiRounded = Math.round(bmi/100.0)*100.0;
        return String.format("bmi:%0.2f ", bmiRounded);
    }
    
    
}

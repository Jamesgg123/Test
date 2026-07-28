package com.example.demo.controller;
import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    @GetMapping("/welcome")
    
    public String welcomePage(Model model){
        model.addAttribute("title" , "welcome to here");
        model.addAttribute("message","welcome to DAY_4");
        model.addAttribute("currentTime", java.time.LocalDateTime.now().toString());
        return "welcome";
    }

    @GetMapping("user/form")
    public String showForm(Model model) {
        model.addAttribute("user" , new User());
        return "user-form";
    }

    @PostMapping("/user/save")
    public String saveUser(
        @ModelAttribute("user") User user,  
        Model model
    ) {
        model.addAttribute("savedUser", user);
        return "user-result";  
    }

}

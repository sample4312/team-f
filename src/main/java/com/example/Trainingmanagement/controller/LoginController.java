package com.example.Trainingmanagement.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

//import com.example.Trainingmanagement.form.UserForm;

//import jakarta.validation.Valid;
@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}

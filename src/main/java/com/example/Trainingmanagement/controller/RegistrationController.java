package com.example.Trainingmanagement.controller;

import com.example.Trainingmanagement.form.UserForm;
import com.example.Trainingmanagement.service.UserService;

import jakarta.validation.Valid;

//import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class RegistrationController {
    private final UserService userService;
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@Valid UserForm userForm, BindingResult result) {
        
        if(result.hasErrors()){
            return "register";
        }else{
            userService.createUser(userForm);
            return "redirect:login?register";
        }
        
        
    } 

}

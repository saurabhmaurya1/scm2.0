package com.scm.controllers;


import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



import com.scm.services.UserService;

import lombok.RequiredArgsConstructor;






@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    
    private final UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);


    


    //user dashboard page
    @RequestMapping(value="/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }
    
    //profile
    @RequestMapping(value="/profile")
    public String requestMethodName(Model model ,Authentication authentication) {
        
        return "user/profile";
    }
    
    //add contact page 
    //view contact page
    //user edit contact

}

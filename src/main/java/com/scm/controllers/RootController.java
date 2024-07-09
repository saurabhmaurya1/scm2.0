package com.scm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.scm.entities.User;
import com.scm.helpers.Helper;
import com.scm.services.UserService;

import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class RootController {

    private final UserService userService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //giving logged in user detail to every page
    @ModelAttribute
    public void addLoggedInUserInformation(Model model, Authentication authentication){
        if(authentication==null){
            return;
        }
        String userName = Helper.getEmailOfLoggedInUser(authentication);
        logger.info("User logged in : {}",userName);
        User user = userService.getUserByEmail(userName);
        
        System.out.println(user);

            System.out.println(user.getName());
        System.out.println(user.getEmail());
        model.addAttribute("loggedInUser", user);
        
        
    }

}

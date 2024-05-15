package com.scm.controllers;

import com.scm.entities.User;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class PageController {

    private final UserService userService;



    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name","substring Technologies");
        model.addAttribute("YoutubeChannel", "Saurabh");
        model.addAttribute("githubRepo", "https://github.com/saurabhmaurya1");



        System.out.println("home page handler");
        
        return "home";
    }

    // about route
    @RequestMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("value1", "hehehe");
        System.out.println("About page is loading");
        return "about";
    }
    



    // services Route

    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("service page is loading");
        return "services";
    }
    
    //contact route
    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }
    

    //login route 
    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    //signup route
    @RequestMapping("/register")
    public String register(Model model) {

        //passing default data
        UserForm userForm = new UserForm();
        // userForm.setName("Saurabh");
        // userForm.setEmail("saurabh@gamil.com");
        // userForm.setPassword("34567yg");
        // userForm.setPhoneNumber("7512255");
        // userForm.setAbout("what  we have to fill");
        model.addAttribute("userForm", userForm);

        return "register";
    }

    //process Register

    @PostMapping("/do-register")
    public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult, HttpSession session){

        System.out.println("my name is saurabh");
        System.out.println(userForm);

        //fetch form data 
        //validate form data 
        if(rBindingResult.hasErrors()){
            return "register";
        }


        //save to database

        // builder comment kiya hai kyuki ye default value provider ki nahi update kar raha tha
        // User user = User.builder()
        //         .name(userForm.getName())
        //         .email(userForm.getEmail())
        //         .password(userForm.getPassword())
        //         .phoneNumber(userForm.getPhoneNumber())
        //         .about(userForm.getAbout())
        //         .profilePic("https://t4.ftcdn.net/jpg/04/10/43/77/360_F_410437733_hdq4Q3QOH9uwh0mcqAhRFzOKfrCR24Ta.jpg")
        //         .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setAbout(userForm.getAbout());
        user.setProfilePic("https://t4.ftcdn.net/jpg/04/10/43/77/360_F_410437733_hdq4Q3QOH9uwh0mcqAhRFzOKfrCR24Ta.jpg");

        User savedUser = userService.saveUser(user);
        System.out.println("user saved :");

        //message registration successful
        Message message = Message.builder()
        .content("Registration Successful")
        .type(MessageType.red).build();

        session.setAttribute("message", message);
        //redirect to login page

        return "redirect:/register";
    }



}

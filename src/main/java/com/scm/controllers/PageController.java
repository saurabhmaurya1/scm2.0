package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class PageController {

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
    


}

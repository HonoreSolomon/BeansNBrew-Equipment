package com.beansNbrew.app.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 *
 *
 *
 */

@Controller
public class AboutController {
    @GetMapping("/about")
    public String showAboutPage(Model theModel) {
        return "about";
    }

}

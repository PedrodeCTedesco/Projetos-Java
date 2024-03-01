package org.taco.tacosHomePage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController
{
    //handles GET request
    @GetMapping("/")
    public String showHomePage()
    {
        return "home";
    }
}

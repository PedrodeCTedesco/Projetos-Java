/** This is the controller class to handle requests to the browser. The controller class handles
 * requests and responds with information of some sort. The controller is a concept
 * at the center of the Spring MVC.
 *
 * @author pedro de castro tedesco
 * @since 15/02/2024
 * @see Spring and SpringBoot in Action (Craig Walls, 2021)
 * */

package com.hermanas.landingPage.homepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ControllerAdvice
@RequestMapping("/")
//of HomePageController as a bean
public class HomePageController
{
    //Handles HTTP GET to "/"
    @GetMapping
    public String home()
    {
        return "home";
    };//end of home()
};//end of HomePageController

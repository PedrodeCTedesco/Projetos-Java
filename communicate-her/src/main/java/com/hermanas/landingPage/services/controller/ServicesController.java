/** This is the controller for the HTTP requests for the services.
 * @author pedro de castro tedesco
 * @since 16/02/2024
 * @see "Spring and Spring Boot in Action" (Craig Walls chapter 2)
 * */

package com.hermanas.landingPage.services.controller;

//Lombok
import lombok.extern.slf4j.Slf4j;
//Spring framework
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//Project imports
import com.hermanas.landingPage.services.ClientRequestedServices;
import com.hermanas.landingPage.services.CommunicationServices;
import com.hermanas.landingPage.services.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ControllerAdvice
@SessionAttributes("servicesRequested")
@Slf4j
@RequestMapping("/services")
public class ServicesController
{
    //Fields
    //private static final Logger logger = LoggerFactory.getLogger(ServicesController.class);


    //Handle the HTTP GET request
    @GetMapping
    public String showServicePage()
    {
        return "services";
    };//end of showServicePage();

    //Model section
    @ModelAttribute(value = "servicesRequestedByClient")
    public ClientRequestedServices servicesRequestedByClient()
    {
        return new ClientRequestedServices();
    };

    /** When the controller class is invoked, Spring MVC will call addServicesToModel(Model)
     * to populate model with attributes related to services offered (the instances of CommunicationServices).
     * These attributes will be stored under the name 'servicesOffered'. So we can access this values
     * in a Thymeleaf template using the key: servicesOffered.
     * If no value provided the name of the class is used by default.
     * */
    @ModelAttribute(value = "servicesOffered")
    public void addServicesToModel(Model model)
    {
        //Create a Map
        Map<String, CommunicationServices> map = new HashMap<>();

        //Create two services
        CommunicationServices strategicPlanning = new CommunicationServices(
                "Planejamento estratégico",
                "S-PE",
                CommunicationServices.Type.MKTDIGITAL);

        CommunicationServices sites = new CommunicationServices(
                "Sites",
                "S-S",
                CommunicationServices.Type.SITE);

        map.put("strategic planning", strategicPlanning);
        map.put("sites", sites);

        model.addAttribute("servicesOffered", map);
    };//end of addServicesToModel(Model model);

    @ModelAttribute(value = "servicesClass")
    public Services createServiceInstance()
    {
        return new Services();
    };

    @ModelAttribute(value = "communicationServices")
    public CommunicationServices createCommunicationServicesInstance()
    {
        return new CommunicationServices();
    };
};//end of ServicesController

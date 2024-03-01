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
    @ModelAttribute(name = "servicesRequestedByClient")
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

        //Create fixed services
        CommunicationServices strategicPlanning = new CommunicationServices(
                "Planejamento estratégico",
                "S-PE",
                CommunicationServices.Type.FIXED);

        CommunicationServices contentManagement = new CommunicationServices(
                "Gestão de conteúdo",
                "S-GR",
                CommunicationServices.Type.FIXED);

        CommunicationServices paidTraffic = new CommunicationServices(
                "Tráfego pago",
                "S-TP",
                CommunicationServices.Type.FIXED);

        //Create variable services
        CommunicationServices sites = new CommunicationServices(
                "Sites",
                "S-S",
                CommunicationServices.Type.VARIABLE);

        CommunicationServices personalMarketing = new CommunicationServices(
                "Marketing de influência",
                "S-MKTINF",
                CommunicationServices.Type.VARIABLE);

        CommunicationServices video = new CommunicationServices(
                "Edição de vídeo",
                "S-EDVIDEO",
                CommunicationServices.Type.VARIABLE);

        map.put("strategic planning", strategicPlanning);
        map.put("content management", contentManagement);
        map.put("paid traffic", paidTraffic);
        map.put("sites", sites);
        map.put("personal marketing", personalMarketing);
        map.put("video", video);

        model.addAttribute("servicesOffered", map);
    };//end of addServicesToModel(Model model);

    //Handles POST requests
    @PostMapping
    public String handlesFormService(ClientRequestedServices clientRequestedServices)
    {
        return "";
    }
};//end of ServicesController

/** This is the controller for the HTTP requests for the services.
 * @author pedro de castro tedesco
 * @since 16/02/2024
 * @see "Spring and Spring Boot in Action" (Craig Walls chapter 2)
 * */

package services.web;

//Spring framework
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.ClientRequestedServices;
import services.CommunicationServices;
import services.Services;

@Controller
@ControllerAdvice
@SessionAttributes("servicesRequested")
@Slf4j
@RequestMapping("/services") //All HTTP GET method wil lbe handle by this class
public class ServicesController
{
    //Handle the HTTP GET request
    @GetMapping//for specific use (get some specific resource inside the template). Now there is none.
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
        //Create two services
        CommunicationServices strategicPlanning = new CommunicationServices(
                "Planejamento estratégico",
                "S-PE",
                CommunicationServices.Type.MKTDIGITAL);

        CommunicationServices sites = new CommunicationServices(
                "Sites",
                "S-S",
                CommunicationServices.Type.SITE);

        //Add attributes to model object
        model.addAttribute("S-PE", strategicPlanning);
        model.addAttribute("S-S", sites);
    };//end of addServicesToModel(Model model);

    @ModelAttribute(value = "services")
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

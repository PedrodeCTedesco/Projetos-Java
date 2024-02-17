/** This is the controller for the HTTP requests for the services.
 * @author pedro de castro tedesco
 * @since 16/02/2024
 * @see "Spring and Spring Boot in Action" (Craig Walls chapter 2)
 * */

package services.web;

//Project imports

//Lombok
import lombok.extern.slf4j.Slf4j;
//Spring framework
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

import services.CommunicationServices;
import services.CommunicationServices.Type;
import services.Services;
import services.ClientRequestedServices;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/service")
@SessionAttributes("serviceOrder")
public class ServicesController
{
    @ModelAttribute //this method is used to render a list of services for digital marketing (hard-coded;
    //this could be in a database). The method will be rendered when a GET request came
    public void addServicesToModel (Model model)
    {
        List<CommunicationServices> communicationServicesList = Arrays.asList(
            new CommunicationServices("Planejamento estratégico", "PLANEST",
                    CommunicationServices.Type.MKTDIGITAL),
            new CommunicationServices("Marketing de conteúdo", "MKTCONT",
                    CommunicationServices.Type.MKTDIGITAL),
            new CommunicationServices("Marketing de influência", "MKTINFLU",
                    CommunicationServices.Type.MKTDIGITAL),
            new CommunicationServices("Gestão de redes sociais", "REDES",
                    CommunicationServices.Type.MKTDIGITAL),
            new CommunicationServices("Tráfego pago", "TRAF",
                    CommunicationServices.Type.MKTDIGITAL),
            new CommunicationServices("Naming", "NAMIG",
                    CommunicationServices.Type.MKTDIGITAL),
            new CommunicationServices("Branding", "BRD",
                    CommunicationServices.Type.MKTDIGITAL),
            new CommunicationServices("Sites", "STE",
                    CommunicationServices.Type.SITE),
            new CommunicationServices("Roteiros", "RTO",
                    CommunicationServices.Type.MKTDIGITAL),
            new CommunicationServices("Tradução inglês/português", "TRAD",
                        CommunicationServices.Type.MKTDIGITAL),
            new CommunicationServices("Produção gráfica, eletrônica e executiva",
                    "PRODGRAF", CommunicationServices.Type.MKTDIGITAL),
            new CommunicationServices("Edição de vídeo", "EDVIDEO",
                    CommunicationServices.Type.MKTDIGITAL)
        );

        Type[] types = CommunicationServices.Type.values(); //get the values of CommunicationServices.Type

        //Add the services to the Model object that wil lbe passed to showServicesForm()
        for (Type type : types)
        {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(communicationServicesList, type));
        };//end of enhanced for
    }//end of addServicesToModel(Model model)

    @ModelAttribute(name = "serviceOrder") //the same value of @SessionAttributes
    public CommunicationServices communicationServices()
    {
        return new CommunicationServices();
    };//end of communicationServices();

    @ModelAttribute(name = "services") //the object will be placed into the model object
    public Services services()
    {
        return new Services();
    };//end of services();

    @GetMapping //Used with @RequestMapping to invoke showServicesForm() when a GET request came for "/service".
    public String showServicesForm()
    {
        return "service";
    };//end of showServicesForm();

    //Implementation methods
    //The filterByType() is a helper method
    private Iterable<CommunicationServices> filterByType(
            List<CommunicationServices> communicationServices, Type type)
    {
        return communicationServices
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    };//end of filterByType(...)
};//end of ServicesController

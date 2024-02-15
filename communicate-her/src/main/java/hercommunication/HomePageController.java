/** This is the controller class to handle requests to the browser.
 * @author pedro de castro tedesco
 * @since 15/02/2024
 * @see Spring and SpringBoot in Action (Craig Walls, 2021)
 * */

package hercommunication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //that annotation aloud the Spring component scanning to discover it and creates an instance
//of HomePageController as a bean
public class HomePageController
{
    @GetMapping("/") //handles requests for the root path (/). If an HTTP GET request is received
    //for the root path then this method (home()) should handle that request.
    public String home()
    {
        return "home"; //returns the view name
    };//end of home()

    /** The template name is derived from the logical view name created with home() by prefixing it
     * with "/templates" and postfix it with ".html". So the result is: templates/home.html. To create
     * the template we will use Thymeleaf.
     * Now we should add this template in src/main/resources/templates/home.html.
     * */
};//end of HomePageController

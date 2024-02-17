/** The request made by the client for a companies service.
 * @author pedro de castro tedesco
 * @since 16/02/2024
 * @see "Spring and Spring Boot in Action" (Craig Walls, chapter 2)
 * */

package services;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientRequestedServices
{
    //Fields
    private final String clientName; //name of the client
    private final String clientCompanyName; // company's name
    private final String clientPhone; //number of contact
    private final String clientCity; //city of residence;
    private final String clientBusinessArea; //business area of the client's company
    private List<Services> services = new ArrayList<>(); //the number of services requested;

    //Client methods
    public void addService(Services service)
    {
        services.add(service);
    };//end of AddService(Services service);
};//end of ClientRequestedServices

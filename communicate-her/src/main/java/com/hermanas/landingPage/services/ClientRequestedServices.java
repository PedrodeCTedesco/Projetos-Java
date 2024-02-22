/** The request made by the client for a companies service.
 * @author pedro de castro tedesco
 * @since 16/02/2024
 * @see "Spring and Spring Boot in Action" (Craig Walls, chapter 2)
 * */

package com.hermanas.landingPage.services;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientRequestedServices
{
    //Fields
    private String clientName; //name of the client
    private String clientCompanyName; // company's name
    private String clientPhone; //number of contact
    private String clientCity; //city of residence;
    private String clientBusinessArea; //business area of the client's company
    private List<Services> services = new ArrayList<>(); //the number of services requested;

    //Constructor
    public ClientRequestedServices(final String clientName, final String clientCompanyName, final String clientPhone,
                                   final String clientCity, final String clientBusinessArea, final List<Services> services)
    {
        //Check arg values
        if (clientName == null || clientName.isEmpty())
            throw new IllegalArgumentException("Client name cannot be empty or null");

        if (clientCompanyName == null || clientCompanyName.isEmpty())
            throw new IllegalArgumentException("Client company name cannot be empty or null");

        if (clientPhone == null || clientPhone.isEmpty())
            throw new IllegalArgumentException("Client phone cannot be empty or null");

        if (clientCity == null || clientCity.isEmpty())
            throw new IllegalArgumentException("Client city cannot be empty or null");

        if (clientBusinessArea == null || clientBusinessArea.isEmpty())
            throw new IllegalArgumentException("Client business area cannot be empty or null");

        if (services == null || services.isEmpty())
            throw new IllegalArgumentException("You must order at least one service");

        this.clientName = clientName;
        this.clientCompanyName = clientCompanyName;
        this.clientPhone = clientPhone;
        this.clientCity = clientCity;
        this.clientBusinessArea = clientBusinessArea;
        this.services = services;
    };//end of 6 arg constructor

    public ClientRequestedServices(){};

    //Client methods
    public void addService(Services service)
    {
        services.add(service);
    };//end of AddService(Services service);
};//end of ClientRequestedServices

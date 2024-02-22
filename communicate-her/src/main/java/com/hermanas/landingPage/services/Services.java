/** The services design
 * @author pedro de castro tedesco
 * @since 16/02/2024
 * @see "Spring and Spring Boot in Action" (Craig Walls, chapter 2)
 * */

package com.hermanas.landingPage.services;

//Lombok
import lombok.Data;
//API Java
import java.time.LocalDate;
import java.util.List;

@Data
public class Services
{
    //Fields
    private List<CommunicationServices> servicesRequested; //list of services requested for the client

    private LocalDate serviceRequestedOn; //date of the request

    private String serviceName; //the name of the service

    //Constructors
    public Services(final List<CommunicationServices> servicesRequested, final LocalDate serviceRequestedOn,
                    final String serviceName)
    {
        //Create variable to check the date
        LocalDate currentDate = LocalDate.now();

        //Check the values of fields
        if (servicesRequested == null || servicesRequested.isEmpty())
            throw new IllegalArgumentException("serviceRequested cannot be null or empty");

        if (serviceRequestedOn.isAfter(currentDate))
            throw new IllegalArgumentException("Date of serviceRequestedOn cannot be in the future");

        if (serviceName == null || serviceName.isEmpty())
            throw new IllegalArgumentException("You must choose a service name");

        this.servicesRequested = servicesRequested;
        this.serviceRequestedOn = serviceRequestedOn;
        this.serviceName = serviceName;
    };//end of 3 arg constructor

    public Services(){};//end of no arg constructor
};//end of Services class

/** The services offered by the company.
 *
 * @author pedro de castro tedesco
 * @since 16/02/2024
 * @see "Spring and Spring Boot in Action" (Craig Wells, chapter 2)
 * */

package com.hermanas.landingPage.services;
//API Java
import java.util.Arrays;
import java.util.List;
//Lombok
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data //using Lombok library to make the code simple
public class CommunicationServices
{
    //Fields
    private String name; //service name
    private String id; //id of the service
    private Type type; //type of the service

    public CommunicationServices(final String name, final String id, final Type type)
    {
        //Check the value of arguments
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");

        if (id == null || id.isEmpty())
            throw new IllegalArgumentException("Id cannot be null of empty");

        checkTypeValue(type);

        this.name = name;
        this.id = id;
        this.type = type;
    };//end of 3 arg constructor

    public CommunicationServices() {};//end of no-args constructor

    //Enum type
    public enum Type
    {
        FIXED, VARIABLE;
    };//end of enum Type

    //Implementation methods
    private static void checkTypeValue(Type type)
    {
        boolean isValid = false;
        for (Type typo : Type.values())
        {
            if (typo == type)
            {
                isValid = true;
                break;
            }
        }
        if(!isValid)
            throw new IllegalArgumentException("Type must be: MKTDIGITAL or SITE");
    };//end of checkTypeValue(Type type)
};//end of CommunicationServices

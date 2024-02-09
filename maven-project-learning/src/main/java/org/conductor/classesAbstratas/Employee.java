/** This is the abstract class that we will use to learn about heritage and polymorphism
 * @author pedro de castro tedesco
 * @since 08/02/2024
 * @see Java: how to program, chapter 10 (Deitel and Deitel, 10ª ed)
 * */

package org.conductor.classesAbstratas;

public abstract class Employee
{
    //Fields
    //We use this fields to manipulate the subclasses correspondent fields
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    //Constructor
    public Employee(String firstName, String lastName, String socialSecurityNumber)
    {
        //check the value of firstName, lastName and SSN
        if(firstName.equalsIgnoreCase(""))
            throw new IllegalArgumentException("First name cannot be empty");

        //check the value of firstName
        if(lastName.equalsIgnoreCase(""))
            throw new IllegalArgumentException("Last name cannot be empty");

        //check the value of firstName
        if(socialSecurityNumber.equalsIgnoreCase(""))
            throw new IllegalArgumentException("Social security number cannot be empty");

        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    };//end of constructor

    //Query methods
    public String getFirstName()
    {
        return firstName;
    };//end of getFirstName();

    public String getLastName()
    {
        return lastName;
    };//end of getLastName();

    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    };//end of getSocialSecurityNumber();

    //Method's (concrete)
    @Override
    public String toString()
    {
        return String.format("%s %s%nsocial security number: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber());
    };//end of toString();

    //Method's (abstract)
    public abstract double earnings();
};//end of Employee abstract class

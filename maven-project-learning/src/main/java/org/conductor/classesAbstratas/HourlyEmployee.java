/** This is one of the four subclasses of Employee (abstract class).
 * @author pedro de castro tedesco
 * @since 08/02/2024
 * @see Java: How to program (Deitel and Deitel, 10ªed, chapter 10)
 * */

package org.conductor.classesAbstratas;

public class HourlyEmployee extends Employee
{
    //Fields
    private double wage; //salary per hour
    private double hours; //number of hours worked through the week

    //Constructor
    public HourlyEmployee(String firsName, String lastName, String socialSecurityNumber,
                          double wage, double hours)
    {
        //call the superclass constructor
        super(firsName, lastName, socialSecurityNumber);

        //check the values of wage
        if (wage < 0.0)
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");

        //check the values of hours
        if ((hours < 0.0) || (hours > 168.0))
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");

        this.wage = wage;
        this.hours = hours;
    };//end of constructor

    //Query methods
    public double getWage() {return wage;};//end of getWage();

    public double getHours() { return hours; };//end of getHours();

    //Configuration methods
    public void setWage(double wage)
    {
        if(wage < 0.0)
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");

        this.wage = wage;
    };//end of setWage(double wage);

    public void setHours(double hours)
    {
        if((hours < 0.0) || (hours > 168.0))
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");

        this.hours = hours;
    };//end of setHours(double hours);

    //Client methods
    @Override
    public double earnings()
    {
        //No extra hours
        if (getHours() <= 40)
            return getWage() * getHours();
        else
            return 40 * getWage() + (getHours() - 40) * (getWage() * 1.5);
    };//end of earnings();

    @Override
    public String toString()
    {
        return String.format("hourly employee: %s%n%s: $%,.2f; %s: $%,.2f",
                super.toString(), "hourly wage", getWage(), "hours worked", getHours());
    };//end of toString();
};//end of HourlyEmployee extends Employee

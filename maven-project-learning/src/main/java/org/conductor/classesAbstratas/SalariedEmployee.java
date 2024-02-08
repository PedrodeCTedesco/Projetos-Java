/** This is one of the four subclasses of Employee (abstract class).
 * @author pedro de castro tedesco
 * @since 08/02/2024
 * @see Java: How to program (Deitel and Deitel, 10ªed, chapter 10)
 * */

package org.conductor.classesAbstratas;

public class SalariedEmployee extends Employee
{
    //Fields
    private double weeklySalary;

    //Constructor
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary)
    {
        super(firstName, lastName, socialSecurityNumber);

        //Check if the value of weeklySalary is valid
        if (weeklySalary < 0.0)
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");

        this.weeklySalary = weeklySalary;
    };//end of constructor

    //Query methods
    public double getWeeklySalary()
    {
        return weeklySalary;
    }//end og getWeeklySalary();

    //Configuration methods
    public void setWeeklySalary(double weeklySalary)
    {
        //check the value of argument
        if(weeklySalary < 0.0)
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");

        this.weeklySalary = weeklySalary;
    };//end of setWeeklySalary(double weeklySalary);

    //Class methods
    @Override
    public double earnings()
    {
        return getWeeklySalary();
    };//end of earnings();

    @Override
    public String toString()
    {
        return String.format("salaried employee: %s%n%s: %.2f",
                super.toString(), "weekly salary", getWeeklySalary());
    };//end of toString()
};//end of SalariedEmployee

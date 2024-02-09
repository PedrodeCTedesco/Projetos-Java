/** This is one of the four subclasses of Employee (abstract class).
 * @author pedro de castro tedesco
 * @since 09/02/2024
 * @see Java: How to program (Deitel and Deitel, 10ªed, chapter 10)
 * */

package org.conductor.classesAbstratas;

//Note that BasePlusCommissionEmployee is an indirect subclass of Employee
public class BasePlusCommissionEmployee extends CommissionEmployee
{
    //Fields
    private double baseSalary; //base salary per week

    //Constructor
    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                      double grossSales, double commissionRate, double baseSalary)
    {
        //call to superclass constructor (CommissionEmployee)
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

        //check the value of base salary
        if(baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
    };//end of constructor

    //Query methods
    public double getBaseSalary()
    {
        return baseSalary;
    };//end of getBaseSalary();

    //Configuration methods
    public void setBaseSalary(double baseSalary)
    {
        //check the value of base salary
        if(baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        this.baseSalary = baseSalary;
    };//end of setBaseSalary(double baseSalary);

    //Since this class is an indirect subclass of Employee we can turn the abstract methods earnings to a concrete one
    //Client methods
    @Override
    public double earnings()
    {
        //calls the earnings() method of CommissionEmployee
        return getBaseSalary() + super.earnings();
    };//end of earnings();

    @Override
    public String toString()
    {
        return String.format("%s %s; %s: $%,.2f",
                "base salaried", super.toString(),
                "base salary", getBaseSalary());
    };//end of toString();
};//end of BasePlusCommissionEmployee extends CommissionEmployee

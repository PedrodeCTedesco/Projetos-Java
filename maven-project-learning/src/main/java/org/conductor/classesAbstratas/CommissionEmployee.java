/** This is one of the four subclasses of Employee (abstract class).
 * @author pedro de castro tedesco
 * @since 09/02/2024
 * @see Java: How to program (Deitel and Deitel, 10ªed, chapter 10)
 * */

package org.conductor.classesAbstratas;

public class CommissionEmployee extends Employee
{
    //Fields
    private double grossSales; //total of gross sales per week
    private double commissionRate; //commissions percentage

    //Constructor
    public CommissionEmployee (String firstName, String lastName, String socialSecurityNumber,
                               double grossSales, double commissionRate)
    {
        //call to superclass constructor
        super(firstName, lastName, socialSecurityNumber);

        //check de value of grossSales and commissionRate
        if(grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");

        if(commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    };//end of constructor

    //Query methods
    public double getCommissionRate()
    {
        return commissionRate;
    };//end of getCommissionRate();

    public double getGrossSales()
    {
        return grossSales;
    };//end of getGrossSales();

    //Configuration methods
    public void setCommissionRate(double commissionRate)
    {
        if(commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

        this.commissionRate = commissionRate;
    };//end of setCommissionRate(double commissionRate);

    public void setGrossSales(double grossSales)
    {
        if(grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");

        this.grossSales = grossSales;
    };//end of setGrossSales(double grossSales):

    //Client methods
    @Override
    public double earnings()
    {
        return getCommissionRate() * getGrossSales();
    };//end of earnings (abstract method)

    @Override
    public double paymentAmount()
    {
        return earnings();
    };//end of paymentAmount();

    @Override
    public String toString()
    {
        return String.format("%s: %s%n%s: $%,.2f; %s: $%.2f",
                "commission employee", super.toString(),
                "gross sales", getGrossSales(),
                "commission rate", getCommissionRate());
    };//end of toString();
};//end of CommissionEmployee extends Employee

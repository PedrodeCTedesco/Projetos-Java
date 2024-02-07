/** This class is a superclass used in the heritage example of "Java: how to program" (Deitel and Deitel, 10ª ed)
 * The class represents an employee that is paid with percentage of gross sales
 * @author pedro de castro tedesco
 * @link "Java: how to program" (Deitel & Deitel), cap. 9
 * @since 03/02/2024
 * @see "src/tesjava/org.conductor.herancaEpolimorfismo.commissionEmployeeBasePlus to Junit 5 tests
 * */

package org.conductor.heranca.commissionEmployee;

//Note that 'extends Object' its here for educational proposes only.
//Everytime that we create a class and doesn't specify its superclass Object becomes the superclass implicit
public class CommissionEmployee extends Object
{
    //Fields
    private final String firstName;
    private final String lastName;

    //wil lbe protected so subclasses can access this field without invoking query methods
    protected final String socialSecurityNumber;
    private double grossSales; //total sales per week
    private double commissionRate; //commission's percentage

    //Constructor

    public CommissionEmployee() {
        this(null, null, null, 0.0, 0.0);
    };

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate)
    {
        //The call of super() for Object occurs here implicitly

        //If grossSales value is invalid throws exception
        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");

        //If commissionRate value is invalid throws exception
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    };//end of 5 arguments constructor

    //Query methods
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }

    public double getCommissionRate()
    {
        return commissionRate;
    }

    public double getGrossSales() {return grossSales;};

    //Configuration methods
    public void setGrossSales(double grossSales)
    {
        if(grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be > 0.0");

        this.grossSales = grossSales;
    }

    public void setCommissionRate(double commissionRate)
    {
        if(commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

        this.commissionRate = commissionRate;
    }

    //Client methods

    //Return earnings
    public double earnings()
    {
        return getCommissionRate() * getGrossSales();
    }

    @Override //indicates that this method overrides the superclass method
    public String toString()
    {
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",
                "commission employee", getFirstName(), getLastName(),
                "social security number", getSocialSecurityNumber(), "gross sales", getGrossSales(),
                "commission rate", getCommissionRate());
    }

};//end of CommissionEmployee class

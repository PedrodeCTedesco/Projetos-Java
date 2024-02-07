/** This class it's a demonstration of how much work we would have if we didn't use heritage.
 * That BasePlusCommissionEmployee is very similar to CommissionEmployee, and that's a case
 * where heritage aloud us to reuse code.
 * @author pedro de castro tedesco
 * @since 04/02/2024
 * @see "Java: how to program" (Deitel and Deitel, 10º ed, chapter 9)
 * @see "src/tesjava/org.conductor.herancaEpolimorfismo.commissionEmployeeBasePlus to Junit 5 tests
 * t*/

package org.conductor.heranca.commissionEmployee.commissionEmployeeBasePlus;

public class BasePlusCommissionEmployee
{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private double grossSales; //total amount of sales
    private double commissionRate; //the commission rate percentage
    private double baseSalary; //base salary per week

    //Constructor
    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                      double grossSales, double commissionRate, double baseSalary)
    {
        //the implicit call to Object constructor happens here

        //validate gross sales value
        if (grossSales < 0.0)
            throw new IllegalArgumentException("gross sales must be >= 0.0");

        //validate commission rate value
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

        //validate base salary value
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
        this.baseSalary = baseSalary;
    };//end of six args constructor

    //query methods
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

    public double getGrossSales()
    {
        return grossSales;
    }

    public double getCommissionRate()
    {
        return commissionRate;
    }

    public double getBaseSalary()
    {
        return baseSalary;
    }

    //configuration methods
    public void setGrossSales(double grossSales)
    {
        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");

        this.grossSales = grossSales;
    };//end of setGrossSales(double grossSales();

    public void setCommissionRate(double commissionRate)
    {
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

        this.commissionRate = commissionRate;
    };//end of setCommissionRate(double commissionRate);

    public void setBaseSalary(double baseSalary)
    {
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
    };//end of setBaseSalary(double baseSalary);

    //client methods
    public double earnings ()
    {
        return baseSalary + (commissionRate * grossSales);
    };//end of earnings();

    @Override
    public String toString()
    {
        //we can use the query methods or the fields because they are all private and
        //are declared in the class.
        return String.format(
                "%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f",
                "base-salaried commission employee", firstName, getLastName(),
                "social security number", socialSecurityNumber,
                "gross sales", getGrossSales(), "commission rate", getCommissionRate(),
                "base salary", baseSalary
        );
    };//enf of toString()

};//end of BasePlusCommissionEmployee class

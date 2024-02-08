/** This class represents a base plus commission employee using the heritage concept.
 * Now, we can reuse code and simply add or override the fields and methods specific to
 * base plus commission employee.
 * @author pedro de castro tedesco
 * @link Java: how to program (Deitel and Deitel, 10º ed, chpater 9)
 * @see src/test/java/or.conductor.herancaPolimorfismo/commissionEmployeeBasePlusHeritage for the
 * automated JUnit 5 tests
 * */

package org.conductor.heranca.commissionEmployee;

import org.conductor.heranca.commissionEmployee.CommissionEmployee;

public class BasePlusEmployeeWithHeritage extends CommissionEmployee
{
    //field
    private double baseSalary;

    //constructor with six args
    public BasePlusEmployeeWithHeritage(String firstName, String lastName, String socialSecurityNumber,
                                        double grossSales, double commissionRate, double baseSalary)
    {
        //explicit call to superclass constructor
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

        //validate base salary value
        if(baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
    };//end of six args constructor;

    //query methods
    public double getBaseSalary()
    {
        return baseSalary;
    };//end of getBaseSalary();

    //configuration methods
    public void setBaseSalary(double baseSalary)
    {
        if(baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
    };//end of setBaseSalary(double baseSalary);

    //client methods
    @Override
    public double earnings()
    {
        //showing that since the BasePlusEmployeeWithHeritage all the instances of the subclass are instances
        // of the superclass we can use the query methods or using the 'super' keyword indicating that we are
        // invoking the superclass version of the method. Note that we cannot use the fields names
        // like "commissionRate" because they are private fields of the superclass. Hence, the necessity of
        //query methods.

        //Although we could write 'return baseSalary + (getCommissionRate() * getGrossSales())' it is better
        // to keep things separate. We use the query methods and the use os super() to call the superclass
        // method help us to understand the code better.

        return getBaseSalary() + super.earnings();
    };//end of earnings();

    @Override
    public String toString()
    {
        //We have to use the query methods, otherwise it won't work
        return String.format(
                "%s: %s%n%s: %.2f", "base-salaried",
                super.toString(), "base salary", getBaseSalary()
        );
    };//enf of toString()
};//end of BasePlusEmployeeWithHeritage

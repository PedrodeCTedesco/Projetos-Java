/** This is a test class for CommissionEmployee.
 * @author pedro de castro tedesco
 * @see "Java: how to program" (Deitel & Deitel, cap. 9)
 * */

package org.conductor.herancaPolimorfismo.commissionEmployee;

public class CommissionEmployeeTest
{
    public static void main (String[]args)
    {
        //Instantiates the CommissionEmployee object
        CommissionEmployee employee = new CommissionEmployee("Sue", "Jones",
                "222-22-2222", 10000, .06);

        //Testing the query methods
        System.out.println("Employee information obtained by get methods");
        System.out.printf("%n%s %s%n", "First name is", employee.getFirstName());
        System.out.printf("%n%s %s%n", "Last name is", employee.getLastName());
        System.out.printf("%n%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
        System.out.printf("%n%s %s%n", "Gross sales is", employee.getGrossSales());
        System.out.printf("%n%s %s%n", "Commission rate is", employee.getCommissionRate());

        //Configuration os news values to gross sales and commission rate
        employee.setGrossSales(5000);
        employee.setCommissionRate(.1);

        //Invoke toString() method
        System.out.printf("%n%s:%n%n%s%n", "Update employee information obtained by toString", employee);
    };//end of main method
};//end of CommissionEmployeeTest

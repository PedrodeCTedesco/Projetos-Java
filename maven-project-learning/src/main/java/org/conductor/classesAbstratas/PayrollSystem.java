/** This is the "main" class for the package. Here we can see how polymorphism acts
 * on runtime and understand that is the reference that the variable holds that matters
 * and not the type of that variable.
 * @author pedro de castro tedesco
 * @see Java: How to program (Deitel and Deitel, 10ª ed, chapter 10)
 * */

package org.conductor.classesAbstratas;

public class PayrollSystem
{
    public static void main (String[]args)
    {
        //Creates the subclass objects
        SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith",
                "111-11-1111", 800.00);

        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price",
                "222-22-2222", 16.75, 40);

        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones",
                "333-33-3333", 10000.0, .06);

        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob",
                "Lewis", "444-44-4444", 5000, .04, 300);

        System.out.println("Employees processed individually:");

        System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee, "earned", salariedEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n", hourlyEmployee, "earned", hourlyEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n", commissionEmployee, "earned", commissionEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n", basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());

        //Creates and initializes an array of Employee
        Employee[] employees = {salariedEmployee, hourlyEmployee, commissionEmployee, basePlusCommissionEmployee};

        System.out.printf("Employess processed polymorphically:%n%n");

        for (Employee currentEmployee : employees)
        {
            System.out.println(currentEmployee); //invokes toString();

            //Check to see if currentEmployee is a reference for BasePlusCommissionEmployee
            if (currentEmployee instanceof BasePlusCommissionEmployee employee)
            {
                //downcast the reference [Employee -> BasePlusCommissionEmployee] and save it on
                // a variable whose type is BasePlusCommissionEmployee
                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf("New base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
            };//end of if statement;
            System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
        };//end of enhanced for

        //Get the name and type of currentEmployee
        for(int i = 0; i < employees.length; i+=1)
            System.out.printf("Employee %d is a %s%n", i, employees[i].getClass().getName());

    };//end of main method
};//end of PayrollSystem

/** This is class for learning. The goal is to show how we can assign a superclass and subclass reference
 * to superclass and subclass variables.
 * @author pedro castro tedesco
 * @see Java: how to program (Deitel and Deitel, 2017, 10º ed, chapter 10)
 * @since 08/02/2024
 * */

package org.conductor.polimorfismo;

import org.conductor.heranca.commissionEmployee.BasePlusCommissionEmployee;
import org.conductor.heranca.commissionEmployee.BasePlusEmployeeWithHeritage;
import org.conductor.heranca.commissionEmployee.CommissionEmployee;

public class PolymorphismTest
{
    public static void main (String[] args)
    {
        //assign superclass reference to superclass variable
        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones",
                "222-22-2222", 10000, .06);

        //assign subclass reference to subclass variable
        BasePlusEmployeeWithHeritage basePlusEmployeeWithHeritage = new BasePlusEmployeeWithHeritage("Bob",
                "Lewis", "333-33-3333", 5000, .04, 300);

        //Invoke toString() superclass method using superclass variable
        System.out.printf("%s %s:%n%n%s%n%n", "Call CommissionEmployee's toString with superclass reference",
                "to superclass object", commissionEmployee);

        //Invoke toString() subclass method using subclass variable
        System.out.printf("%s %s:%n%n%s%n%n", "Call BasePlusEmployeeWithHeritage's toString with subclass reference",
                "reference to subclass object", basePlusEmployeeWithHeritage);

        //Invoke toString in the subclass reference using superclass variable
        //Note that when we assign a reference of a subclass to a superclass variable, and use this reference
        // to call a method, the method of the reference, not the type of the variable, is called.
        //The Java compiler aloud this because a subclass object is an instance of a superclass.
        CommissionEmployee commissionEmployee1 = basePlusEmployeeWithHeritage;
        System.out.printf("%s %s:%n%n%s%n%n", "Call BasePlusEmployeeWithHeritage's toString with superclass variable",
                "reference to subclass object", commissionEmployee1);
    };//end of main();
};//end of PolymorphismTest

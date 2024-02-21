/** The class shows how the assert keyword works in Java. Remember that to use assert you have to activate it
 * in the command line using: java -ea AssertionsSpec.java
 * @author pedro de castro tedesco
 * @since 20/02/2024
 * @see Java: how to program (Deitel and Deitel, chapter 11)
 * */
package org.conductor.exceptionTreatment;

import java.util.Scanner;

public class AssertionsSpec
{
    public static void main (String[]args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number between 0 and 10: ");
        int number = scanner.nextInt();

        //assert that precondition is true
        assert (number >= 0 && number <= 10) : "bad number: " + number;

        System.out.printf("You entered the number: %d%n", number);
    };//end of main(...)
};//end of AssertionsSpec

/** This class exemplifies how to design a program with exception handling.
 * @author: pedro de castro tedesco
 * @since 20/02/2024
 * @see Java: how to program (chapter 11)
 * */

package org.conductor.exceptionTreatment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZeroWithExceptionHandling
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true; //check to see if we need more entries

        do
        {
            try
            { //the code that could throw an exception.
              // It's the same code that we don't want to execute if an exception occurs
                System.out.print("Please enter an integer numerator: ");
                int numerator = scanner.nextInt();
                System.out.print("Please enter an integer denominator: ");
                int denominator = scanner.nextInt();

                int result = quotient(numerator, denominator);
                System.out.printf("%nResult: %d / %d = %d%n", numerator, denominator, result);
                continueLoop = false; //good entry, program finish
            } catch (InputMismatchException inputMismatchException)
            {
                System.err.printf("%nException: %s%n", inputMismatchException);
                scanner.nextLine(); //remove the entry
                System.out.printf("You must enter integers. Try again%n%n");
            } catch (ArithmeticException arithmeticException)
            {
                System.err.printf("%nException: %s%n", arithmeticException);
                System.out.printf("Zero is a invalid denominator. Please try again%n%n");
            };//end of try...catch block
        } while (continueLoop);
    };//end of main(...)

    //Implementation methods
    private static int quotient(int n, int n2) throws ArithmeticException
    {
        return n / n2;
    }
};//end of DivideByZeroWithExceptionHandling

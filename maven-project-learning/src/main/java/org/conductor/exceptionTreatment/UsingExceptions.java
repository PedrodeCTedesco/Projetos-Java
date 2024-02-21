/** This class shows the desempilhamento de pilha that happens when an exception is not handled
 * in a catch block
 * @author pedro de castro tedesco
 * @since 20/02/2024
 * @see Java: how to program (Deitel and Deitel, chapter 11)
 * */

package org.conductor.exceptionTreatment;

public class UsingExceptions
{
   public static void main(String[]args)
   {
       try
       {
           method1();
       } catch(Exception exception) //captures the exception generate in method1();
       {
           System.err.printf("%s%n%n", exception.getMessage());
           exception.printStackTrace();

           //get information of track stack
           StackTraceElement[] traceElements = exception.getStackTrace();

           System.out.printf("%nStack trace from getStrackTrace:%n");
           System.out.println("Class\t\tFile\t\tLine\tMethod");

           //Loops through traceElements to get exception descriptions
           for(StackTraceElement element : traceElements)
           {
               System.out.printf("%s\t", element.getClassName());
               System.out.printf("%s\t", element.getFileName());
               System.out.printf("%s\t", element.getLineNumber());
               System.out.printf("%s\t%n", element.getMethodName());
           };//end of enhanced for
       };//end of treatment exception
   };//end of main()

    //calls method2() and throws exception again to main
    private static void method1()throws Exception
    {
        method2();
    };//end of method1();

    private static void method2() throws Exception
    {
        method3();
    };//end of method3();

    //throws Exception to method2()
    private static void method3() throws Exception
    {
        throw new Exception("Exception thrown in method3");
    };//end of method3();
};//end of UsingExceptions

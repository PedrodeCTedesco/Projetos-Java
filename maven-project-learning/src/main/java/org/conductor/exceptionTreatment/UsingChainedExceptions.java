/** This class shows how chained exceptions works. This is useful to generate a
 * complete record of information from exception.
 * @author pedro de castro tedesco
 * @see Java: How to program (Deitel and Deitel, chapter 11)
 * @since 20/02/2024
 * */

package org.conductor.exceptionTreatment;

public class UsingChainedExceptions
{
    public static void main (String[] args)
    {
        try
        {
            method1();
        } catch (Exception exception)
        {
            exception.printStackTrace();
        };//end of exception handling
    };//end of main()

    //call method2, throws exceptions back to main
    private static void method1() throws Exception
    {
        try
        {
            method2();
        } catch (Exception e) //exception thrown in method2()
        {
            throw new Exception("Exception thrown in method1", e);
        }
    };//end of method1();

    //call method3(); throws exceptions back to method1()
    public static void method2() throws Exception
    {
        try
        {
            method3();
        } catch (Exception exception)
        {
            throw new Exception("Exception thrown in method2()", exception);
        }
    };//end of method2()

    //throws exception back to method2();
    public static void method3() throws Exception
    {
        throw new Exception("Exception thrown in method3");
    };//end of method3();
};//end UsingChainedExceptions

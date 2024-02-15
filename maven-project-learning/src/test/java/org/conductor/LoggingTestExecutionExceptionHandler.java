/** This class is used to show how the Extension API of JUnit 5 works. We can create a log of
 * all test that assert that some exception (custom or not) is thrown.
 * @author pedro de castro tedesco
 * @since 14/02/2024
 * */

package org.conductor;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingTestExecutionExceptionHandler implements TestExecutionExceptionHandler
{
    //Fields
    private Logger logger = Logger.getLogger(LoggingTestExecutionExceptionHandler.class.getName());

    @Override
    public void handleTestExecutionException(ExtensionContext context,
                                             Throwable throwable) throws Throwable
    {
        logger.log(Level.INFO, "Excetion thrown", throwable);
        throw throwable;
    };//end of handleTestExecutionException(ExtensionContext context, Throwable throwable);
};//end of LoggingTestExecutionExceptionHandler implements TestExecutionExceptionHandler

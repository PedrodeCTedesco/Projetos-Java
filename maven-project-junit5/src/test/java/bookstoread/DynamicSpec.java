/** This class shows the Dynamic Test feature of JUnit 5.
 * @author pedro de castro tedesco
 * @since 15/02/2024
 * */

package bookstoread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicSpec
{
    @TestFactory
    Collection<DynamicTest> generateFirstTest()
    {
        return Arrays.asList(
                dynamicTest("Week Test", ()-> assertEquals(DayOfWeek.MONDAY, DayOfWeek.of(1))),
                dynamicTest("Month Test", ()-> assertEquals(Month.JANUARY, Month.of(1)))
        );
    };//end of generateFirstTest();

    @TestFactory
    Stream<DynamicTest> generateParameterizedTest() {
        LocalDate startDate = LocalDate.now();
        Iterator<LocalDate> daysIter = Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(10)
                .iterator();
        return Stream.generate(() -> {
            LocalDate date = daysIter.next();
            return dynamicTest(DateTimeFormatter.ISO_LOCAL_DATE.format(date),
                    () -> assertNotNull(date));
        }).limit(10);
    };//end of

};//end of DynamicSpec

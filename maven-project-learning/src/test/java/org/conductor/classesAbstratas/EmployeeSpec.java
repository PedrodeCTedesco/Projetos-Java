/** This is the test class for Employee hierarchy
 * @author pedro de castro tedesco
 * @since 09/02/2024
 * */

package org.conductor.classesAbstratas;

//JUnit 5
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;

//AssertJ
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//API Java
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@DisplayName("<== Employee Spec ==>")
@ExtendWith(EmployeeParameterResolver.class)
public class EmployeeSpec
{
    //Fields
    private Employee pedroTedesco;
    private Employee eduardaEndler;

    @BeforeEach
    void init(Map<String, Employee> employeeInfo)
    {
        this.pedroTedesco = employeeInfo.get("Pedro Tedesco");
        this.eduardaEndler = employeeInfo.get("Eduarda Endler");
    };//end of init(Map<String, Employee> employeeInfo);

    @Nested
    @DisplayName("check the firstName, lastName and SSN values")
    class checkForFirstNameLastNameAndSSN
    {
        @Test
        @DisplayName("should return firstName when firstName provided")
        void shouldReturnFirstNameWhenFirstNameProvided()
        {
            String firstName = pedroTedesco.getFirstName();
            assertThat("Pedro").isEqualTo(firstName);
        };//end of shouldReturnFirstNameWhenFirstNameProvided();

        @Test
        @DisplayName("should throw IllegalArgumentException if first name is an empty string")
        void throwIllegalArgumentExceptionIfFirstNameIsEmptyString()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    () -> {new CommissionEmployee("", "Silva",
                            "000-000-000-00", 1000, .01);},
                    "should tell us that field first name cannot be empty");
            assertEquals("First name cannot be empty", t.getMessage());
        };// end of throwIllegalArgumentExceptionIfFirstNameIsEmptyString();

        @Test
        @DisplayName("should return lastName when lastName provided")
        void shouldReturnLastNameWhenLastNameProvided()
        {
            String lastName = eduardaEndler.getLastName();
            assertThat("Endler").isEqualTo(lastName);
        };//end of shouldReturnLastNameWhenLastNameProvided();

        @Test
        @DisplayName("should throw IllegalArgumentException if last name is an empty string")
        void throwIllegalArgumentExceptionIfLastNameIsEmptyString()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    () -> {new CommissionEmployee("Eduarda", "",
                            "000-000-000-00", 1000, .01);},
                    "should tell us that field last name cannot be empty");
            assertEquals("Last name cannot be empty", t.getMessage());
        };// end of throwIllegalArgumentExceptionIfFirstNameIsEmptyString();

        @Test
        @DisplayName("should return the SSN when SSN is provided")
        void shouldReturnSNNWhenSSNIsProvided()
        {
            String SSN = pedroTedesco.getSocialSecurityNumber();
            assertThat("030-997-150-00").isEqualTo(SSN);
        };//end of shouldReturnSNNWhenSSNIsProvided();

        @Test
        @DisplayName("should throw IllegalArgumentException if SSN is an empty string")
        void throwIllegalArgumentExceptionIfSSNIsEmptyString()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    () -> {new CommissionEmployee("Eduarda", "Endler",
                            "", 1000, .01);},
                    "should tell us that field SSN cannot be empty");
            assertEquals("Social security number cannot be empty", t.getMessage());
        };// end of throwIllegalArgumentExceptionIfFirstNameIsEmptyString();
    };//end of checkForFirstNameLastNameAndSSN;
};//end of EmployeeSpec

//Create the EmployeeParameterResolver since we will use the same data for the tests
class EmployeeParameterResolver implements ParameterResolver
{
    @Override
    public boolean supportsParameter(final ParameterContext parameterContext,
                                     final ExtensionContext extensionContext) throws ParameterResolutionException
    {
        Parameter parameter = parameterContext.getParameter();
        return Objects.equals(parameter.getParameterizedType().getTypeName(),
                "java.util.Map<java.lang.String, org.conductor.classesAbstratas.Employee>");
    };//end of supportsParameter(...)

    @Override
    public Object resolveParameter(final ParameterContext parameterContext,
                                   final ExtensionContext extensionContext) throws ParameterResolutionException
    {
        Map<String, Employee> employeeInfo = new HashMap<>();

        //CommissionEmployee object
        employeeInfo.put("Pedro Tedesco", new CommissionEmployee("Pedro", "Tedesco",
                "030-997-150-00", 5000.0, .04));

        //HourlyEmployee object
        employeeInfo.put("Eduarda Endler", new HourlyEmployee("Eduarda", "Endler",
                "020-225-164-88", 4500.0, 148.0));

        employeeInfo.put("Leonardo Endler", new HourlyEmployee("Leonardo", "Endler",
                "123-456-789-00", 1000.0, 40.0));

        employeeInfo.put("Lorenzo Tedesco", new HourlyEmployee("Lorenzo", "Tedesco",
                "987-654-321-00", 1400.0, 30.0));

        //SalariedEmployee object
        employeeInfo.put("Alex Kretchmer", new SalariedEmployee("Alex", "Kretchmer",
                "159-878-639-45", 3500.0));

        //BasePlusCommissionEmployee
        employeeInfo.put("Fernanda Kretchmer", new BasePlusCommissionEmployee("Fernanda", "Kretchmer",
                "785-986-333-02", 1240.0, .34, 4300.0));

        return employeeInfo;
    };//end of resolveParameter(...)
}
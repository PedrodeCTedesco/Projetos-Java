/** This is the test class for SalariedEmployee.
 * @author pedro de castro tedesco
 * @since 09/02/2024
 * */

package org.conductor.classesAbstratas;

//JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//API Java
import java.util.Map;

//AssertJ
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("<== SalariedEmpoyee Spec ==>")
@ExtendWith(EmployeeParameterResolver.class)
public class SalariedEmployeeSpec
{
    //Fields
    private Employee alexKretchmer;

    @BeforeEach
    void init(Map<String, Employee> employeeInfo)
    {
        this.alexKretchmer = employeeInfo.get("Alex Kretchmer");
    };//end of init(Map<String, Employee> employeeInfo);

    @Test
    @DisplayName("should return weeklySalary when weeklySalary is provided")
    void returnWeeklySalaryWhenWeeklySalaryIsProvided()
    {
        double weeklySalary = ((SalariedEmployee)alexKretchmer).getWeeklySalary();
        assertThat(3500.0).isEqualTo(weeklySalary);
    };//end of returnWeeklySalaryWhenWeeklySalaryIsProvided();

    @Test
    @DisplayName("change the weeklySalary when invoked")
    void changeTheWeeklySalaryWhenInvoked()
    {
        ((SalariedEmployee)alexKretchmer).setWeeklySalary(2456.90);
        assertThat(2456.90).isEqualTo(((SalariedEmployee)alexKretchmer).getWeeklySalary());
    };//end of changeTheWeeklySalaryWhenInvoked();

    @Test
    @DisplayName("throw IllegalArgumentException when weeklySalary is < 0.0")
    void throwIllegalArgumentExceptionWhenWeeklySalaryIsLessThanZero()
    {
        IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                ()->{((SalariedEmployee)alexKretchmer).setWeeklySalary(-1.0);},
                "should throw IllegalArgumentException because weekly salary value is < 0.0");
        assertEquals("Weekly salary must be >= 0.0", t.getMessage());
    }

    @Test
    @DisplayName("check earnings() method")
    void checkEarningsMethodForSalariedEmployee()
    {
        double earnings = ((SalariedEmployee)alexKretchmer).earnings();
        assertThat(3500.0).isEqualTo(earnings);
    };//end of checkEarningsMethodForSalariedEmployee();

};//end of SalariedEmployeeSpec

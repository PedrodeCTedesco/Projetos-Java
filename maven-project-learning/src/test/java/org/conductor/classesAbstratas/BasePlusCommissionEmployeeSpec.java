/** This is the test class for BasePlusCommissionEmployee. Note that this is an indirect subclass
 * of Employee superclass.
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

@DisplayName("<== BasePlusCommissionEmployee Spec ==>")
@ExtendWith(EmployeeParameterResolver.class)
public class BasePlusCommissionEmployeeSpec
{
    //Fields
    private Employee fernandaKretchmer;

    @BeforeEach
    void init(Map<String, Employee> employeeInfo)
    {
        this.fernandaKretchmer = employeeInfo.get("Fernanda Kretchmer");
    };//end of init(...);

    @Test
    @DisplayName("should return base salary when base salary is provided")
    void shouldReturnBaseSalaryWhenBaseSalaryIsProvided()
    {
        double baseSalary = ((BasePlusCommissionEmployee)fernandaKretchmer).getBaseSalary();
        assertThat(4300.0).isEqualTo(baseSalary);
    };//end of shouldReturnBaseSalaryWhenBaseSalaryIsProvided();

    @Test
    @DisplayName("throw IllegalArgumentException when base salary is < 0.0")
    void throwIllegalArgumentExceptionWhenBaseSalaryIsLessThanZero()
    {
        IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                ()->{((BasePlusCommissionEmployee)fernandaKretchmer).setBaseSalary(-1.0);},
                "should throw IllegalArgumentException because base salet is < 0.0");
        assertEquals("Base salary must be >= 0.0", t.getMessage());
    };//end of throwIllegalArgumentExceptionWhenBaseSalaryIsLessThanZero();

    @Test
    @DisplayName("check if we can alter the base salary")
    void baseSalaryShouldBeAlteredWhenSetBaseSalaryIsInvoked()
    {
        ((BasePlusCommissionEmployee)fernandaKretchmer).setBaseSalary(2000.0);
        double baseSalary = ((BasePlusCommissionEmployee)fernandaKretchmer).getBaseSalary();
        assertThat(2000.0).isEqualTo(baseSalary);
    };//end of baseSalaryShouldBeAlteredWhenSetBaseSalaryIsInvoked();

    @Test
    @DisplayName("check if earnings() method is working")
    void checkIfEarningsIsCorrectWhenInvoked()
    {
        double earnings = ((BasePlusCommissionEmployee)fernandaKretchmer).earnings();
        assertThat(4721.6).isEqualTo(earnings);
    };//end of checkIfEarningsIsCorrectWhenInvoked();
};//end of BasePlusCommissionEmployeeSpec

package org.conductor.classesAbstratas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

//API Java
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("<== Hourly Employee Spec ==>")
@ExtendWith(EmployeeParameterResolver.class)
public class HourlyEmployeeSpec
{
    //Fields
    private Employee eduardaEndler;
    private Employee leonardoEndler;
    private Employee lorenzoTedesco;

    @BeforeEach
    void init(Map<String, Employee> employeeInfo)
    {
        this.eduardaEndler = employeeInfo.get("Eduarda Endler");
        this.leonardoEndler = employeeInfo.get("Leonardo Endler");
        this.lorenzoTedesco = employeeInfo.get("Lorenzo Tedesco");
    };//end of init();

    @Nested
    @DisplayName("check the values of hours and wage")
    class WageAndHoursValues
    {
        @Test
        @DisplayName("should return the value of wage when wage is provided")
        void returnWageValueWhenWageIsProvided()
        {
            double wage = ((HourlyEmployee) eduardaEndler).getWage();
            assertThat(4500.0).isEqualTo(wage);
        };//end of returnWageValueWhenWageIsProvided();

        @Test
        @DisplayName("should throw IllegalArgumentException when wage value is < 0.0")
        void throwIllegalArgumentExceptionWhenWageValueIsLessThanZero()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {((HourlyEmployee)eduardaEndler).setWage(-10.0);},
                    "should throw IllegalArgumentException because wage value is < 0.0");
            assertEquals("Hourly wage must be >= 0.0", t.getMessage());
        };//end of throwIllegalArgumentExceptionWhenWageValueIsLessThanZero();

        @Test
        @DisplayName("change the wage value")
        void shouldChangeTheWageValueWhenInvoked()
        {
            ((HourlyEmployee)eduardaEndler).setWage(6523.0);
            assertThat(6523.0).isEqualTo(((HourlyEmployee)eduardaEndler).getWage());
        };//end of shouldChangeTheWageValueWhenInvoked();

        @Test
        @DisplayName("should return the hours value when hours is provided")
        void returnHoursValueWhenHoursIsProvided()
        {
            double hours = ((HourlyEmployee)eduardaEndler).getHours();
            assertThat(148.0).isEqualTo(hours);
        };//end of returnHoursValueWhenHoursIsProvided();

        @Test
        @DisplayName("throw IllegalArgumentException because hours value is < 0.0")
        void throwIllegalArgumentExceptionWheHoursValueIsLessThanZero()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()->{((HourlyEmployee)eduardaEndler).setHours(-1.9);},
                    "should throw IllegalArgumentException because the value is < 0.0");
            assertEquals("Hours worked must be >= 0.0 and <= 168.0", t.getMessage());
        };//end of throwIllegalArgumentExceptionWheHoursValueIsLessThanZero();

        @Test
        @DisplayName("throw IllegalArgumentException because hours value is > 168.0")
        void throwIllegalArgumentExceptionWhenHoursValueIsGreaterThan168()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()->{((HourlyEmployee)eduardaEndler).setHours(169);},
                    "should throw IllegalArgumentException because hours value is > 168.0");
            assertEquals("Hours worked must be >= 0.0 and <= 168.0", t.getMessage());
        };//end of throwIllegalArgumentExceptionWhenHoursValueIsGreaterThan168();

        @Test
        @DisplayName("change the hours value")
        void shouldChangeTheHoursValueWhenInvoked()
        {
            ((HourlyEmployee)eduardaEndler).setHours(132.4);
            assertThat(132.4).isEqualTo(((HourlyEmployee)eduardaEndler).getHours());
        };//end of shouldChangeTheHoursValueWhenInvoked()
    };//end of WageAndHoursValues

    @Nested
    @DisplayName("check the earnings method")
    class EarningsMethod
    {
        @Test
        @DisplayName("check the earnings() method when hours == 40")
        void checkIfEarningsMethodWorksWhenHoursIsEqualTo40()
        {
            double earnings = ((HourlyEmployee) leonardoEndler).earnings();
            assertThat(40000.0).isEqualTo(earnings);
        };//end of checkIfEarningsMethodWorksWhenHoursIsEqualTo40();

        @Test
        @DisplayName("check the earnings() method when hours is <= 40")
        void checkIfEarningsMethodWorksWhenHoursIsLessThan40()
        {
            double earnings = ((HourlyEmployee)lorenzoTedesco).earnings();
            assertThat(42000.0).isEqualTo(earnings);
        };//end of checkIfEarningsMethodWorksWhenHoursIsLessThan40();

        @Test
        @DisplayName("check the earnings() method when hours is > 40")
        void checkIfEarningsMethodWorkWhenHoursIsGreaterThan40()
        {
            double earnings = ((HourlyEmployee)eduardaEndler).earnings();
            assertThat(909000.0).isEqualTo(earnings);
        };//end of checkIfEarningsMethodWorkWhenHoursIsGreaterThan40();
    };//end of EarningsMethod
};//end of HourlyEmployeeSpec

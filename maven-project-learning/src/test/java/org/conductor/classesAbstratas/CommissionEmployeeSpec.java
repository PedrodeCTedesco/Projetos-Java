/** This is the specific class to test the behvaior of CommissionEmployee
 * @author pedro de castro tedesco
 * @since 09/02/2024
 * */

package org.conductor.classesAbstratas;

//JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Nested;

//API Java
import java.util.Map;

//AssertJ
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("<== Commission Employee Spec ==>")
@ExtendWith(EmployeeParameterResolver.class)
public class CommissionEmployeeSpec
{
    //Fields
    private Employee pedroTedesco;

    @BeforeEach
    void init(Map<String, Employee> employeeInfo)
    {
        this.pedroTedesco = employeeInfo.get("Pedro Tedesco");
    };//end of setup()

    @Nested
    @DisplayName("check the values of gross sales and commission rate")
    class CommissionRateAndGrossSalesValues
    {
        @Test
        @DisplayName("should throw IllegalArgumentException when gross sales value is < 0.0")
        void throwIllegalArgumentExceptionWhenGrossSalesValueIs0()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    () -> {new CommissionEmployee("Pedro", "Tedesco",
                            "000-000-000-00", -1.0, .01);},
                    "should throw IllegalArgumentException because the value of gross sales is < 0.0");
            assertEquals("Gross sales must be >= 0.0", t.getMessage());
        };//end of throwIllegalArgumentExceptionWhenGrossSalesValueIs0();

        @Test
        @DisplayName("should return gross sales value when gross sales is provided")
        void checkTheGetGrossSalesMethod()
        {
            //down casting to check if the subclass exclusive method works.
            double grossSales = ((CommissionEmployee) pedroTedesco).getGrossSales();
            assertThat(5000.0).isEqualTo(grossSales);
        };//end of theSuperMethodGetFirstNameWorks();

        @Test
        @DisplayName("change the gross sales value")
        void shouldChangeTheGrossSalesValueIsInvoked()
        {
            ((CommissionEmployee)pedroTedesco).setGrossSales(1234.0);
            assertThat(1234.0).isEqualTo(((CommissionEmployee)pedroTedesco).getGrossSales());
        };//end of shouldChangeTheGrossSalesValueIsInvoked();

        @Test
        @DisplayName("should return commission rate when commission rate is provided")
        void checkTheGetCommissionRateMethod()
        {
            //down casting to check if the subclass exclusive method works.
            double commissionRate = ((CommissionEmployee) pedroTedesco).getCommissionRate();
            assertThat(.04).isEqualTo(commissionRate);
        };//end of checkTheGetCommissionRateMethod();

        @Test
        @DisplayName("should throw IllegalArgumentException when commission rate value == 1.0")
        void throwIllegalArgumentExceptionWhenCommissionRateIsEqualToOne()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    () -> {((CommissionEmployee) pedroTedesco).setCommissionRate(1.0);},
                    "should throw IllegalArgumentException because the value of gross sales is == 1.0");
            assertEquals("Commission rate must be > 0.0 and < 1.0", t.getMessage());
        };//end of throwIllegalArgumentExceptionWhenCommissionRateIsEqualToOne();

        @Test
        @DisplayName("should throw IllegalArgumentException when commission rate value is == 0")
        void throwIllegalArgumentExceptionWhenCommissionRateIsEqualToZero()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    () -> {((CommissionEmployee) pedroTedesco).setCommissionRate(0.0);},
                    "should throw IllegalArgumentException because the value of gross sales is < 0.0");
            assertEquals("Commission rate must be > 0.0 and < 1.0", t.getMessage());
        };//end of throwIllegalArgumentExceptionWhenCommissionRateIsEqualToZero();

        @Test
        @DisplayName("should throw IllegalArgumentException when commission rate value is > 1.0")
        void throwIllegalArgumentExceptionWhenCommissionRateIsGreaterThanOne()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    () -> {((CommissionEmployee) pedroTedesco).setCommissionRate(2.0);},
                    "should throw IllegalArgumentException because the value of gross sales is >= 2.0");
            assertEquals("Commission rate must be > 0.0 and < 1.0", t.getMessage());
        };//end of throwIllegalArgumentExceptionWhenCommissionRateIsGreaterThanOne();

        @Test
        @DisplayName("should throw IllegalArgumentException when commission rate value is < 0.0")
        void throwIllegalArgumentExceptionWhenCommissionRateIsLessThanZero()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    () -> {((CommissionEmployee) pedroTedesco).setCommissionRate(-1.0);},
                    "should throw IllegalArgumentException because the value of gross sales is < 0.0");
            assertEquals("Commission rate must be > 0.0 and < 1.0", t.getMessage());
        };//end of throwIllegalArgumentExceptionWhenCommissionRateIsLessThanZero();

        @Test
        @DisplayName("change the value os commission rate")
        void changeCommissionRateWhenInvoked()
        {
            ((CommissionEmployee)pedroTedesco).setCommissionRate(.55);
            assertThat(0.55).isEqualTo(((CommissionEmployee)pedroTedesco).getCommissionRate());
        };//end of changeCommissionRateWhenInvoked();
    };//end of CommissionRateAndGrossSalesValues

    @Test
    @DisplayName("check if earnings() method works")
    void checkIfEarningsMethodWorks()
    {
        double earnings = ((CommissionEmployee) pedroTedesco).earnings();
        assertThat(200.0).isEqualTo(earnings);
    };//end of checkIfEarningsMethodWorks();

};//end of CommissionEmployeeSpec

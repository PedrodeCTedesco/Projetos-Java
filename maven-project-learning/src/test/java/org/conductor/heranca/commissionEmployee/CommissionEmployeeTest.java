/** This is a test class for CommissionEmployee.
 * @author pedro de castro tedesco
 * @see "Java: how to program" (Deitel & Deitel, cap. 9)
 * */

package org.conductor.heranca.commissionEmployee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommissionEmployeeTest
{

    private CommissionEmployee employee;

    @BeforeEach
    void init() throws Exception
    {
        employee = new CommissionEmployee("Sue", "Jones",
                "222-22-2222", 10000, .06);
    };//end of init()

    //testing query methods
    @Test
    @DisplayName("should return the employee's first name")
    void shouldReturnEmployeeFirstName()
    {
        String employeeName = employee.getFirstName();
        assertEquals("Sue", employeeName);
    };//end of shouldReturnEmployeeFistName()

    @Test
    @DisplayName("should return the employee's last name")
    void shouldReturnEmployeeLastName()
    {
        String employeeLastName = employee.getLastName();
        assertEquals("Jones", employeeLastName);
    };// end of shouldReturnEmployeeLastName();

    @Test
    @DisplayName("should return employee's social security number")
    void shouldReturnEmployeeSocialSecurityNumber()
    {
        String employeeSociaSecurityNumber = employee.getSocialSecurityNumber();
        assertEquals("222-22-2222", employeeSociaSecurityNumber);
    };//end of shouldReturnEmployeeSocialSecurityNumber()

    @Test
    @DisplayName("should return gross sales value of employee")
    void shouldReturnEmployeeGrossSales()
    {
        double employeeGrossSales = employee.getGrossSales();
        assertEquals(10000, employeeGrossSales);
    };//end of shouldReturnEmployeeGrossSales()

    @Test
    @DisplayName("should return employee's commission rate")
    public void shouldReturnEmployeeCommissionRate()
    {
        double employeeCommissionRate = employee.getCommissionRate();
        assertEquals(.06, employeeCommissionRate);
    };//end of shouldReturnEmployeeCommissionRate()

    //testing configuration methods
    @Test
    @DisplayName("should change the employee gross sales value to 5000")
    void employeeGrossSalesValueIsNow5000()
    {
        employee.setGrossSales(5000);
        assertEquals(5000, employee.getGrossSales());
    };//end of employeeGrossSalesValueIsNow5000();

    @Test
    @DisplayName("gross sales value should not be less than 0.0")
    void throwsExceptionWhenGrossSalesValueIsLessThanZero ()
    {
        IllegalArgumentException t = assertThrows(IllegalArgumentException.class, () -> {employee.setGrossSales(-1.0);},
                "should throw IllegalArgumentException");
        assertEquals("Gross sales must be > 0.0", t.getMessage());
    };//end of throwsExceptionWhenGrossSalesValueIsLessThanZero()

    @Test
    @DisplayName("should change employee's commission rate to .01")
    void employeeCommissionRateIsNow01()
    {
        employee.setCommissionRate(.01);
        assertEquals(.01, employee.getCommissionRate());
    };//end of employeeCommissionRateIsNow01();

    @Test
    @DisplayName("commission rate value should < 1.0")
    void throwsExceptionWhenCommissionRateValueIsEqualTo1 ()
    {
        IllegalArgumentException t = assertThrows(IllegalArgumentException.class, () -> {employee.setCommissionRate(1.0);},
                "should throw IllegalArgumentException");
        assertEquals("Commission rate must be > 0.0 and < 1.0", t.getMessage());
    };//end of throwsExceptionWhenGrossSalesValueIsLessThanZero()

    @Test
    @DisplayName("commission rate value should be > 0.0")
    void throwsExceptionWhenCommissionRateValueIsEqualToZero ()
    {
        IllegalArgumentException t = assertThrows(IllegalArgumentException.class, () -> {employee.setCommissionRate(0.0);},
                "should throw IllegalArgumentException");
        assertEquals("Commission rate must be > 0.0 and < 1.0", t.getMessage());
    };//end of throwsExceptionWhenGrossSalesValueIsLessThanZero()

};//end of CommissionEmployeeTest

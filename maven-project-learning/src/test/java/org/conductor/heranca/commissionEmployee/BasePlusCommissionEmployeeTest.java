/** This is the automated test class for BasePlusCommissionEmployee using Junit 5.
 * @author pedro de castro tedesco
 * @since 04/02/2024
 * @see "Java: how to program" (Deitel and Deitel, 10ªed, chapter 9)
 * */

package org.conductor.heranca.commissionEmployee;

import org.conductor.heranca.commissionEmployee.BasePlusCommissionEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasePlusCommissionEmployeeTest
{
    //fields
    private BasePlusCommissionEmployee basePlusEmployee;

    @BeforeEach
    void init() throws Exception
    {
        basePlusEmployee = new BasePlusCommissionEmployee("Bob", "Lewis",
                "333-33-3333", 5000, .04, 300);
    };//end of init();

    //testing query methods
    @Test
    @DisplayName("should return base plus employee's first name")
    void returnBasePlusEmployeeFirstName()
    {
        String basePlusEmployeeFirstName = basePlusEmployee.getFirstName();
        assertEquals("Bob", basePlusEmployeeFirstName);
    };//end of returnBasePlysEmployeeFirstName();

    @Test
    @DisplayName("should return base plus employee last name")
    void returnBasePlusEmployeeLastName()
    {
        String basePlusEmployeeLastName = basePlusEmployee.getLastName();
        assertEquals("Lewis", basePlusEmployeeLastName);
    };//end of returnBasePlusEmployeeLastName();

    @Test
    @DisplayName("should return base plus employee social security number")
    void returnBasePlusEmployeeSocialSecurityNumber()
    {
        String basePlusEmployeeSSN = basePlusEmployee.getSocialSecurityNumber();
        assertEquals("333-33-3333", basePlusEmployeeSSN);
    };//end of returnBasePlusEmployeeSocialSecurityNumber();

    //testing configuration methods
    @Test
    @DisplayName("should throw IllegalArgumentException when gross sales value is less than 0.0")
    void throwIllegalArgumentExceptionWhenGrossSalesValueIsLessThanZero()
    {
        IllegalArgumentException t = assertThrows(IllegalArgumentException.class, () -> {
            basePlusEmployee.setGrossSales(-1.0);}, "Gross sales value must be >= 0.0");
        assertEquals("Gross sales must be >= 0.0", t.getMessage());
    };//end of throwIllegalArgumentExceptionWhenGrossSalesValueIsLessThanZero();

    @Test
    @DisplayName("should throw IllegalArgumentException when commission rate value is equal to zero")
    void throwIllegalArgumentExceptionWhenCommissionRateIsEqualToZero()
    {
        IllegalArgumentException t = assertThrows(IllegalArgumentException.class, ()->{
            basePlusEmployee.setCommissionRate(0.0);}, "Commission rate must be > 0.0");
        assertEquals("Commission rate must be > 0.0 and < 1.0", t.getMessage());
    };//throwIllegalArgumentExceptionWhenCommissionRateIsEqualToZero();

    @Test
    @DisplayName("should throw IllegalArgumentException when commission rate value is less than zero")
    void throwIllegalArgumentExceptionWhenCommissionRateIsLessThanZero()
    {
        IllegalArgumentException t = assertThrows(IllegalArgumentException.class, ()->{basePlusEmployee.setCommissionRate(-1.0);},
                "Commission rate should not be less than zero.");
        assertEquals("Commission rate must be > 0.0 and < 1.0", t.getMessage());
    };//throwIllegalArgumentExceptionWhenCommissionRateIsLessThanZero();

    @Test
    @DisplayName("should throw IllegalArgumentException when commission rate value is equal to one")
    void throwIllegalArgumentExceptionWhenCommissionRateIsEqualToOne()
    {
        IllegalArgumentException t = assertThrows(IllegalArgumentException.class, ()->{basePlusEmployee.setCommissionRate(1.0);},
                "commission rate value should not be equal to 1.0");
        assertEquals("Commission rate must be > 0.0 and < 1.0", t.getMessage());
    };//throwIllegalArgumentExceptionWhenCommissionRateIsEqualToOne();

    @Test
    @DisplayName("should throw IllegalArgumentException when commission rate value is greater than one")
    void throwIllegalArgumentExceptionWhenCommissionRateIsGreaterThanOne()
    {
        IllegalArgumentException t = assertThrows(IllegalArgumentException.class, ()->{basePlusEmployee.setCommissionRate(2.0);},
                "Commission rate should not be greater than one.");
        assertEquals("Commission rate must be > 0.0 and < 1.0", t.getMessage());
    };//throwIllegalArgumentExceptionWhenCommissionRateIsLessThanZero();

    @Test
    @DisplayName("should throw IllegalArgumentException when base salary value is less than zero")
    void throwIllegalArgumentExceptionWhenBaseSalaryValueIsLessThanZero()
    {
        IllegalArgumentException t = assertThrows(IllegalArgumentException.class, ()->{basePlusEmployee.setBaseSalary(-1.0);},
                "Base salary value should not be less than zero");
        assertEquals("Base salary must be >= 0.0", t.getMessage());
    };//throwIllegalArgumentExceptionWhenBaseSalaryValueIsLessThanZero();

    @Test
    @DisplayName("should not throw IllegalArgumentException when base salary is equal to zero")
    void baseSalaryCanBeEqualToZero()
    {
        basePlusEmployee.setBaseSalary(0.0);
        assertEquals(0.0, basePlusEmployee.getBaseSalary());
    };//baseSalaryCanBeEqualToZero();

    @Test
    @DisplayName("base salary must be changed to 1000")
    void baseSalaryMustBeChangedTo1000()
    {
        basePlusEmployee.setBaseSalary(1000);
        double basePlusEmployeeSalary = basePlusEmployee.getBaseSalary();
        assertEquals(1000, basePlusEmployeeSalary);
    }

};//end of BasePlusCommissionEmployeeTest

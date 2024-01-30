

import static org.junit.Assert.*;
import static junit.tests.framework.*;

public class CalculatorTest
{
	@Test
	public void testAdd() 
	{
		//Instância da classe
		Calculator calculator = new Calculator();
		
		//Testando o método
		double result = calculator.add(10, 50);
		assertEquals(60, result, 0);
	}
}
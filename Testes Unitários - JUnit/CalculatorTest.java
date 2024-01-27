/** Classe de teste do método add para verificar seu contrato de API (assinatura do método). 
 * Nesta classe temos uma demonstração padrão, simples, de testagem. Uma dificuldade desse tipo de testagem
 * é que ele pode ficar difícil de manter conforme o software cresça. 
 * Ver. BetterCalculatorTest.java para um exemplo de testagem escalável. 
 * */

public class CalculatorTest
{
	public static void main(String[]args)
	{
		//Instância da classe
		Calculator calculator = new Calculator();
		
		//Testando o método
		double result = calculator.add(10, 50);
		
		if (result != 60)
			System.out.printf("%s: %d", "Bad result", result);
	};//fim do método main
};//fim da classe CalculatorTest
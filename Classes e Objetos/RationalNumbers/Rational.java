import java.util.Scanner;

/** Crie uma classe chamada Rational para realizar aritmética com frações. Escreva um programa para testar sua classe. 
 * Use variáveis de inteiros para representar as variáveis de instância private da classe — o numerator e o denominator.
 * Forneça um construtor que permita que um objeto dessa classe seja inicializado quando ele for declarado. O construtor deve armazenar a fração em uma forma reduzida.
 * A fração:
 *  2/4
 *  
 *  Seria armazenada como: 1/2, onde no objeto como 1 no numerator e 2 no denominator. Forneça um construtor sem argumento com valores padrão caso 
 *  nenhum inicializador seja fornecido. Forneça métodos public que realizam cada uma das operações a seguir:
 *  a) Somar dois números Rational: o resultado da adição deve ser armazenado na forma reduzida. Implemente isso como um método static;
 *  b) Subtrair dois números Rational: o resultado da subtração deve ser armazenado na forma reduzida. Implemente isso como um método static;
 *  c) Multiplicar dois números Rational: o resultado da multiplicação deve ser armazenado na forma reduzida. Implemente isso como um método static.
 *  d) Dividir dois números Rational: o resultado da divisão deve ser armazenado na forma reduzida. Implemente isso como um método static;
 *  e) Retorne uma representação String de um número Rational na forma a/b, onde a é o numerator e b é o denominator;
 *  f) Retorne uma representação String de um número Rational no formato de ponto flutuante. (Considere a possibilidade de fornecer capacidades de formatação que permitam 
 *  que o usuário da classe especifique o número de dígitos de precisão à direita do ponto de fração decimal.)
 *  @author pedro de castro tedesco
 *  @link "Java: como programar" (Deitel e Deitel, 10ª ed, cap. 8)
 *  @since 24/01/2024 
 */

public class Rational
{
	private int numerator;
	private int denominator;
	
	public Rational(int numerator, int denominator)
	{
		if(numerator <= 0 || denominator <= 0)
			throw new IllegalArgumentException("Numerator and/or denominator must be greater than zero.");
		
		this.numerator = numerator / calculateMDC(numerator, denominator);
		this.denominator = denominator / calculateMDC(numerator, denominator);
	};//fim do construtor
	
	
	public int getNumerator()
	{
		return numerator;
	};//fim do método getNumerator()
	
	public int getDenominator()
	{
		return denominator;
	};//fim do método getDenominator()
	
	
	private static int calculateMDC (int number1, int number2)
	{
		//Podemos identificar o Menor Divisor Comum (MDC0 de dois números inteiros aplicando o Algoritmo de Euclides
		while (number2 != 0)
		{
			int resto = number1 % number2;
			number1 = number2;
			number2 = resto;
		};//fim da sentença de iteração while
		return number1;
	};//fim do método calculateMDC(int number1, int number2)
	
	public String toString()
	{
		return String.format("Fração irredutível: %d/%d", getNumerator(), getDenominator());
	};//fim do método toString()

	public String toStringFloat()
	{
		//Armazenando o numerador e denominador
		int numerator = getNumerator();
		int denominator = getDenominator();
		
		//Realizando a divisão entre eles
		float floatResult = numerator / denominator;
		
		//Exibindo prompt na janela de comando para o usuário especificar a quantidade de casas após a vírgula
		Scanner input = new Scanner(System.in);
		System.out.printf("%s%n", "Quantas casas após a vírgula você deseja na exibição do resultado?");
		int specifier = input.nextInt();
		
		//Gerando a saída na janela de comando
		return String.format("The division between %d and %d is: %f", numerator, denominator, floatResult);
		
	};//fim do método toStringFloat()
	
};//fim da classe Rational
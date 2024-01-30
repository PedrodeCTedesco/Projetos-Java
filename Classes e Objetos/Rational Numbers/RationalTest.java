/** Classe de teste para a classe Rational 
 * @author pedro de castro tedesco
 * @link "Java: como programar" (Deitel e Deitel, 10ªed, cap. 8)
 * @since 24/01/2024
 * */ 

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class RationalTest
{
	public static void main (String[]args)
	{
		//Instâncias da classe
		Rational rational = new Rational(3, 4);
		System.out.printf("%s%n", rational);
		//System.out.printf("Testing toStrinfFloat(): %s%n", rational.toStringFloat());
		
		System.out.printf("Testing addTwoRationals(): %s%n", Rational.addTwoRationals(3, 4, 5, 6));
		System.out.printf("Testing subtractTwoRationals(): %s%n", Rational.subtractTwoRationls(3, 4, 1, 6));
		System.out.printf("Testing productTwoRationals(): %s%n", Rational.productTwoRationals(23, 5, 123, 41));
		System.out.printf("Testing divdeTwoRationals(): %s%n", Rational.divideTwoRationals(8, 9, 4, 5));
	};//fim do método main
};//fim da classe RationalTest


class Rational
{
	private int numerator;
	private int denominator;
	
	public Rational(int numerator, int denominator)
	{
		if(numerator <= 0 || denominator <= 0)
			throw new IllegalArgumentException("Numerator and/or denominator must be greater than zero.");
		
		int mdc = calculateMDC(numerator, denominator);
		
		this.numerator = numerator / mdc;
		this.denominator = denominator / mdc;
	};//fim do construtor
	
	//Métodos cliente
	
	public int getNumerator()
	{
		return numerator;
	};//fim do método getNumerator()
	
	public int getDenominator()
	{
		return denominator;
	};//fim do método getDenominator()

	public static String addTwoRationals(int numerator_1, int denominator_1, int numerator_2, int denominator_2)
	{
		//Obtendo os valores de cada fração
		//Etapa 1: encontrar o MMC para os denominadores
		int mmc = calculateMMC(denominator_1, denominator_2);
		
		//Etapa 2: converter as frações para o denominador comum
		int numeratorRational1 = numerator_1 * (mmc / denominator_1);
		int numeratorRational2 = numerator_2 * (mmc / denominator_2);
		
		//Etapa 3: somar os numeradores
		int numeratorSum = numeratorRational1 + numeratorRational2;
		
		//Etapa 4: simplificar a fração resultante
		int divisorInComum = calculateMDC(numeratorSum, mmc);
		int simplifiedNumerator = numeratorSum / divisorInComum;
		int simplifiedDenominator = mmc / divisorInComum;
		
		//Etapa 7: retornar o resultado
		String simplifiedNumeratorString = String.valueOf(simplifiedNumerator);
		String simplifiedDenominatorString = String.valueOf(simplifiedDenominator);
		return String.format("%s/%s", simplifiedNumeratorString, simplifiedDenominatorString);
	};//fim do método addTwoRationals
	
	public static String subtractTwoRationls(int numerator_1, int denominator_1, int numerator_2, int denominator_2)
	{
		//Etapa 1: encontrar um denominador comum para os denominadores
		int mmc = calculateMMC(denominator_1, denominator_2);
		
		//Etapa 2: multiplicar os numeradores e denominadores para obter denominadores comuns
		int newNumerator_1 = numerator_1 * (mmc / denominator_1);
		int newNumerator_2 = numerator_2 * (mmc / denominator_2);
		
		//Etapa 3: subtrair os numeradores 
		int resultNumerator = newNumerator_1 - newNumerator_2;
		
		//Etapa 4: simplifique a fração, se necessário
		int mdc = calculateMDC(resultNumerator, mmc);
		
		if (mdc == 1)
			return String.format("%d/%d", resultNumerator, mmc);
		
		int simplifiedNumerator = resultNumerator / mdc;
		int simplifiedDenominator = mmc / mdc;
		
		return String.format("%d/%d", simplifiedNumerator, simplifiedDenominator);
	};//fim do método subtractTwoRationsl(int numerator_1, int denominator_1, int numerator_2, int denominator_2)

	public static String productTwoRationals(int numerator_1, int denominator_1, int numerator_2, int denominator_2)
	{
		//Etapa 1: multiplicar os numeradores e obter o novo numerador
		int numeratorProduct = numerator_1 * numerator_2;
		
		//Etapa 2: multiplicar os denominadores e obter o novo denominador
		int denominatorProduct = denominator_1 * denominator_2;
		
		//Etapa 3: deixar a fração na forma irredutível, se necessário
		int mdc = calculateMDC(numeratorProduct, denominatorProduct);
		
		if(mdc == 1)
			return String.format("%d/%d", numeratorProduct, denominatorProduct);
		
		int simplifiedNumeratorProduct = numeratorProduct / mdc;
		int simplifiedDenominatorProduct = denominatorProduct / mdc;
		
		return String.format("%d/%d", simplifiedNumeratorProduct, simplifiedDenominatorProduct);
			
	};//fim do método productTwoRationals(int numerator_1, int denominator_1, int numerator_2, int denominator_2)
	
	public static String divideTwoRationals(int numerator_1, int denominator_1, int numerator_2, int denominator_2)
	{
		//Etapa 1: Inverter a segunda fração
		int invertedNumerator = denominator_2;
		int invertedDenominator = numerator_2;
		
		//Etapa 2: Multiplicar a primeira fração pelo inverso da segunda
		int newNumerator = numerator_1 * invertedNumerator;
		int newDenominator = denominator_1 * invertedDenominator;
		
		//Etapa 3: Retornar a fração na sua versão irredutível
		int mdc = calculateMDC(newNumerator, newDenominator);
		
		if (mdc == 1)
			return String.format("%d/%d", newNumerator, newDenominator);
		
		int simplifiedNumerator = newNumerator / mdc;
		int simplifiedDenominator = newDenominator / mdc;
		
		return String.format("%d/%d", simplifiedNumerator, simplifiedDenominator);
	};//fim do método divideTwoRationals(int numerator_1, int denominator_1, int numerator_2, int denominator_2)
	
	public String toString()
	{
		return String.format("Fração irredutível: %d/%d", getNumerator(), getDenominator());
	};//fim do método toString()

	public String toStringFloat()
	{
		//Armazenando o numerador e denominador
		double numerator = getNumerator();
		double denominator = getDenominator();
		
		//Exibindo prompt na janela de comando para o usuário especificar a quantidade de casas após a vírgula
		Scanner input = new Scanner(System.in);
		System.out.printf("%s%n", "Quantas casas após a vírgula você deseja na exibição do resultado?");
		int specifier = input.nextInt();
		
		BigDecimal rationalResult = BigDecimal.valueOf(numerator / denominator).setScale(specifier, RoundingMode.HALF_EVEN);
		//Gerando a saída na janela de comando
		return String.format("The division between %.2f and %.2f is: %f", numerator, denominator, rationalResult);
		
	};//fim do método toStringFloat()

	//Métodos implementação
	
	private static int calculateMMC (int number1, int number2)
	{
		//O MMC pode ser calculado pela divisão do produto de dois números ( a * b) e o MDC(a, b)
		return (number1 * number2) / calculateMDC(number1, number2);
	};//fim do método calculateMMC(int number1, int number2)
	
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
		
};//fim da classe Rational
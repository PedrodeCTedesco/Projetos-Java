/** Classe de teste para a classe Rational 
 * @author pedro de castro tedesco
 * @link "Java: como programar" (Deitel e Deitel, 10ªed, cap. 8)
 * @since 24/01/2024
 * */
 
public class RationalTest
{
	public static void main (String[]args)
	{
		//Instâncias da classe
		Rational rational_1 = new Rational(3, 4);
		Rational rational_2 = new Rational(5, 6);
		System.out.printf("%s%n", rational_1);
		System.out.printf("Testing toStrinfFloat(): %s%n", rational_1.toStringFloat());
		
		System.out.printf("Testing addTwoRationals(): %s%n", Rational.addTwoRationals(3, 4, 5, 6));
		System.out.printf("Testing subtractTwoRationals(): %s%n", Rational.subtractTwoRationls(3, 4, 1, 6));
		System.out.printf("Testing productTwoRationals(): %s%n", Rational.productTwoRationals(23, 5, 123, 41));
		System.out.printf("Testing divdeTwoRationals(): %s%n", Rational.divideTwoRationals(8, 9, 4, 5));
	};//fim do método main
};//fim da classe RationalTest
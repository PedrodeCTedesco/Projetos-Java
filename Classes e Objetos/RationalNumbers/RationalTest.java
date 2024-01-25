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
		Rational rational_1 = new Rational(30, 60);
		System.out.printf("%s%n", rational_1);
		System.out.printf("Testing toStrinfFloat(): %s", rational_1.toStringFloat());
	};//fim do método main
};//fim da classe RationalTest
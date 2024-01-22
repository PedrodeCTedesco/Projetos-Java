/** Classe para demonstrar o funcionamento das importações static 
 * @author pedro de castro tedesco
 * @link "Java: como programar" (Deitel e Deitel, 10ª ed, cap. 8) */

/** Importação static de todos os campos e métodos de Math*/
import static java.lang.Math.*;

public class StaticImportTest
{
	public static void main (String[]args)
	{
		//Note que quando realizamos a importação static não precisamos invocar os campos e métodos com a nota: NomeDaClasse.campo ou método
		System.out.printf("sqrt(7530.0) = %.1f%n", sqrt(7530.0));
		System.out.printf("ceil(-182.2) = %.1f%n", ceil(-182.2));
		System.out.printf("E = %f%n", E);
		System.out.printf("PI = %f%n", PI);
	};//fim do método main
};//fim da classe StaticImportTest
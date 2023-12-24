/**Classe para testar o tipo Enum Book. 
 */

//Importando a classe EnumSet.
import java.util.EnumSet;

public class BookEnumTest
{
	public static void main(String[]args)
	{
		System.out.println("All books:");
		
		//Imprime todos os livros de enum Book
		//Note que aqui temos a impressão na janela de comando de todas as constantes enum
		//O método estático values() é gerado pelo compilador e retorna um array das constantes enum na ordem em que foram declaradas.
		for (Book book : Book.values())
		{
			//Repara que a chamada book retorna o identificador da constante enum
			System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getCopyrightYear());
		};//fim da instrução for aprimorado
		
		//Imprindo agora um conjunto das constantes enum (um determinado range).
		//Para isso utilizamos um método da classe EnumSet. Note que os dois parâmetros (o valor inicial e o valor final)
		//serão igualmente exibidos.
		System.out.printf("%nDiplay a range of enum constants:%n");
		
		for (Book book : EnumSet.range(Book.CHTP, Book.VBHTP))
		{
			System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getCopyrightYear());
		};//fim da instrução for aprimorado
	};//fim do método main
};//fim da classe BookEnumTest
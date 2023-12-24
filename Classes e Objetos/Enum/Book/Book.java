/**Classe do tipo enum para demonstrar o funcionamento, sintaxe e possibilidades deste tipo em Java. 
 * @author pedro de castro tedesco
 * @link "Java: como programar" (Deitel e Deitel, cap. 8)
 * @since 24/12/2023*/
 
//Note que a palavra reservada é 'enum' e não 'class'
public enum Book
{
	//As constantes Enum são declaradas primeiro.
	//Elas são implicitamente final e static
	//Todas são declaradas e separadas por vírgula. Elas possuem 2 argumentos por conta do construtor do Enum
	JHTP("Java How To Program", "2015"),
	CHTP("C How To Program", "2013"),
	IW3HTP("Internet & World Wide Web Hot To Program", "2012"),
	CPPHTP("C++ How To Program", "2014"),
	VBHTP("Visual Basic How To Program","2014"),
	CSHARPHTP("Visual C# How To Program", "2014");
	
	//CAMPOS. Os campos que são variáveis de instância
	private final String title;
	private final String copyrightYear;
	
	//CONSTRUTORES. Os construtores podem ser sobrecarregados. 
	//Note que são conhecidos como Construtor Enum
	//Não recebem modificador de visibilidade em seu cabeçalho, apenas identificador e lista de parâmetros
	Book (String title, String copyrightYear)
	{
		this.title = title;
		this.copyrightYear = copyrightYear;
	};//fim do construtor enum
	
	//MÉTODOS. Os métodos são métodos de consulta. Note que não podemos ter métodos modificadores, pois o objetivo
	//do tipo enum é criação de constantes.
	public String getTitle()
	{
		return title;
	};//fim do método getTitle();
	
	public String getCopyrightYear()
	{
		return copyrightYear;
	};//fim do método getCopyrightYear();
};//fim do enum Book
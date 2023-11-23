/**Classe de exercício da disciplina de Laboratório I da Unisinos (Análise e Desenvolvimento de Sistemas). É uma subclasse de Presente
 * @author Pedro de Castro Tedesco
 * @since 23/11/2023
 * */

public class Livro extends Presente
{
	/**CAMPOS. Todos são variáveis de instância
	 * -autor: String --> o autor do livro
	 * -editora: String --> a editora do livro
	 * */
	private String autor;
	private String editora;
	
	/**CONSTRUTORES
	 * +Livro(int codigo, String descricao, double valor, int escalaDeDesejo, String autor, String editora): Livro --> inicializa todos os campos
	 * @param int codigo --> superclasse
	 * @param String descricao --> superclasse
	 * @param double valor --> superclasse
	 * @param int escalaDeDesejo --> superclasse
	 * @param String autor
	 * @param String editora
	 * */
	public Livro (int codigo, String descricao, double valor, int escalaDeDesejo, String autor, String editora)
	{
		super(codigo, descricao, valor, escalaDeDesejo);
		this.autor = autor;
		this.editora = editora;
	};//fim do construtor
	
	/**MÉTODOS DE ACESSO
	 * +getAutor(): String --> retorna o autor do livro
	 * @return String
	 * 
	 * +getEditora(): String --> retorna a editora do livro
	 * @return String
	 * */
	public String getAutor()
	{
		return this.autor;
	};//fim do método getAutor()
	
	public String getEditora()
	{
		return this.editora;
	};//fim do método getEditora()
	
	/**MÉTODOS DE CONFIGURAÇÃO
	 * +setAutor(String autor): void --> altera o nome do autor do livro
	 * @param String;
	 * 
	 * +setEditora(String editora): void --> altera a editora do livro
	 * @param String;
	 * */
	public void setAutor(String autor)
	{
		this.autor = autor;
	};//fim do método setAutor(String autor)
	
	public void setEditora(String editora)
	{
		this.editora = editora;
	};//fim do método setEditora(String editora)
	
	/**MÉTODOS
	 * +toString(): String --> sobrescreve o método da superclasse e retorna uma string com as informações da classe
	 * @return String
	 * */
	public String toString()
	{
		return String.format("Autor: %s\nEditora: %s", this.getAutor(), this.getEditora());
	};//fim do método toString()
	
	
};//fim da classe Livro
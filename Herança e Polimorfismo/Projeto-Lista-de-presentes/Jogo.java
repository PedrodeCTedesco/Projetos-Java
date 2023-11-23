/**Classe de exercício da disciplina de Laboratório I da Unisinos (Análise e Desenvolvimento de Sistemas). É uma subclasse de Presente
 * @author Pedro de Castro Tedesco
 * @since 23/11/2023
 * */

public class Jogo extends Presente
{
	/**CAMPOS. Todos são variáveis de instância
	 * -plataforma: String --> a plataforma que lança o jogo
	 * -genero: String --> o gênero do jogo
	 * */
	private String plataforma;
	private String genero;
	
	/**CONSTRUTORES
	 * +Jogo(int codigo, String descricao, double valor, int escalaDeDesejo, String plataforma, String genero): Jogo --> inicializa todos os campos
	 * @param int codigo --> superclasse;
	 * @param String descricao --> superclasse;
	 * @param double valor --> superclasse;
	 * @param int escalaDeDesejo --> superclasse;
	 * @param String plataforma;
	 * @param String genero;
	 * */
	public Jogo (int codigo, String descricao, double valor, int escalaDeDesejo, String plataforma, String genero)
	{
		super(codigo, descricao, valor, escalaDeDesejo);
		this.plataforma = plataforma;
		this.genero = genero;
	};//fim do construtor
	
	/**MÉTODOS DE ACESSO
	 * +getPlataforma(): String --> retorna a plataforma do jogo
	 * @return String
	 * 
	 * +getGenero(): String --> retorna o gênero do jogo
	 * @return String
	 * */
	public String getPlataforma()
	{
		return this.plataforma;
	};//fim do método getPlataforma()
	
	public String getGenero()
	{
		return this.genero;
	};//fim do método getGenero()
	
	/**MÉTODOS DE CONFIGURAÇÃO
	 * +setPlataforma(String plataforma): void --> altera a plataforma do jogo
	 * @param String
	 * 
	 * +setGenero(String genero): void --> altera o gênero do jogo
	 * @param String
	 * */
	public void setPlataforma(String plataforma)
	{
		this.plataforma = plataforma;
	};//fim do método setPlataforma(String plataforma)
	
	public void setGenero(String genero)
	{
		this.genero = genero;
	};//fim do método setGenero(String genero)
	
	/**MÉTODOS
	 * +toString(): String --> sobrescreve o método da superclasse e retorna uma string com as informações da instância
	 * @return String
	 * */
	public String toString()
	{
		return String.format("Plataforma: %s\nGênero: %s", this.getPlataforma(), this.getGenero());
	};//fim do método toString()
};//fim da classe Jogo
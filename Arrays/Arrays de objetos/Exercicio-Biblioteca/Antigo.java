/**Classe de exercício de fixação de array de objetos
 * @link
 * @since 14/11/2023
 * */

/**Essa classe é um tipo de Livro*/

public class Antigo extends Livro
{
	/**CAMPOS. Todos são variáveis de instância
	 * -edicao: int --> representa o número de edição do livro
	 * */
	private int edicao;
	
	/**CONSTRUTORES.
	 * Este construtor inicializa todos os campos, inclusive da superclasse
	 * +Antigo(String titulo, String autor, double preco, String ano, int edicao): Antigo
	 * @param String titulo --> superclasse;
	 * @param String auto --> superclasse;
	 * @param double preco --> superclasse;
	 * @param int ano --> superclasse;
	 * @param int edicao
	 * 
	 * Este construtor inicializa apenas o campo da classe
	 * +Antigo(int edicao): Antigo
	 * @param int edicao;
	 * */
	public Antigo (String titulo, String autor, double preco, int ano, int edicao)
	{
		super(titulo, autor, preco, ano);
		this.edicao = edicao;
	};//fim do construtor
	
	public Antigo (int edicao)
	{
		this.edicao = edicao;
	}

	/**MÉTODOS DE ACESSO
	 * +getEdicao(): int --> retorna o número de edição do livro
	 * @return int;
	 * */
	public int getEdicao()
	{
		System.out.printf("A edição de %s é %d\n", super.getTitulo(), this.edicao);
		return this.edicao;
	};//fim do método getEdicao();
	
	/**MÉTODOS DE CONFIGURAÇÃO
	 * +setEdicao(int edicao): void --> altera o número de edição do livro
	 * @param int edicao;
	 * */
	public void setEdicao (int edicao)
	{
		this.edicao = edicao;
	};//fim do método setEdicao(int edicao);
	
	/**MÉTODOS
	 * +toString(): String --> sobrescreve o método da superclasse
	 * @return String;
	 * */
	public String toString()
	{
		return String.format("Informações adicionais sobre o livro:\nA edição inicial de %s é de %d\n", super.getTitulo(), this.getEdicao());
	};//fim do método toString();
};//fim da classe Antigo
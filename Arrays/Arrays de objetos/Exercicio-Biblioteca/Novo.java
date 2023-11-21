/**Classe de exercício de fixação de array de objetos
 * @link
 * @since 14/11/2023
 * */

/**Essa classe é um tipo de Livro*/

public class Novo extends Livro
{
	/**CAMPOS. Todos são variáveis de instância
	 * -valorDesconto: double --> o valor de desconto do livro
	 * */
	private double valorDesconto;
	
	/**CONSTRUTORES
	 * Este construtor inicializa todos os campos
	 * +Novo(String titulo, String autor, double preco, String ano, double valorDesconto): Novo
	 * @param String titulo --> superclasse;
	 * @param String autor --> superclasse;
	 * @param double preco --> superclasse;
	 * @param int ano --> superclasse
	 * @param double valorDesconto
	 * */
	public Novo (String titulo, String autor, double preco, int ano, double valorDesconto)
	{
		super(titulo, autor, preco, ano);
		this.valorDesconto = valorDesconto;
	};//fim do construtor
	
	public Novo (double valorDesconto)
	{
		this.valorDesconto = valorDesconto;
	}
	
	/**MÉTODOS DE ACESSO
	 * +getValorDesconto(): double --> retorna o valor do desconto
	 * @return double;
	 * */
	public double getValorDesconto()
	{
		return this.valorDesconto;
	};//fim do método getValorDesconto()
	
	/**MÉTODOS DE CONFIGURAÇÃO
	 * +setValorDesconto(double valorDesconto): void --> altera o valor do desconto do livro
	 * @param double;
	 * */
	public void setValorDesconto(double valorDesconto)
	{
		this.valorDesconto = valorDesconto;
	};//fim do método setValorDesconto(double valorDesconto);
	
	/**MÉTODOS
	 * +toString(): String --> sobrescreve o método da superclasse
	 * @return String
	 * */
	public String toString()
	{
		return String.format("O valor de desconto do livro %s é %.2f\n", super.getTitulo(), this.getValorDesconto());
	};//fim do método toString();
};//fim da classe Novo
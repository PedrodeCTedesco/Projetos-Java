/**Classe de exercício para a disciplina de Laboratório I da semana 13 e 14 
 * sobre arrays de objetos.
 * @author Pedro de Castro Tedesco
 * @since 20/11/2023
 * */

public class Churros
{
	/**CAMPOS. Todos são variáveis de instância.
	 * -sabor: String --> o sabor do churros
	 * -preco: double --> o preço do churros em reais
	 * */
	private String sabor;
	private double preco;
	
	/**CONSTRUTORES
	 * Este construtor inicializa todos os campos
	 * +Churros(String sabor, double preco): Churros
	 * @param String sabor;
	 * @param double preco;
	 * 
	 * Este construtor inicializa apenas o campo 'sabor'
	 * +Churros(String sabor): Churros
	 * @param String sabor;
	 * 
	 * Este construtor inicializa apenas o valor do churros
	 * +Churros(double preco): Churros
	 * @param double preco;
	 * */
	public Churros (String sabor, double preco)
	{
		this.sabor = sabor;
		this.preco = preco;
	};//fim do construtor
	
	public Churros (String sabor)
	{
		this.sabor = sabor;
		this.preco = 0.0;
	};//fim do construtor
	
	public Churros (double preco)
	{
		this.preco = preco;
		this.sabor = "";
	};//fim do construtor
	
	/**MÉTODOS DE ACESSO
	 * +getSabor(): String --> retorna o sabor do churros.
	 * @return String
	 * 
	 * +getPreco(): double --> retorna o preço do churros.
	 * @return double
	 * */
	public String getSabor()
	{
		return this.sabor;
	};//fim do método getSabor();
	
	public double getPreco()
	{
		return this.preco;
	};//fim do método getPreco();
	
	/**MÉTODOS DE CONFIGURAÇÃO
	 * +setSabor(String sabor): void --> altera o sabor do churros
	 * @param String;
	 * 
	 * +setPreco(double preco): void --> altera o valor do preço do churros
	 * @param double;
	 * */
	public void setSabor(String sabor)
	{
		this.sabor = sabor;
	};//fim do método setSabor(String sabor)
	
	public void setPreco(double preco)
	{
		this.preco = preco;
	};//fim do método setPreco(double preco);
	
	/**MÉTODOS
	 * +toString(): String --> sobrescreve o método da superclasse
	 * @return String
	 * */
	public String toString()
	{
		return String.format("Sabor do churros: %s\nPreço do churros: %.2f", this.getSabor(), this.getPreco());
	};//fim do método toString();
};//fim da classe Churros
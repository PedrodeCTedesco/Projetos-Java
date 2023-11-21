/**
 * Classe que pertence ao exercício 4 do estudo dirigido de herança e polimorfismo
 * da disciplina de Laboratório I
 * @author Pedro de Castro Tedesco
 * @since 24/10/2023
 */

/**
 * A classe representa um Produto
 */
public class Produto 
{
	/**Campos
	 * -nome:String -> uma string que representa o nome do produto;
	 * -descricao:String -> uma string que representa uma descrição do produto;
	 * -valor:Double -> o valor do produto*/
	private String nome, descricao;
	private Double valor;
	
	/**Construtores
	 * +Produto(String nome, String descricao, Double valor) -> Este construtor recebe todos os parâmetros para inicializar os campos
	 * @param String nome;
	 * @param String descricao;
	 * @param Double valor*/
	public Produto (String nome, String descricao, Double valor)
	{
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	};//Fim do construtor
	
	/**Métodos de acesso
	 * +getNome():String -> retorna o valor do campo 'nome';
	 * @return String nome;
	 * 
	 * +getDescricao():String -> retorna o valor do campo 'descricao'
	 * @return String descricao;
	 * 
	 * +getValor():Double -> retorna o valor do campo 'valor'
	 * @return Double valor;
	 * */
	public String getNome()
	{
		return this.nome;
	};//Fim do método getNome()
	
	public String getDescricao()
	{
		return this.descricao;
	};//Fim do método getDescricao();
	
	public Double getValor()
	{
		return this.valor;
	};//Fim do método getValor()
	
	/**Métodos de configuração
	 * +setNome(String nome) -> altera o estado do campo 'nome'
	 * @param String nome;
	 * 
	 * +setDescricao(String descricao) -> altera o estado do campo 'descricao'
	 * @param String descricao;
	 * 
	 * +setValor(Double valor) ->altera o estdo do campo 'valor'
	 * @param Double valor;
	 * */
	public void setNome(String nome)
	{
		this.nome = nome;
	};//Fim do método setNome(Sring nome)
	
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	};//Fim do método setDescricao(String descricao)
	
	public void setValor (Double valor)
	{
		this.valor = valor;
	};//Fim do método setValor(Double valor);
	
	/**Métodos
	 * +toString():String -> sobrescreve o método da superclasse
	 * @return String -> retorna uma string com as informações da instância
	 */
	public String toString()
	{
		return String.format("Nome do produto: %s\nDescrição do produto: %s\nValor do produto: %.2f", this.getNome(), this.getDescricao(), this.getValor());
	};//Fim do método toString();
	
};//Fim da classe Produto

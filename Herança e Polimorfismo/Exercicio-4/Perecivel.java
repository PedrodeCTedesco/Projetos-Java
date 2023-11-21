/**Esta classe pertence ao exercício 4 do estudo dirigido de herança e polimorfismo
 * da disciplina de Laboratório I. 
 * @author pedro de castro tedesco
 * @since 24/10/2023
 */

/**
 * A classe representa um produto perecível e é uma subclasse de Produto
 */
public class Perecivel extends Produto 
{
	/**Campos
	 * -dataDeValidade: Data -> a data de validade do produto
	 * */
	private Data dataDeValidade;
	
	/**Construtores
	 * +Perecivel(String nome, String Descricao, Double valor, Data dataDeValidade) -> este construtor inicializa todos os campos da classe e da superclasse
	 * @param String nome; -> campo da superclasse
	 * @param String descricao; -> campo da superclasse
	 * @param Double valor; -> campo da superclasse
	 * @param Data dataDeValidade*/
	public Perecivel (String nome, String descricao, Double valor, Data dataDeValidade)
	{
		super(nome, descricao, valor);
		this.dataDeValidade = dataDeValidade;
	};//Fim do construtor
	
	/**Métodos de acesso
	 * +getDataDeValidade(): Data -> retorna o valor do campo 'dataDeValidade'
	 * @return Data dataDeValidade -> a data de validade do produto
	 * */
	public Data getDataDeValidade()
	{
		return this.dataDeValidade;
	};//Fim do método getDataDeValidade()
	
	/**Métodos de configuração
	 * +setDataDeValidade(Data dataDeValidade) -> altera o estado do campo 'dataDeValidade'
	 * @param Data dataDeValidade;
	 * */
	public void setDataDeValidade (Data dataDeValidade)
	{
		this.dataDeValidade = dataDeValidade;
	};//Fim do método setDataDeValidade(Data dataDeValidade);
	
	/**Métodos
	 * +toString():String -> sobrescreve o método da superclasse
	 * @return String -> uma string com as informações da instância.*/
	public String toString()
	{
		String info = "Data de validade do produto: " + this.getDataDeValidade();
		return info;
	};//Fim do método toString();
	
};//Fim da classe Perecivel

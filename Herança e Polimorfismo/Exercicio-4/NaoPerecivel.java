/**Classe que pertence ao exercício 4 do estudo dirigido de herança e polimorfismo
 * da disciplina de laboratório I
 * @author pedro
 * @since 24/10/2023
 */

/**
 * Esta classe é uma subclasse de Produto
 */
public class NaoPerecivel extends Produto
{
	/**Campos
	 *-dataDeFabricacao: Data -> representa a data de fabricação do produto */
	private Data dataDeFabricacao;
	
	/**Construtores
	 * +NaoPerecivel(String nome, String descricao, Double valor, Data dataDeFabricacao) -> este construtor
	 * inicializa todos os campos
	 * @param String nome -> campo da superclasse;
	 * @param String descricao -> campo da superclasse;
	 * @param Double valor -> campos da superclasse
	 * @param Data dataDeFabricacao; 
	 * */
	public NaoPerecivel (String nome, String descricao, Double valor, Data dataDeFabricacao)
	{
		super(nome, descricao, valor);
		this.dataDeFabricacao = dataDeFabricacao;
	};//Fim do construtor]
	
	/**Métodos de acesso
	 * +getDataDeFabricacao(): Data -> retorna a data de fabricação do produto
	 * @return Data dataDeFabricacao;
	 * */
	public Data getDataDeFabricacao ()
	{
		return this.dataDeFabricacao;
	};//Fim do método getDataDeFabricacao();
	
	/**Métodos de configuração
	 * +setDataDeFabricacao(Data data) -> este método altera o estado do campo 'dataDeFabricacao';
	 * @param Data data -> a nova data de fabricação do produto;
	 * */
	public void setDataDeFabricacao(Data data)
	{
		this.dataDeFabricacao = data;
	};//Fim do método setDataDeFabricacao(Data data);
	
	/**Métodos
	 * +toString(): String -> sobrescreve o método da superclasse
	 * @return String -> uma string com as informações da instância
	 * */
	public String toString()
	{
		Data dataInfo = this.getDataDeFabricacao();
		String info = "Data de fabricação: " + dataInfo;
		return info;
	};//Fim do método toString()
	
};//Fim da classe NaoPerecivel

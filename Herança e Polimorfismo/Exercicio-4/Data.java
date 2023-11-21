/**Esta classe pertence ao exercício 4 de Herança e Polimorfismo da disciplina 
* de laboratório 1
* @author Pedro de Castro Tedesco
* @since 24/10/2023 */

public class Data
{
	/**Campos
	 * Todos os campos são variáveis de instância
	 * -dia:Integer -> representa o dia;
	 * -mes: Integer -> representa o mês;
	 * -ano:Integer -> representa o ano;
	 *  */
	private Integer dia, mes, ano;
	
	/**Construtores
	 * +Data(Integer dia, Integer mes, Integer ano) -> este construtor inicializa todos os campos*/
	public Data (Integer dia, Integer mes, Integer ano)
	{
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	};//Fim do construtor
	
	/**Métodos de acesso
	 *+getDia(): Integer -> retorna o valor do campo 'dia' 
	 *@return Integer dia;
	 *
	 *+getMes(): Integer -> retorna o valor do campo 'mes'
	 *@return Integer mes;
	 *
	 *+getAno():Integer -> retorna o valor do campo 'ano'
	 *@return Integer ano;*/
	public Integer getDia()
	{
		return this.dia;
	};//fim do método getDia();
	
	public Integer getMes()
	{
		return this.mes;
	};//Fim do método getMes();
	
	public Integer getAno()
	{
		return this.ano;
	};//Fim do método getAno();
	
	/**Métodos de condiguração
	 * -setDia(Integer dia) -> altera o estado do campo dia
	 * @param Integer dia -> o novo valor do campo;
	 * 
	 * -setMes(Integer mes) -> altera o estado do campo 'mes'
	 * @param Integer mes -> o novo valor do campo;
	 * 
	 * -setAno(Integer ano) -> altera o estado do campo 'ano'
	 * @param Integer ano -> o novo valor do campo*/
	public void setDia (Integer dia)
	{
		this.dia = dia;
	};//Fim do método setDia(Integer dia);
	
	public void setMes(Integer mes)
	{
		this.mes = mes;
	};//Fim do método setMes(Integer mes);
	
	public void setAno(Integer ano)
	{
		this.ano = ano;
	};//Fim do método setAno(Integer ano)
	
	/**Métodos
	 * +toString(): String -> sobrescreve o método da superclasse;
	 * @return String -> uma string com as informações da instância
	 * */
	public String toString()
	{
		return String.format("%d/%d/%d", this.getDia(), this.getMes(), this.getAno());
	};//Fim do método toString();
	
};//Fim da classe Data

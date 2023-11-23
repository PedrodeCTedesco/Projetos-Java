/**Classe de exercício da disciplina de Laboratório I da Unisinos (Análise e Desenvolvimento de Sistemas)
 * @author Pedro de Castro Tedesco
 * @since 22/11/2023
 * */

public class Presente
{
	/**CAMPOS. Todos são variáveis de instância
	 * -codigo: int --> representa o código do presente
	 * -descricao: String --> uma descrição do presente
	 * -valor: double --> representa o valor do presente
	 * -escalaDeDesejo: int --> uma escala de 1 a 3 que representa o nível de apreço do cliente com o presente
	 * */
	private int codigo;
	private String descricao;
	private double valor;
	private int escalaDeDesejo;
	
	/**CONSTRUTORES
	 * +Presente(int codigo, String descricao, double valor, int escalaDeDesejo): Presente --> inicializa todos os campos
	 * @param int;
	 * @param String;
	 * @param double;
	 * @param int;
	 * */
	public Presente (int codigo, String descricao, double valor, int escalaDeDesejo)
	{
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		
		switch (this.escalaDeDesejo)
		{
			case 1:
				this.escalaDeDesejo = escalaDeDesejo;
			break;
			
			case 2:
				this.escalaDeDesejo = escalaDeDesejo;
			break;
			
			case 3:
				this.escalaDeDesejo = escalaDeDesejo;
			break;
			
			default:
				String escalaDeDesejo_1 = "Não vivo sem este presente";
				String escalaDeDesejo_2 = "Quero demais este presente";
				String escalaDeDesejo_3 = "Este presente é legal";
				
				System.out.print("Valor inválido para a escala de desejo!\nPor favor, insira uma opção válida.\n");
				System.out.printf("1 - %s\n2 - %s\n 3 - %s\n", escalaDeDesejo_1, escalaDeDesejo_2, escalaDeDesejo_3);
		};//fim da sentença de seleção múltipla
	};//fim do construtor
	
	/**MÉTODOS DE ACESSO
	 * +getCodigo(): int --> retorna o código do presente
	 * @return int
	 * 
	 * +getDescricao(): String --> retorna a descrição do presente
	 * @return String
	 * 
	 * +getValor(): double --> retorna o valor do presente
	 * @return double
	 * 
	 * +getEscalaDeDesejo(): String --> retorna a mensagem associada a escala de desejo
	 * @return String
	 * */
	public int getCodigo()
	{
		return this.codigo;
	};//fim do método getCodigo()
	
	public String getDescricao()
	{
		return this.descricao;
	};//fim do método getDescricao()
	
	public double getValor()
	{
		return this.valor;
	};//fim do método getValor();
	
	public String getEscalaDeDesejo()
	{
		//Verificando qual o valor do campo escalaDeDesejo
		if (this.escalaDeDesejo == 1)
		{
			String escalaDeDesejo_1 = "Não vivo sem este presente";
			return escalaDeDesejo_1;
		} else if (this.escalaDeDesejo == 2)
		{
			String escalaDeDesejo_2 = "Quero demais este presente";
			return escalaDeDesejo_2;
		} else
		{
			String escalaDeDesejo_3 = "Este presente é legal";
			return escalaDeDesejo_3;
		}//fim da sentença de seleção condicional composta
	
	};//fim do método getEscalaDeDesejo()
	
	
	/**MÉTODOS DE CONFIGURAÇÃO
	 * +setCodigo(int codigo): void --> altera o código do presente
	 * @param int codigo;
	 * 
	 * +setDescricao(String descricao): void --> altera a descrição do presente
	 * @param String descricao;
	 * 
	 * +setValor(double valor): void --> altera o valor do presente
	 * @param double valor;
	 * 
	 * +setEscalaDeDesejo(int escalaDeDesejo): void --> altera a opção da escala de desejo
	 * @param int escalaDeDesejo;
	 * */
	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	};//fim do método setCodigo(int codigo);
	
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	};//fim do método setDescricao(String descricao);
	
	public void setValor(double valor)
	{
		this.valor = valor;
	};//fim do método setValor(double valor)
	
	public void setEscalaDeDesejo (int escalaDeDesejo)
	{
		
		//Verificar se o valor passado está entre o range 1 a 3
		switch (escalaDeDesejo)
		{
			case 1:	 
				this.escalaDeDesejo = escalaDeDesejo;
			break;
			
			case 2: 
				this.escalaDeDesejo = escalaDeDesejo;
			break;
			
			case 3:
				this.escalaDeDesejo = escalaDeDesejo;
			break;
			default:
				System.out.print("Valor inválido. Por favor, insira valores 1, ou 2 ou 3");
		};//fim da sentença de seleção múltipla
	};//fim do método setEscalaDeDesejo (int escalaDeDesejo)

	/**MÉTODOS
	 * +toString(): String --> retorna todos os dados da instância
	 * @return String
	 * */
	public String toString()
	{
		return String.format("Código: %d\nDescrição: %s\nValor do presente: %.2f\nEscala de desejo: %s", this.getCodigo(), this.getDescricao(), this.getValor(), this.getEscalaDeDesejo());
	};//fim do método toString();
	
};//fim da classe Presente
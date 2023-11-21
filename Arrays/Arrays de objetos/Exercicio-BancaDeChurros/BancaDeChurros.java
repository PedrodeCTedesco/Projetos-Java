/**Classe de uma banca de churros pertencente ao exercício da disciplina
 * de laboratório I sobre a semana 13 e 14 de arrays de objetos
 * @author Pedro de Castro Tedesco
 * @since 20/11/2023
 * */

public class BancaDeChurros
{
	/**CAMPOS. Todos são variáveis de instância
	 * -churros[]: Churros --> um array de objetos Churros
	 * */
	private Churros[] churros;
	
	/**CONSTRUTORES
	 * Este construtor inicializa o array de churros preenchido.
	 * +BancaDeChurros(): Churros[]
	 * 
	 * Este construor recebe por parâmetro o tamanho do array de churros e o inicializa.
	 * +BancaDeChurrs (int quantMax): Churros[]
	 * @param int quantMax --> a quantidade máxima de churros.
	 * */
	
	public BancaDeChurros ()
	{
		churros = new Churros [10];
	};//fim do construtor
	
	public BancaDeChurros (int quantMax)
	{
		this.churros = new Churros[quantMax];
	};//fim do construtor
	
	/**MÉTODOS
	 * +estoqueChurros(String sabor): int --> recebe uma string por parâmetro oficial e retorna a quantidade de churro desse sabor.
	 * @param String;
	 * @return int;
	 * 
	 * +insereChurro(Churro churro): boolean --> recebe uma instância de churros por parâmetro oficial e o insere na primeira posição livre do array.
	 * @param Churro;
	 * @return boolean
	 * 
	 * +valorTotal(): double --> retorna o valor total dos churros no array.
	 * @return double;
	 * 
	 * +vendeChurros(String sabor): boolean --> o método recebe como argumento uma String cujo valor representa um sabor do churros e o vende.
	 * Nesse processo, ao vendê-lo o churros é retirado do array e temos impresso na janela de comando o valor da compra.
	 * @param String
	 * @boolean
	 * 
	 * +imprimeChurros(): void --> imprime as informações de todos os churros do array na janela de comando
	 * 
	 * +lePedidos(String nome, String sabor, int quantidade): boolean --> o método recebe uma String (nome) que representa o nome
	 * da pessoa; uma String sabor que representa o sabor do churros que ela quer comprar. E o int quantidade que indica a quantidade
	 * de churros que a pessoa deseja comprar. O método tenta realizar a venda e informa se o processo foi ou não foi bem sucedido.
	 * @param String nome;
	 * @param String sabor;
	 * @param int quantidade;
	 * @return boolean
	 * 
	 * +quantosChurrosTem(): int --> retorna a quantidade de posições não-nulas do array de objetos
	 * @return int;
	 * */
	
	public int estoqueChurros (String sabor)
	{
		/**Variáveis de apoio*/
		int count = 0;
		
		//Sentença de iteração para identificar a quantidade de churros do sabor solicitado.
		for (int i = 0; i < this.churros.length; i += 1)
		{
			try 
			{
				if (this.churros[i] != null && this.churros[i].getSabor().equalsIgnoreCase(sabor))
				{
					count += 1;
				};//fim da sentença de seleção simples
			} catch (Exception NullPointerException)
			{
				System.out.printf("Sabor %s indisponível no momento.\n", sabor);
			};//fim do tratamento de exceções
		};//fim da sentença de iteração
		return count;
	};//fim do método estoqueChurros (String sabor);
	
	public boolean insereChurro (Churros churro)
	{
		//Verificando qual a primeiro posição livre do array. Será uma posição cujo valor é null
		for (int i = 0; i < this.churros.length; i += 1)
		{
			if (this.churros[i] == null)
			{
				this.churros[i] = churro;
				return true;
			};//fim da sentença de seleção simples
		};//fim da sentença de iteração
		return false;
	};//fim do método insereChurro(Churros churro);

	public double valorTotal()
	{
		/**Variáveis de apoio*/
		double soma = 0;
		
		//Sentença de iteração para somar o preço de todos os churros do array
		for (int i = 0; i < this.churros.length; i += 1)
		{
			soma += this.churros[i].getPreco();
		};//fim da sentença de iteração
		return soma;
	};//fim do método valorTotal();

	public boolean vendeChurros(String sabor)
	{	
		
		System.out.printf("Você deseja comprar um churros sabor %s\n", sabor);
		
		//Retira o churros vendido do array de objetos
		for (int i = 0; i < this.churros.length; i += 1)
		{
			try 
			{
				if (this.churros[i] != null && this.churros[i].getSabor().equalsIgnoreCase(sabor))
				{
					System.out.printf("Vendido churros sabor %s. Valor da compra %.2f\n", this.churros[i].getSabor(), this.churros[i].getPreco());
					this.churros[i] = null;
					return true;
				};//fim da sentença de seleção simples
				
			} catch (Exception NullPointerException)
			{
				System.out.print("Este churros já foi vendido!\n");
			};//fim do tratamento de exceções
		};//fim da sentença de iteração
		return false;
	};//fim do método vendeChurros(String sabor);
	

	public void imprimeChurros()
	{
		//Impressão de todos os churros da banca
		for (int i = 0; i < this.churros.length; i += 1)
		{
			try 
			{
				System.out.println(this.churros[i]);
				
			} catch (Exception NullPointerException)
			{
				System.out.printf("O churros na posição %d já foi vendido!", i);
			};//fim do tratamento de exceções
		};//fim da sentença de iteração
	};//fim do método imprimeChurros();
	

	public boolean lePedidos (String nome, String sabor, int quantidade)
	{
		/**Variáveis de apoio*/
		int quantosChurrosHa = this.estoqueChurros(sabor);
		
		//Etapa 1: quantos churros do sabor desejado estão disponíveis
		this.estoqueChurros(sabor);
		
		if (quantosChurrosHa == 0)
		{
			return false;
		};//fim da sentença de seleção simples
		
		//Etapa 2: Havendo churros, quantos estão disponíveis e quem quer comprá-los
		System.out.printf("%s deseja comprar %d churros de %s\n", nome, quantidade, sabor);
		
		//Verificando a venda do churros
		while (quantidade > 0)
		{
			this.vendeChurros(sabor);
			quantidade -= 1;
		};//fim da sentença de iteração
		return true;
	};//fim do método lePedidos(String nome, String sabor, int quantidade);
	
	public int quantosChurrosTem ()
	{
		//Variáveis de apoio
		int countChurrosOk = 0;
		int countChurrosNotOk = 0;
		
		//Iterando pelo array de objetos para verificar quantas posiçõe nulas e não nulas existem
		for (int i = 0; i < this.churros.length; i += 1)
		{
			if (this.churros[i] == null)
			{
				countChurrosNotOk += 1;
			} else
			{
				countChurrosOk += 1;
			}
		};//fim da sentença de iteração
		return countChurrosOk;
	};//fim do método quantosChurrosTem();
	
};//fim da classe BancaDeChurros
 
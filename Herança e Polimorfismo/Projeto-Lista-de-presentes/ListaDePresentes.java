/**Classe de exercício da disciplina de Laboratório I da Unisinos (Análise e Desenvolvimento de Sistemas). 
 * @author Pedro de Castro Tedesco
 * @since 23/11/2023
 * */


public class ListaDePresentes
{
	/**CAMPOS. Todos são variáveis de instância
	 * -listaDePresentes: Presente[] --> um array de objetos do tipo Presente
	 * -contador: int --> contador de presentes
	 * */
	private Presente[] listaDePresentes;
	private int contador;
	
	/**CONSTRUTOR
	 * +ListaDePresentes(int quantMax): Presente[] listaDePresentes --> recebe por parâmetro oficial o tamanho do array de objetos e o inicializa
	 * @param int quantMax --> o tamanho do array de objetos Presente
	 * */
	public ListaDePresentes(int quantMax)
	{
		listaDePresentes = new Presente[quantMax];
	};//fim do construtor
	
	/**MÉTODOS
	 * +adicionaPresente(Presente presente): boolean --> este método adiciona um presente na lista de presentes.
	 * @param Presente;
	 * @return boolean --> se 'true' o presente foi inserido. Se 'false' não foi inserido.
	 * 
	 * +visualizaPresentes(): void --> retorna na janela de comando as informações de todos os presentes no array de objetos de presentes
	 * 
	 * +visualizaPresentesFaixaDeValor(double valor1, double valor2): Presente --> o método percorre o array de objetos de presentes e retorna
	 * todos os presentes que estiverem dentro da faixa de valor.
	 * @param double valor1 --> o valor mínimo do presente
	 * @param double valor2 -->  o valor máximo do presente
	 * @return Presente --> os presentes dentro da faixa de valores
	 * 
	 * +pesquisaPresente(String descricao): Presente --> o método recebe uma String por parâmetro oficial e percorre o array de objetos para 
	 * retornar o objeto que possui a descricação. 
	 * @param String;
	 * @return Presente
	 * */
	public boolean adicionaPresente(Presente presente)
	{
		//Verifica se há uma posição livre no array de objetos
		for (int i = 0; i < this.listaDePresentes.length; i += 1)
		{
			if (this.listaDePresentes[i] == null)
			{
				this.listaDePresentes[i] = presente;
				return true;
			}//fim da sentença de seleção simples
		};//fim da sentença de iteração
		return false;
	};//fim do método adicionaPresente(Presente presente);
	
	public void visualizaPresentes()
	{
		//Itera por todo o array de objetos e retorna as informações de cada um deles
		for (Presente p : this.listaDePresentes)
		{
			p.toString();
		};//fim da sentença de iteração (for aprimorado)
	};//fim do método visualizaPresentes()
	
	public void visualizaPresentesFaixaDeValor(double valor1, double valor2)
	{	
		
		Presente[] presentesFaixaDeValor;
		int count = 0;
		
		//Etapa 1: verificar se valor1 < valor2
		try
		{
			if (valor1 < valor2)
			{
				System.out.printf("Valor mínimo: %.2f\nValor máximo: %.2f", valor1, valor2);
			}
		} catch (Exception valorInvalido)
		{
			valorInvalido = new Exception ("O primeiro valor deve ser menor do que o segundo valor!");
			System.out.print(valorInvalido);
		};//fim do tratamento de exceções
		
		//Etapa 2: identificar os presentes com essa faixa de preço
		for (Presente p : this.listaDePresentes)
		{
			if (p.getValor() > valor1 && p.getValor() < valor2)
			{
				System.out.print(p);
			}//fim da sentença de seleção simples
		};//fim da sentença de iteração (for aprimorado)
	};//fim do método visualizaPresentesFaixaDeValor(double valor1, double valor2)

	public Presente pesquisaPresente(String descricao)
	{
		//Variáveis de apoio
		Presente naoExistePresente = null;
		int count = 0;
		//Percorrendo o array
		for (Presente p : this.listaDePresentes)
		{
			if (p != null && p.getDescricao().contains(descricao))
			{
				count += 1;
				return p;
			};//fim da sentença de seleção simples
		};//fim da sentença de iteração (for aprimorado)
		return naoExistePresente;
	};//fim do método pesquisaPresente(String descricao)
	
};//fim da classe ListaDePresentes
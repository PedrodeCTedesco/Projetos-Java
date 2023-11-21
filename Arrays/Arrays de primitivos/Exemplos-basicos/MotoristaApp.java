/**Classe que pertence a aula sobre Array Unidimensional da disciplina de 
 * laboratório I.
 * @author professor;
 * @since 24/10/2023;
 * */

/**Essa classe servirá de exemplo de utilização de array. 
 * */
public class MotoristaApp 
{
	/**Campos
	 * Todos os campos são variáveis de instância.
	 * -nome:String -> o nome do motorista;
	 * -avaliacoes: double -> o valor das avaliações. O tipo é array que armazena valores primitivos do tipo double;
	 * */
	private String nome;
	private double[] avaliacoes;
	
	/**Construtores
	 * +MotoristaApp(String nome, Integer quantMaxAvaliacoes)-> o construtor inicializa uma instância
	 * da classe definindo o tamanho do array.
	 * @param String nome -> o nome do motorista;
	 * @param Integer quantMaxAvaliacoes -> a quantidade máxima de avaliações que um motorista
	 * pode receber. Esse valor será utilizado para instanciar o array definindo a quantidade de
	 * posições que a variável 'avaliacoes' poderá conter.
	 * */
	public MotoristaApp (String nome, Integer quantMaxAvaliacoes)
	{
		this.nome = nome;
		this.avaliacoes = new double[quantMaxAvaliacoes];
		/**A sentença de iteração garantirá que quando o array for inicializado
		 * todas as posições estejam com o valor -1 indicando que nenhuma nota
		 * válida foi inserida*/
		for (Integer i = 0; i < avaliacoes.length; i++)
		{
			avaliacoes[i] = -1;
		};//Fim do laço for
	};//Fim do construtor
	
	/**Métodos de acesso
	 * +getNome():String -> retorna o valor do campo 'nome';
	 * @return String nome;
	 * 
	 * +getAvaliacoes(): double[] avaliacoes -> retorna um array de valores primitivos do tipo double contendo
	 * os valores das avaliações do motorista.
	 * @return double[] avaliacoes;
	 * */
	public String getNome()
	{
		return this.nome = nome;
	};//Fim do método getNome();
	
	public double[] getAvaliacoes()
	{
		return this.avaliacoes;
	};//Fim do método getAvaliacoes();
	
	/**Métodos de configuração
	 * +setNome(String nome) -> altera o estado do campo 'nome' da instância;
	 * @param String nome -> o novo valor do campo;
	 * 
	 * +setAvaliacoes(double[] avaliacoes) -> altera o estado do campo 'avaliacoes' da instância;
	 * @param double[]avaliacoes -> o array de valores primitivos do tipo double;
	 * */
	public void setNome(String nome)
	{
		this.nome = nome;
	};//Fim do método setNome(String nome);
	
	public void setAvaliacoes (double[] avaliacoes)
	{
		this.avaliacoes = avaliacoes;
	};//Fim do método setAvaliacoes(double[]avaliacoes);
	
	/**Métodos
	 * +insereAvaliacao(double novaAvaliacao):void -> esse método insere uma avaliação na primeira posição do array
	 * de avaliações (double[] avaliacoes. Se a nota for inválida, então ele retornará "false" para
	 * o chamador do método indicando que não foi possível inserir a nota. Se a nota for válida então
	 * ele retornará "true" para o chamador do método indicando que o array de notas foi percorrido e que
	 * a nova nota foi inserida. Caso o array já esteja completo ele retornará "false".
	 * @param double novaAvaliacao -> a nova avaliação que integrará o array;
	 * 
	 * +imprimeAvaliacoes():void -> este método percorre o array que armazena as avaliações 
	 * do motorista e imprime suas notas;
	 * */
	public boolean insereAvaliacao(double novaAvaliacao)
	{
		/**O primeiro if unário serve para avaliarmos se é possível inserir uma nova nota
		 * de avaliação no array, i.e., se o array não está cheio e se a nota não for negativa
		 * pois nesse caso seria avaliada como uma nota inválida.
		 * */
		if (novaAvaliacao < 0)
		{			
			return false;
		}
		else 
		{
			/**Identificando as posições disponíveis do array. Quando uma posição sem uma nota válida, i.e., 
			 * cujo valor for -1 for encontrada então a nova avaliação passada identificada como parâmetro
			 * e passada como parâmetro formal (argumento) será o novo valor da posição do array. Por isso,
			 * temos a introdução do goto 'break' ao final do if*/
			for (Integer i = 0; i < avaliacoes.length; i++)
			{
				if (avaliacoes[i] == -1)
				{
					avaliacoes[i] = novaAvaliacao;
					return true;
				};//Fim do if
			};//Fim da sentença de iteração for
		}
		return false;
	};//Fim do método insereAvaliacao(double novaAvaliacao);
	
	public void imprimeAvaliacao()
	{
		/**Avaliando se a nota é válida ou não para impressão*/
		for (Integer i = 0; i < avaliacoes.length; i++)
		{
			if (avaliacoes[i] != -1)
			{
				System.out.print(avaliacoes[i] + " | ");
			};//fim do if
		};//Fim do for
	};//Fim do método imprimeAvaliacao();
	
};//Fim da classe MotoristaApp

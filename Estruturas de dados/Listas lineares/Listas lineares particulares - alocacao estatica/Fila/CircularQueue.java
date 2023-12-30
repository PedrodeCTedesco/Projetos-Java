/**Classe para estudar a implementação de uma fila circular, i.e., uma fila onde não teremos o problema apontado no arquivo
 * QueueEstudo.java e QueueEstudopTest.java deste package.
 * 
 * @author pedro de castro tedesco
 * @link "Estruturas de dados e algoritmos", Gustavo Lermen
 * @since 30/12/2023*/

public class CircularQueue
{
	/**CAMPOS.
	 * -queue: Object[] --> utilizamos um vetor para implementação da estrutura de dados. Isso se justifica por ser uma estrutura
	 * de dados do tipo lista com alocação estática, i.e., o vetor garantirá que os valores estão em posições contíguas de memória.
	 * -first: int --> variável para indicar o início da fila
	 * -last: int --> variável para indicar o fim da fila
	 * */
	
	protected Object queue[];
	protected int first = -1; //modificação deste campo.
	protected int last = -1;
	
	/**CONSTRUTOR
	 * +CircularQueue(int size): Object[] --> construtor utilizado para instanciar um objeto da fila
	 * @param int --> será o tamanho da fila e servirá para instanciar o vetor
	 * */
	public CircularQueue(int size)
	{
		queue = new Object[size];
	};//fim do construtor
	
	/**MÉTODOS
	 * +isEmpty(): boolean --> retorna true se a fila estiver vazia e false se não estiver
	 * @return boolean
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1)
	 * 
	 * +isFull(): boolean --> retorna true se a fila estiver cheia e false se não estiver
	 * @return boolean
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * 
	 * +enqueue(Object obj): void --> verifica se é possível inserir um novo elemento na fila, e o adiciona se isso for possível.
	 * @param Object obj --> o novo elemento
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * 
	 * +dequeue(): Object --> verifica se a fila está vazia; se não estiver, remove o primeiro elemento da fila, e o retorna.
	 * @return Object --> uma referência ao objeto removido
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * 
	 * +getFirst(): Object --> retorna o primeiro elemento da fila caso ela não esteja vazia.
	 * @return Object --> a referência do primeiro elemento
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * */
	public boolean isEmpty()
	{
		//Alteração neste método. Agora, se o valor da variável first for -1 isso indica que a fila está vazia.
		return first == - 1;
	};//fim do método isEmpty()
	
	public boolean isFull()
	{
		//A primeira condição da cláusula if avalia se a fila está cheia sem ter dado uma volta
		//A segunda condição avalia a situação na qual a variável first está, p.ex., na posição 3 e a variável last na posiçã 2.
		//Se a condição acima for verdadeira, então isso indica que não há mais espaços livres na fila
		if ((first == 0 && last == queue.length - 1) || (first == last + 1))
		{
			return true;
		} else
		{
			return false;
		}//fim da sentença de seleção condicional composta
	};//fim do método isFull()
	
	public void enqueue(Object obj)
	{
		//Verifica se a lista está cheia
		if(isFull())
		{
			System.out.printf("%s%n", "A fila está cheia.");
		}//fim da sentença de seleção condicional simples

		//Avalia o valor da variável last
		//Avalia as duas condições para uma lista cheia sem ter dado uma volta
		if (last == queue.length - 1 || last == -1)
		{
			//Atribui então o valor 0 para a variável last. Dessa forma, o elemento estará na primeira posição da fila
			last = 0;
			queue[last] = obj;
			//Avalia agora o valor da variável first. Isso é necessário para assegurar que o elemento esteja
			//na primeira posição da fila caso a fila não esteja totalmente cheia; e, ainda, assegura que ambas as variáveis
			//estejam apontando para o elemento
			if (first == -1)
				first = 0;
		} else
		{
			//Caso a fila não esteja totalmente cheia
			last = last + 1;
			queue[last] = obj;
		}//fim da sentença de seleção condicional composta
	};//fim do método enqueue(Object obj)
	
	public Object dequeue()
	{
		//Iniciamos avaliando se a fila está com espaços disponíveis
		if(!isEmpty())
		{
			//Se a fila não está totalmente vazia
			Object objRemovido = queue[first]; //armazena uma referência do objeto a ser removido
			queue[first] = null; //deixa a posição onde o objeto estava como nula
			
			//Avalia se o objeto removido era o único objeto da fila
			//Se for, então as variáveis first e last são configuradas para seus valores iniciais indicando que a fila está vazia
			if (first == last)
			{
				first = -1;
				last = -1;
			} else if (first == queue.length - 1)
			{
				first = 0;
			} //fim da sentença de seleção condicional
			return objRemovido;
		} else
		{
			return null;
		}
	};//fim do método dequeue()
	
	public Object getFirst()
	{
		if(isEmpty())
		{
			return System.out.printf("%s%n", "Fila está vazia.");
		} else
		{
			return queue[first];
		}//fim da sentença de seleção condicional composta
	};//fim do método getFirst()
	
};//fim da classe CircularQueue
 
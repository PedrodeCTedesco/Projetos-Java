/**Classe para estudar a implementação de uma fila.
 * @author pedro de castro tedesco
 * @link "Estruturas de dados e algoritmos", Gustavo Lermen
 * @since 30/12/2023*/
 
public class QueueEstudo
{
	
	/**CAMPOS.
	 * -queue: Object[] --> utilizamos um vetor para implementação da estrutura de dados. Isso se justifica por ser uma estrutura
	 * de dados do tipo lista com alocação estática, i.e., o vetor garantirá que os valores estão em posições contíguas de memória.
	 * -first: int --> variável para indicar o início da fila
	 * -last: int --> variável para indicar o fim da fila
	 * */
	
	protected Object queue[];
	protected int first = 0;
	protected int last = -1;
	
	/**CONSTRUTOR
	 * +QueueEstudo(int size): Object[] --> construtor utilizado para instanciar um objeto da fila
	 * @param int --> será o tamanho da fila e servirá para instanciar o vetor
	 * */
	public QueueEstudo(int size)
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
		return last == first - 1;
	};//fim do método isEmpty()
	
	public boolean isFull()
	{
		return last == queue.length - 1;
	};//fim do método isFull()
	
	public void enqueue(Object obj)
	{
		//Verifica se a lista está cheia
		if(isFull())
		{
			System.out.printf("%s%n", "A fila está cheia.");
		} else
		{
			last+=1;
			queue[last] = obj;
		}//fim da sentença de seleção condicional composta
	};//fim do método enqueue(Object obj)
	
	public Object dequeue()
	{
		if(isEmpty())
		{
			return System.out.printf("%s%n", "Fila está vazia. Não há elementos para serem removidos.");
		} else
		{
			//Crio uma referência para o objeto que será removido
			Object objRemovido = queue[first];
			//Deixo a posição ocupada pelo elemento como nula
			queue[first] = null;
			//Incremento o valor da variável de início
			first+=1;
			return objRemovido;
		}//fim da sentença de seleção condicional composta
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
	
};//fim da classe QueueEstudo
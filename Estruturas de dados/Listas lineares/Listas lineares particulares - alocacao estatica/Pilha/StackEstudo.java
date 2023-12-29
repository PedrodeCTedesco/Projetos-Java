/**Classe para demonstrar a aplicação de uma pilha 
 * @author pedro de castro tedesco
 * @link "Estruturas de dados e algoritmos" (Gustavo Lermen)
 * @since 29/12/2023*/

public class StackEstudo
{
	/**CAMPOS. Ambos são variáveis de instância.
	 * -stack[]: Object --> uma pilha de elementos de qualquer tipo que herde a classe Object
	 * -top: int --> variável para acompanhar o valor do topo da pilha
	 * */
	private Object stack[];
	private int top = -1;
	
	/**CONSTRUTOR.
	 * +Stack(int size): Stack --> inicializa uma pilha com tamanho definido em tempo de execução
	 * @param int size --> o tamanho da pilha
	 * */
	public StackEstudo(int size)
	{
		stack = new Object[size];
	};//fim do construtor
	
	/**MÉTODOS.
	 * +size(): int --> retorna o tamanho da pilha.
	 * @return int --> o tamanho da pilha
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * 
	 * +isEmpty(): boolean --> verifica se a pilha está vazia.
	 * @return boolean --> se true, a pilha está vazia; se false, a pilha não está vazia.
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * 
	 * +isFull(): boolean --> verifica se a pilha está cheia. Se o valor da variável que acompanha as posições de índice
	 * da pilha for igual ao comprimento total da pilha decrementado em 1 isso significa que o valor no topo da pilha
	 * está na posição máxima permitida pela matriz.
	 * @return boolean --> se true a pilha está cheia, se false não está.
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * 
	 * +push(Object obj): void --> avalia se é possível inserir um novo elemento na pilha. Se sim, incrementa o valor da variável
	 * de rastreio da posição de índice da pilha e armazena o elemento nessa posição. Se não, lança uma exceção de stack overflow
	 * @param Object obj;
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * 
	 * +pop(): Object --> avalia se é possível remover um elemento da pilha. Se sim, remove o elemento, retorna-o, e decrementa
	 * o valor da variável de rastreio da posição de índice da pilha. Se não, lança uma exceção de stack underflow.
	 * @return Object obj --> o objeto removido
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * 
	 * +top(): Object --> retorna o elemento no topo da pilha.
	 * @return Object;
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * */
	public int size()
	{
		return top + 1;
	};//fim do método size();
	
	public boolean isEmpty()
	{
		//Verifica se a pilha está vazia
		return top == -1;
	};//fim do método isEmpty();
	
	public boolean isFull()
	{
		return top == stack.length - 1;
	};//fim do método isFull();
	
	public void push(Object obj)
	{
		//Verifica se a pilha está ou não está cheia.
		if(!isFull())
		{
			//Se temos espaço na pilha nós incrementaremos o valor da variável que controla a posição de índice dos elementos da pilha.
			//Note que estamos utilizando um incremento pré-fixado, portanto, o valor atual da variável é o valor após o incremento.
			//Isso assegura que estamos lidando com o valor da posição atual/real da variável que rastreia a posição de índice da pilha.
			stack[++top] = obj;
		} else
		{
			throw new StackOverflowError();
		}//fim da sentença de seleção condicional composta
	};//fim do método push(Object obj);
	
	public Object pop()
	{
		//Verifica se há um elemento na pilha para poder ser removido
		if(!isEmpty())
		{
			//Salvo uma referência do objeto removido;
			Object objRemovido = stack[top];
			//Libero a posição tornando-a nula;
			stack[top] = null;
			//Decrementa a posição da variável de rastreio das posições da pilha
			top-=1;
			return objRemovido;
		} else
		{
			throw new RuntimeException();
		}//fim da sentença de seleção condicional composta
	};//fim do método pop();
	
	public Object top()
	{
		return stack[top];
	};//fim do método top();
	
};//fim da classe Stack
/**Classe utilizada para demonstrar o funcionamento de uma estrutura de dados do tipo lista geral com alocação estática. 
 * Neste classe constam os métodos de implementação necessários para o funcionamento da estrutura de dados. 
 * @author pedro de castro tedesco
 * @link "Algoritmos e Estrutura de Dados" (Gustavo Lermen)
 * @since 27/12/2023*/

/**Note que uma lista é diferente de uma matriz unidimensional de alocação estática (array). Não podemos utilizar os métodos
 * de array em uma lista; ainda, embora possamos referenciar os elementos de uma lista assim como o fazemos com elementos de um 
 * array não podemos iterar sobre os elementos da lista e alterá-los. Outro ponto, não podemos alterar um elemento de uma lista, 
 * pois eles são imutáveis. 
 * */
 
public class SequentialList
{
	/**Campos. Os campos possuem visibilidade 'protected' para que possam ser manipulados exclusivamente 
	 * pelos métodos públicos da classe. Note que o tipo do vetor utilizado para armazenar os itens da lista
	 * é do tipo Object para que essa lista sirva para qualquer tipo de classe que seja uma subclasse de Object.
	 * -list[]: Object --> o vetor que armazenará os elementos da lista.
	 * -last: int --> variável para representar o final da lista. O valor inicial é -1, pois nas definições
	 * de uma lista, se:
	 * Se n > 0 --> significa que temos pelo menos 1 elemento na lista;
	 * Se n = 0 --> significa que a lista está vazia.
	 * */
	protected Object list[];
	protected int last = -1;
	
	/**CONSTRUTOR.
	 * +SequentialList)int size): SequentialList --> construtor que recebe como parâmetro o tamanho da lista.
	 * @param int size --> o tamanho da lista ao ser inicializada.
	 * 
	 * Repare que o tipo de dado para implementação da lista é uma matriz unidimensional.
	 * */
	public SequentialList(int size)
	{
		list = new Object[size];
	};//fim do construtor
	
	/**MÉTODOS.
	 * +getObject(int index): Object --> retorna o objeto na posição de índice passada como parâmetro.
	 * @param int index --> a posição de índice desejada
	 * @return Object --> uma referência do objeto armazenado na posição de índice.
	 * Runtime: O(1);
	 * Complexidade da espaço: O(1);
	 * 
	 * +add(object obj): boolean --> o método verifica se é possível adicionar um novo elemento na lista ao final da lista.
	 * @param Object obj --> o novo objeto que desejamos armazenar na lista
	 * @return boolean --> se true, então o objeto foi adicionado; se false, não foi.
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * 
	 * +add(Object obj, int index): boolean --> o método verifica se é possível adicionar um elemento na posição passada por parâmetro.
	 * Esse método é utilizado caso a lista seja ordenada.
	 * @param Object obj --> o objeto que desejamos inserir
	 * @param int index --> a posição na qual desejamos inserir o objeto
	 * @return boolean --> se true, a inserção foi bem-sucedida; se false, não foi
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * 
	 * +remove(int index): Object --> remove uma referência a um objeto alocado na posição de índice passada por parâmetro.
	 * @param int index --> a posição de índice da referência que desejamos remover
	 * @return Object --> o objeto removido
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * 
	 * +isEmpty(): boolean --> verifica se a lista está vazia.
	 * @return boolean --> se true, a lista está vazia; se false, não está.
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * 
	 * +isFull(): boolean --> verifica se a lista está cheia.
	 * @return boolean --> se true, a lista está cheia; se false, não está
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * 
	 * +getSize(): int --> retorna o tamanho da lista
	 * @return int --> o tamanho da lista
	 * Runtime: O(1);
	 * Complexidade de espaço O(1);
	 * 
	 * +print(): void --> exibe na janela de comando os elementos da lista
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
	 * */
	
	public Object getObject(int index)
	{
		//Verifica se o índice passado por parâmetro é válido
		//Se for inválido, retorna null
		//Se for válido, retorna o elemento na posição de índice passada por parâmetro.
		if (index < 0 || index > last)
		{
			return null;
		} else
		{
			return list[index];
		}//fim da sentença de seleção condicional composta
	};//fim do método getObject(int index);
	
	public boolean add(Object obj)
	{
		//Verifica se a lista não está cheia
		//Se não estiver, segue com o fluxo normal do programa.
		//Se estiver, retorna false.
		if (isFull())
		{
			return false;
		};//fim da sentença de seleção condicional simples
		
		//Altera a posição do último elemento da lista
		last+=1;
		//Armazena o elemento na última posição da lista
		list[last] = obj;
		return true;
	};//fim do método add(Object obj)
	
	public boolean add(Object obj, int index)
	{
		//Verifica se a lista está cheia
		//Se estiver, retorna false
		//Se não estiver, segue o fluxo normal do programa
		if (isFull())
		{
			return false;
		};//fim da sentença de seleção condicional simples
		
		//A sentença de iteração é utilizada para deslocar todos os elementos à direita do novo elemento uma posição.
		//Esse deslocamento é necessário para que o novo elemento entre na posição passada por parâmetro.
		for (int i = last + 1; i > index; i-=1)
		{
			list[i] = list[i - 1];
		};//fim da sentença de iteração for
		
		//Altera a posição do último elemento
		last+=1;
		//Armazena o objeto na posição especificada
		list[index] = obj;
		return true;
	};//fim do método add(Object obj, int index)
	
	public Object remove(int index)
	{
		//Verifica se a lista está vazia
		//Note que não é necessária a existência da cláusula else
		if (isEmpty())
		{
			return null;
		} else if (index < 0 || index > last)
		{
			System.out.printf("%s", "Índice inexistente");
			return null;
		} 

		//Se a verificação for bem sucedida armazenamos uma referência do objeto e alteramos a posição dos demais elementos na lista
		Object obj = list[index];
		int numberOfElements = last - index;
		
		//Realiza uma cópia do array
		if (numberOfElements > 0)
		{
			System.arraycopy(list, index + 1, list, index, numberOfElements);
		};//fim da sentença de seleção simples
		
		//Altera a posição do último elemento para null, decrementa o valor da posição e retorna o objeto removido
		list[last] = null;
		last -= 1;
		return obj;
	};//fim do método remove(int index);
	
	public boolean isEmpty()
	{
		if (last == -1)
		{
			return true;
		} else
		{
			return false;
		}//fim da sentença de seleção condicional composta
	};//fim do método isEmpty();
	
	public boolean isFull()
	{
		if (last == list.length - 1)
		{
			return true;
		} else
		{
			return false;
		}//fim da sentença de seleção condicional composta
	};//fim do método isFull();
	
	public int getSize()
	{
		return last + 1;
	};//fim do método getSize();
	
	public void print()
	{
		//Exibe todos os elementos da lista
		for(Object obj : list)
		{
			System.out.print(obj + " / ");
		};//fim da sentença de iteração for aprimorado
	};//fim do método print()
	
};//fim da classe SequentialList
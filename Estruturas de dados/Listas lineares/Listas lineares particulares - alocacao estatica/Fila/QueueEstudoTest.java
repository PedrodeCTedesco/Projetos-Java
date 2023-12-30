/**Classe para demonstrar a aplicação de uma estrutura de dados de fila. Note  * que nesse exemplo, a fila apresenta 
 * um problema: caso um elemento seja adicionado e removido muitas vezes, a fila acabará "parecendo" cheia quando na verdade estiver vazia.
 * Isso acontece porque as variáveis de início e fim (first, last) são sempre incrementadas. 
 * */

public class QueueEstudoTest
{
	public static void main(String[]args)
	{
		
		QueueEstudo fila = new QueueEstudo(5);
		
		fila.enqueue(Integer.valueOf(1));
		fila.dequeue();
		
		fila.enqueue(Integer.valueOf(1));
		fila.dequeue();
		
		fila.enqueue(Integer.valueOf(1));
		fila.dequeue();
		
		fila.enqueue(Integer.valueOf(1));
		fila.dequeue();
		
		fila.enqueue(Integer.valueOf(1));
		fila.dequeue();
		
		System.out.printf("Testando método isEmpty(): %b%n", fila.isEmpty());
		System.out.printf("Testando método isFull(): %b%n", fila.isFull());
	};//fim do método main
};//fim da classe QueueEstudoTest
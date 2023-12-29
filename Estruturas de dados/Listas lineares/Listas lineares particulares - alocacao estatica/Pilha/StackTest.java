import java.util.Stack;

/**Classe para demonstrar a execução da classe Stack 
 * @author pedro de castro tedesco
 * @link "Estruturas de dados e algoritmos" (Gustavo Lermen)
 * @since 29/12/2023*/
 
public class StackTest
{
	public static void main(String[]args)
	{
		StackEstudo stack = new StackEstudo(10);
		
		//Utilizando tratamento de exceções
		try
		{
			//Tamanho atual da pilha
			System.out.printf("Tamanho atual da pilha: %d%n", stack.size());
			
			//Inserindo elementos na pilha
			stack.push(String.valueOf("https://hermanascomunicacao.com.br"));
			stack.push(String.valueOf("https://clinicarenatacarvalho.com"));
			stack.push(String.valueOf("https://codecademy.com"));
			stack.push(String.valueOf("https://google.com"));
			
			//Tamanho atual da pilha
			System.out.printf("Tamanho atual da pilha: %d%n", stack.size());
			
			//Elemento no topo
			System.out.printf("Elemento no topo da pilha é: %s%n", stack.top());
			
			//Removendo um elemento
			System.out.printf("Removendo o último elemento do topo%n");
			Object elementoRemovido = stack.pop();
			System.out.printf("Removido o elemento: " + elementoRemovido);
			
			//Mostrando elemento atual
			System.out.printf("%nElemento atual no topo da pilha: %s", stack.top());
			
			//Adicionando mais elementos
			stack.push(String.valueOf("https://yahoo.com"));
			stack.push(String.valueOf("https://varennaconsultoria.com.br"));
			
			//Conferindo se a pilha está cheia
			System.out.printf("%nStatus de armazenamento da pilha. Está cheia: %b", stack.isFull());
			
		} catch (StackOverflowError e)
		{
			System.out.println(e);
			
		} catch (RuntimeException er)
		{
			System.out.println(er);
		}//fim do tratamento de exceções
		
	};//fim do método main
};//fim do método StackTest
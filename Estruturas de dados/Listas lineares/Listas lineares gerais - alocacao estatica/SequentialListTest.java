/**Classe de teste da lista linear geral de alocação estática
 * */
 
public class SequentialListTest
{
	public static void main(String[] args)
	{
		//Instanciando a lista
		SequentialList lista = new SequentialList(10);
		
		//Adicionando elementos
		lista.add(Integer.valueOf(2));
		lista.add(Integer.valueOf(2412));
		lista.add(Integer.valueOf(432));
		lista.add(Integer.valueOf(0));
		lista.add(Integer.valueOf(12));
		lista.add(Integer.valueOf(464));
		lista.add(Integer.valueOf(9102));
		
		//Exibindo a lista
		System.out.printf("Exibindo os elementos presentes na lista: ");
		lista.print();
		System.out.println();
		
		//Testando método isEmpty()
		System.out.printf("A lista está vazia? Testando método isEmpty(): %b%n", lista.isEmpty());
		
		//Testando método isFull();
		System.out.printf("A lista está cheia? Testando método isFull(): %b%n", lista.isFull());
		
		//Testando método getSize()
		//Repare que o método conta todos os elementos da lista, logo inicia a contagem em 1.
		System.out.printf("Tamanho atual da lista é: %d%n", lista.getSize());
		
		//Removendo um elemento
		//Note que a remoção segue a notação de matriz unidimensional, i.e., a posição de índice inicial tem como valor 0
		Object elementoRemovido = lista.remove(3);
		System.out.printf("Tentando remover o elemento na posição de índice 3. Removido o elemento: " + elementoRemovido);
		System.out.println();
		
		//Exibindo a lista
		System.out.printf("Exibindo a lista novamente: ");
		lista.print();
		System.out.println();
		
		//Removendo elemento de posição que não existe elemento
		System.out.printf("Tentando remover objeto de posição de índice inexistente. Resultado: ");
		lista.remove(9);
		System.out.println();
		
		//Adicionando todos os elementos
		System.out.printf("%s%n", "Adicionando mais elementos até a lista ficar cheia.");
		lista.add(Integer.valueOf(88));
		lista.add(Integer.valueOf(91200));
		lista.add(Integer.valueOf(7481));
		lista.add(Integer.valueOf(31));
		
		//Exibindo a lista
		System.out.printf("Elementos atuais na lista: ");
		lista.print();
		System.out.println();		
		
		//Tentando adicionar mais um elemento
		System.out.printf("Posso adicionar mais um elemento: " + lista.add(Integer.valueOf(1111)));
		System.out.println();	

		//Tentando adicionar elemento em uma posição de índice
		System.out.printf("%s%n", "Tentando adicionar um elemento na posição de índice 2");
		System.out.print("Resultado: " + lista.add(Integer.valueOf(2222), 2));
		System.out.println();	
		
		//Retornando um elemento na posição de índice especificada
		System.out.printf("%s%n", "Retornando um objeto na posição de índice 7");
		Object elementoRetornado = lista.getObject(7);
		System.out.printf("Objeto na posição de índice 7: " + elementoRetornado);	
	};//fim do método main
};//fim do método SequentialListTest
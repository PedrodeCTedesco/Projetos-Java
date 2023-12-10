/**Classe para demonstração dos métodos estáticos da classe Array. 
 * Todos os métodos estáticos são sobrecarregados para arrays de valores primitivos e arrays de objetos*/

import java.util.Arrays;

public class ArrayManipulations
{
	public static void main (String[] args)
	{
		//Classifica o array de double em ordem crescente utilizando o método sort();
		//O método sort() classifica o array em ordem crescente.
		System.out.printf("O método sort() para classificar os elementos do array em ordem crescente");

		int[] intArrayInicial = {3, 7, 1, 7, 8, 4, 9, 3, 6, 5, 3, 9, 2, 10, 6, 8, 4, 2,3, 6, 1, 0};
		System.out.printf("%nA ordem dos elementos do array antes do método sort():");
		displayArray(intArrayInicial, "intArrayInicial");
		
		Arrays.sort(intArrayInicial);
		System.out.printf("%nA ordem dos elementos do array após o método sort():%n intArray: ");
		
		for (int inteiro : intArrayInicial) 
		{
			System.out.printf("%d ", inteiro);
		};//fim da sentença de iteração for aprimorado
		
		//Preenchendo um array de 10 elementos com o número 7.
		//O método fill() preenche todas as posições de um array com o valor especificado
		System.out.print("\n");
		System.out.printf("\nMétodo fill() para preenchimento de um array com elementos%n");
		
		System.out.printf("Inicializando um array de inteiros com 10 posições. Todas recebem o valor padrão de inicialização de inteiros, i.e, 0.%n");
		
		int[] fillArray = new int[10];
		displayArray(fillArray, "Valores iniciais das posições do array fillArray: ");
		
		Arrays.fill(fillArray, 6);
		
		System.out.printf("%nValores das posições dos elementos do array após o método fill() preenchendo as posições com o valor 6: ");
		displayArray(fillArray, "fillArray");
		
		//Note que o método fill() preenche todas as posições do array, independente de serem nulas ou não
		
		System.out.print("\n");
		System.out.printf("%nNote que o método fill() preenche todas as posições sobrescrevendo os valores originais%n");
		int[] fillArray2 = new int[10];
		fillArray2[2] = 3;
		fillArray2[6] = 3;
		
		System.out.printf("Os valores do array fillArray2 antes do método fill(). Dessa vez, inicializamos o array com 10 posições, porém preenchemos algumas posições com valores iguais a 3 %n");
		displayArray(fillArray2, "fillArray2");
		
		System.out.printf("%nOs valores após o método fill() preenchendo as posições com o valot 7: %n");
		Arrays.fill(fillArray2, 7);
		displayArray(fillArray2, "fillArray2");
		
		System.out.printf("%nTestando o método fill() com uma sentença de seleção condicional simples. %nRealizamos o mesmo procedimento do exercícío anterior");
		
		int[]arrFillCond = new int[10];
		arrFillCond[3] = 4;
		arrFillCond[8] = 4;
		
		System.out.printf("%nPreechemos alguns valores e os valores das posições atuais do array são:");
		displayArray(arrFillCond, "%narrFillCond: ");
		
		for (int i = 0; i < arrFillCond.length; i += 1)
		{
			if(arrFillCond[i] == 0) 
			{
				Arrays.fill(arrFillCond, 9);
			}//fim da sentença de seleção condicional simples
		};//fim da sentença de iteração for
		
		displayArray(arrFillCond, "Array arrFillCond após o método fill() utilizando a sentença de seleção condicional simples:%n");
		
		//Copiando arrays utilizando o método da classe System.arraycopy();
		//Note que a cópia terá o mesmo tamanho do array original e, para isso, temos que obter o tamanho do array original e
		//utilizar esse valor para inicializar o array cópia.
		//A assinatura do arrayCopy: 
		//O primeiro argumento é o array original que desejamos copiar.
		//O segundo argumento é a posição de índice a partir da qual queremos iniciar a cópia.
		//O terceiro argumento é o array de destino das cópias do array original.
		//O quarto argumento especifica o valor inicial de armazenamento das cópias do array original no array de destino.
		//O quinto argumento especifica a quantidade de posições que serão copiadas do array original para o array de destino.
		System.out.print("\n");
		System.out.printf("%n%nMétodo arraycopy() da classe System%n");
		
		int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] intArrayCopy = new int[intArray.length];
		
		System.arraycopy(intArray, 0, intArrayCopy, 0, intArray.length);
		displayArray(intArray, "intArray");
		displayArray(intArrayCopy, "intArrayCopy");
		
		//Método equals() para verificar igualdade entre os valores de dois arrays
		System.out.print("\n");
		System.out.printf("Utilizando os dois arrays anteriores (intArray e intArrayCopy) para verificar o comportamento do método equals()%n");
		
		boolean b = Arrays.equals(intArray, intArrayCopy);
		System.out.printf("%nintArray %s intArrayCopy%n", b ? "==" : "!=");
		
		System.out.printf("Utilizando para o método equals() os arrays: intArray e arrFillCond");
		b = Arrays.equals(intArray, arrFillCond);
		System.out.printf("%nintArray %s arrFillCond%n", b ? "==" : "!=");
		
		//Utilizando o método binarySearch() para localizar valores em um array.
		System.out.print("\n");
		System.out.printf("O método binarySearch() realiza uma busca no array por um determinado valor especificado por nós.%n");
		
		int location = Arrays.binarySearch(intArray, 8);
		
		System.out.printf("Utilizamos uma sentença de seleção condicional simples. Se a busca for verdadeira teremos como retorno o valor da posição do elemento que estamos procurando."+
							"Se o valor que estamos procurando não existir, teremos uma mensagem de erro.%n");
		
		if(location >= 0)
		{
			System.out.printf("%nRESULTADO: encontrado o valor 8 na posição %d", location);
		} else 
		{
			System.out.printf("O valor 8 não existe neste array%n");
		}
		
	};//fim do método main
	

	//Métodos estáticos da classe
	public static void displayArray(int[]arr, String description)
	{
		System.out.printf("%n%s: ", description);
		
		for(int valor : arr) 
		{
			System.out.printf("%d ", valor);
		};//fim da sentença de iteração for aprimorado
	};//fim do método displayArray(int[]arr, String description);
};//fim da classe ArrayManipulations
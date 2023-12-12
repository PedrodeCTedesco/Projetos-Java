/**Utilize um array unidimensional para resolver o seguinte problema: escreva um aplicativo que insere cinco 
números, cada um entre 10 e 100, inclusive. Enquanto cada número é lido, exiba-o somente se ele não tiver uma duplicata de um número 
já lido. Cuide de tratar o “pior caso”, em que todos os cinco números são diferentes. Utilize o menor array possível para resolver esse problema. 
Exiba o conjunto completo de valores únicos inseridos depois que o usuário inserir cada valor novo.
@author pedro de castro tedesco
@since 11/12/2023
*/

import java.util.Random;

public class EliminacaoDeDuplicatas
{
	public static void main (String[]args)
	{
		
		/**Criando as variáveis para inserção dos números inteiros de 10 a 100 (inclusive) */
		
		Random randomNumber = new Random();
		int intNumbers = randomNumber.nextInt(10, 101);
		
		/**Inicializando um array de comprimento variável dado pelo valor de randomNumber. */
		
		int[] arrayInteiros = new int[randomNumber.nextInt(10, 101)];
		
		/**Populando o array instanciado. */
		
		for (int i = 0; i < arrayInteiros.length; i += 1)
		{
			arrayInteiros[i] = randomNumber.nextInt(10, 101);
		};//fim da sentença de iteração for
		
		/**Invocando o método da classe */
		
		eliminacaoDeDuplicatas(INTEIROS_DIFERENTES);
			
	};//fim do método main
	
	/**INTERFACE PÚBLICA */
	
	/**CAMPOS 
	 * Os campos abaixo foram utilizados para treino e desenvolvimento do método. */
	static final int[] INTEIROS_DIFERENTES = {10, 20, 30, 40, 40, 50};
	static final int[] INTEIROS_IGUAIS = {20, 20, 20, 20, 20};
	static final int[] INTEIROS_1_DIFERENTE = {10, 10, 10, 10, 20};
	static final int[] INTEIROS_2_DIFERENTES = {10, 10, 10, 20, 30};
	static final int[] INTEIROS_3_DIFERENTES = {10, 10, 20, 30, 40};

	/**MÉTODOS 
	 * +eliminacaoDeDuplicatas(int[]arr): void --> o método recebe um array de inteiros e escreve na janela de comando os inteiros recebidos
	 * que são diferentes entre si, i.e., não retorna valores inteiros que possuam cópias no array. 
	 * @param int[] arr --> o array de inteiros.
	 * */
	
	public static void eliminacaoDeDuplicatas(int[] arr)
	{
		
		/**Variáveis de bloco:
		 * j: int --> para retornar a próxima posição do array de inteiros.
		 * arrDiferentes: int[] --> array de inteiros digitados pelo usuário cujos valores são diferentes.
		 * arrIguais: int[] --> array de inteiros cujos valores digitados pelo usuário são iguais
		 **/ 
		
		int j = 1;
		int[] arrDiferentes = new int[arr.length];
		int[] arrIguais = new int [arr.length];
		int[] arrDescartáveis = new int [arr.length];
		
		for(int i = 0; i < arr.length - 1; i += 1)
		{
			int a = Math.max(arr[i], arr[j]);
			int b = Math.min(arr[i], arr[j]);
			
			//Se os 'a' e 'b' forem iguais, então temos um valor duplicado.
			//O método compare() da classe Integer retorna 0 se os valores forem iguais, -1 se b > a e +1 se a > b.
			
			int comparacao = Integer.compare(a,  b);
			
			switch (comparacao)
			{
				case 0:
					arrIguais[i] = a;	
				break;
				
				case 1, -1:
				
					for (int verificar = 0; verificar < arr.length; verificar +=1)
					{
						if (arrDiferentes[verificar] == a)
						{
							arrDescartáveis[verificar] = a;
							
						} else if (arrDiferentes[verificar] == b)
						{
							arrDescartáveis[verificar] = b;
							
						} else
						{
							arrDiferentes[i] = b;
							arrDiferentes[i + 1] = a;
							
						}//fim da sentença de seleção condicional composta	
					};//fim da sentença de iteração
					
				break;
			};//fim da sentença de seleção múltipla
			
			j+=1;
		};//fim da sentença de iteração for
		
		for (int x : arrDiferentes)
		{
			System.out.printf("%d ", x);	
		}
	};//fim do método eliminaçãoDeDuplicatas(int[]arr);
	
	
	
	/**Tentativas anteriores:
	 * 		//Verificando com sentença de iteração
		//IDEIA 1
		
	/**	for(int i = 0; i < INTEIROS_DIFERENTES.length; i += 1)
		{
			for(int j = 1; j < INTEIROS_DIFERENTES.length; j += 1)
			{
				boolean b =(INTEIROS_DIFERENTES[i] != INTEIROS_DIFERENTES[j]) ? true : false;
				System.out.printf("%b%15d%15d%n", b, INTEIROS_DIFERENTES[i], INTEIROS_DIFERENTES[j]);
			};//fim da sentença de iteração interna
		};//fim da sentença de iteração externa
		
	*/
		
		
		//Verificando com sentença de iteração for aprimorado
		//IDEIA 2
	/**
		int j = 1;
		for(int i = 0; i < INTEIROS_DIFERENTES.length - 1; i += 1)
		{
			
			boolean b = (INTEIROS_DIFERENTES[i] != INTEIROS_DIFERENTES[j]) ? true : false;
			System.out.printf("%b%15d%15d%n", b, INTEIROS_DIFERENTES[i], INTEIROS_DIFERENTES[j]);
			j+=1;
		};//fim da sentença de iteração for
	*/
		
		//Utilizando a ideia anterior e buscando print apenas dos números diferentes
		//IDEIA 3
	
	/**
		int j = 1;
		for(int i = 0; i < INTEIROS_DIFERENTES.length - 1; i += 1)
		{
			boolean b = (INTEIROS_DIFERENTES[i] != INTEIROS_DIFERENTES[j]) ? true : false;
			
			if (b == true)
			{
				System.out.printf("%b%15d%20d%15d%15d%n", b, i, INTEIROS_DIFERENTES[i], j, INTEIROS_DIFERENTES[j]);
			};//fim da sentença de seleção condicional simples
			
			j+=1;
		};//fim da sentença de iteração for
	*/
		
	
	
};//fim da classe EliminacaoDeDuplicatas
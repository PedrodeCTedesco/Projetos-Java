/** Escreva um aplicativo para simular o lançamento de dois dados. O aplicativo deve utilizar um objeto de classe Random, 
uma vez para lançar o primeiro dado e novamente para lançar o segundo dado. A soma dos dois valores deve então ser calculada. Cada 
dado pode mostrar um valor inteiro de 1 a 6, portanto a soma dos valores irá variar de 2 a 12, com 7 sendo a soma mais frequente e 2 e 12, 
as somas menos frequentes. A Figura 7.28 mostra as 36 possíveis combinações de dois dados. Seu aplicativo deve lançar o dado 36.000.000 
vezes. Utilize um array unidimensional para contar o número de vezes que cada possível soma aparece. Exiba os resultados em formato 
tabular
@author pedro de castro tedesco
@link "Java: Como programar" (Deitel e Deitel), capítulo 7
@since 14/12/2023
*/

import java.util.Random;

public class JogoDeDados
{
	public static void main (String[]args)
	{
		//Criação do cabeçalho para exibição dos dados
		System.out.printf("%6s%15s%n", "Soma", "Frequência");
		
		//Variáveis de instância geradas em tempo de execução para os valores dos dados
		int dado1 = 0;
		int dado2 = 0;

		//Array de inteiro gerado em tempo de execução cujas posições de índice servirão de contadores dos resultados
		int[]frequencia = new int [13];
		
		//Lançando o dado 36.000.000 de vezes
		for(int counter = 0; counter < 36000000; counter += 1)
		{
			//Realizando o lançamento dos dados
			dado1 = lancaDados();
			dado2 = lancaDados();
			
			++frequencia[somaDados(dado1, dado2)];
		};//fim da sentença de iteração for
		
		//Apresentando a frequência dos resultados dos lançamentos anteriores
		for (int resultado = 0; resultado < frequencia.length; resultado += 1)
		{
			System.out.printf("%5d%10d%n", resultado, frequencia[resultado]);
		};//fim da sentença de iteração for
		
		/**	 -----INSTRUÇÃO PARA TESTE DOS MÉTODOS ----
		//Instrução para realizar o lançamento dos dados
		for (int i = 0; i < resultados.length; i += 1)
		{
			dado1 = lancaDados();
			dado2 = lancaDados();

			valorDado1[i] = dado1;
			valorDado2[i] = dado2;
			resultados[i] = somaDados(dado1, dado2);
		};//fim da sentença de iteração for
		
	*/	
		
	};//fim da classe main
	
	/**CAMPOS. Todos são variáveis de instância
	 * dado1: int --> o primeiro dado;
	 * dado2: int --> o segundo dado;
	 * */
	private int dado1;
	private int dado2;
	
	
	/**MÉTODOS. São métodos de classe
	 * +lancaDados(): int --> o método lança para lançar os lances de dados
	 * @return int --> o valor do dado
	 * 
	 * +somaDados(int d1, int d2): int --> método para somar os valores dos dados após serem lançados
	 * @param int d1 --> o valor do primeiro dado obtido após o seu lançamento
	 * @param int d2 --> o valor do segundo dado obtido após o seu lançamento
	 * @return int soma --> o valor da soma
	 * 
	 * +displayArray(int[]arr): void --> método para visualizar os elementos de um array de inteiros. 
	 * Será utilizado para verificar o funcionamento dos métodos da classe
	 * @param int[] arr --> um array de inteiros
	 * ;*/
	private static int lancaDados()
	{
		//Instanciar um objeto da classe Random
		Random randomNumber = new Random();
		
		//O objeto deve retornar um valor entre 1 e 6 (ambos inclusos)
		int valor = randomNumber.nextInt(1, 7);
		
		return valor;
	};//fim da classe lancaDados();
	
	private static int somaDados(int d1, int d2)
	{
		int soma = d1 + d2;
		return soma;
	};//fim do método somaDados(int d1, int d2);
	
	public static void displayArray(int[] arr)
	{
		
		for (int x : arr)
		{
			System.out.printf("%d ", x);
		}
	};//fim do método displayArray(int[]arr)
	
};//fim da classe JogoDeDados
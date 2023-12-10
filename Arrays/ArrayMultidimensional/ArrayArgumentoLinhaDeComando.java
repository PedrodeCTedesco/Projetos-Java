/**Essa classe demonstra o funcionamento do método main, em particular a passagem de argumentos via CLI*/

public class ArrayArgumentoLinhaDeComando
{
	public static void main (String[] args)
	{
		//Verifica o número de argumentos recebidos pela linha de comando
		if (args.length != 3)
		{
			System.out.printf("Error: please re-enter the entire command, including%n" +
								"an array size, initial value and increment%n");
		} else
		{
			//obtém o tamanho do array a partir do primeiro argumento da linha de comando
			int arrayLength = Integer.parseInt(args[0]);
			int arr[] = new int[arrayLength];
			
			//obtém o valor inicial e o incrementa a partir dos argumentos da linha de comando
			int valorInicial = Integer.parseInt(args[1]);
			int incremento = Integer.parseInt(args[2]);
			
			//calcula o valor de cada elemento no array
			for (int counter = 0; counter < arr.length; counter += 1)
			{
				arr[counter] = valorInicial + incremento * counter;
			};//fim da sentença de iteração for
			
			System.out.printf("%s%8s%n", "Index", "Valor");
			
			//exibe o valor e o índice do array
			for (int counter = 0; counter < arr.length; counter += 1)
			{
				System.out.printf("%5d%8d%n", counter, arr[counter]);
			};//fim da sentença de iteração for
		}
	};//fim do método main
};//fim da classe ArrayArgumentoLinhaDeComando
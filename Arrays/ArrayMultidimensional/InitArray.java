/**Classe para demonstração da lógica de arrays multidmensionais.
 * */
 
public class InitArray
{
	public static void main (String[] args)
	{
		/**Essa classe demonstra a geração de dois arrays multidimensionais 
		 * array1[][] --> array bidimensional com 2 linhas cuja primeira linha possui 2 colunas e a terceira linha 3 colunas;
		 * array2[][] --> array multidimensional com 3 linhas; na primeira linha temos 2 colunas, na segunda linha temos 0 colunas e na terceira linha 4 colunas
		 * */
		int[][]array1 = {{1, 2}, {4, 5, 7}};
		int[][]array2 = {{12, 14}, {542}, {13412, 432, 6, 90}};
		
		System.out.println("Valores por linha do array1:");
		outputArray(array1);
		
		System.out.printf("%nValores por linha do array2:%n");
		outputArray(array2);
		
		System.out.println("Método de manipular coluna.");
		manipularColunaArray(array1);
	};//fim da classe main
	
	/**Método para gerar o output dos valores dos arrays*/
	public static void outputArray (int arr[][])
	{
		//Loop pelas linhas do array. Note que utilizaremos uma sentença de iteração for aninhada
		//Assim toda iteração completa do for externo é realizada apenas quando toda a iteração do for interno terminar
		for (int i = 0; i < arr.length; i += 1)
		{
			for (int j = 0; j < arr[i].length; j += 1)
			{
				System.out.printf("%d ", arr[i][j]);
			};//fim da sentença de iteração for interna (pelas colunas do array);
			System.out.println();
		};//fim da sentença de iteração for externa (pelas linhas do array)
	};//fim do método outputArray(int arr[][]);
	
	/**Método para manipular apenas o segundo índice do array, i.e., as colunas a partir de 1 linha */
	public static void manipularColunaArray(int arr[][])
	{
		System.out.print("O array antes era:\n");
		outputArray(arr);
		
		for (int coluna = 0; coluna < arr[1].length; coluna += 1)
		{
			//Como temos especificado arr[1] isso significa que para cada referência no array arr[][]
			//pegaremos sempre a primeira linha. Ainda, na primeira linha passaremos o valor 19.
			arr[1][coluna] = 19;
			
		};//fim da sentença de iteração for
		System.out.print("O array depois é:\n");
		outputArray(arr);
		
	};//fim do método manipularColunaArray(int arr[][]);
	
};//fim da classe InitArray
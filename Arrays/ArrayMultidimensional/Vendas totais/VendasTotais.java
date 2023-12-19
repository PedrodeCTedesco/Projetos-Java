/**Utilize um array bidimensional para resolver o seguinte problema: uma empresa tem quatro equipes de vendas (1 a 4) 
que vendem cinco produtos diferentes (1 a 5). Uma vez por dia, cada vendedor passa uma nota de cada tipo de produto diferente vendido. 
Cada nota contém o seguinte:
a) O número do vendedor
b) O número do produto
c) O valor total em reais desse produto vendido nesse dia
Portanto, cada vendedor passa entre 0 e 5 notas de vendas por dia. Suponha que as informações a partir de todas as notas durante o 
último mês estejam disponíveis. Escreva um aplicativo que leia todas essas informações sobre as vendas do último mês e resuma as vendas 
totais por vendedor e por produto. Todos os totais devem ser armazenados no array bidimensional sales. Depois de processar todas as informações 
do último mês, exiba os resultados em formato tabular, com cada coluna representando um vendedor particular e cada linha representando um 
produto particular. Some cada linha para obter o total das vendas de cada produto no último mês. Some cada coluna para 
obter o total de vendas por vendedor no último mês. Sua saída tabular deve incluir esses totais cruzados à direita das linhas totalizadas e na 
parte inferior das colunas totalizadas.*/

import java.util.Random;

public class VendasTotais
{
	public static void main (String[]args)
	{
		//Inicializando a variável para popular o valor das vendas por produto/vendedor
		Random randomNumber = new Random();
		
		//Inicilizando em tempo de execução o array bidimensional 
		//As linhas serão os produtos (primeiro array)
		//As colunas serão os vendedores (segundo array)
		double[][]sales = new double[4][4]; //[4][5] funciona
		
		for (int linha = 0; linha < sales.length; linha += 1)
		{
			for (int coluna = 0; coluna < sales.length; coluna += 1)
			{
				sales[linha][coluna] = randomNumber.nextDouble() * 100;
			};//fim da sentença de iteração for interna (colunas)
		};//fim da sentença de iteração for externa (linhas)
		
	/**	//Posicionando o valor dos itens na tabela
		for(int row = 0; row < sales.length; row += 1)
		{
			for (int column = 0; column < sales[row].length; column += 1)
			{
				System.out.printf("[%d][%d] = %.1f", row, column, sales[row][column]);
			};//fim da sentença de iteração for interna
		};//fim da sentença de iteração for externa
	*/
		outputProduct(sales);
		
	};//fim do método main
	
	/**CAMPOS
	 * */
	//public static final String[] NUMEROS_VENDEDORES = {"Equipe de vendas 1", "Equipe de vendas 2", "Equipe de vendas 3", "Equipe de vendas 4"};
	//public static final String[] PRODUTOS = {"Produto 1", "Produto 2", "Produto 3", "Produto 4", "Produto 5"};
	
	/**MÉTODOS
	 * */
	public static void outputProduct(double[][] arr)
	{
		
		//Ajustando as colunas e as linhas
		System.out.printf("            ");
		
		//Criando um título de coluna para cada vendedor
		//Note que utilizamos o tamanho do array para posicionarmos o nome de cada coluna em todo o comprimento da tabela
		//Dessa forma, o valor de length do primeiro array será utilizado como referência
		for (int vendedor = 0; vendedor < arr.length; vendedor += 1)
		{
			System.out.printf("%12s%d", "Vendedor ", vendedor + 1);
		};//fim da sentença de iteração for
		
		//Gerando o título da coluna de vendas totais de cada vendedor
		System.out.printf("%20s%n", "Vendas totais (R$)");
		
		//Gerando as linhas onde constam os nomes dos produtos
		for (int produto = 0; produto < arr.length; produto += 1)
		{
			//Gerando o nome das linhas
			System.out.printf("Produto %d", produto + 1);
			
			//Utilizando a sentença de iteração for aprimorado aninhado ao for com contador.
			//O objetivo é que ele gere as saídas do valor total de venda de cada produto posicionando-os de acordo com cada coluna (vendedor)
			for (double d : arr[produto])
			{
				System.out.printf("%13.1f", d);
			};//fim da sentença de iteração for aprimorado
			
			System.out.println();
		};//fim da sentença de iteração for
		
		//Gerando a linha de valor total de vendas de cada produto
		System.out.printf("%s", "Total (R$)");
		
	};//fim do método outputProduct();
	
};//fim da classe VendasTotais
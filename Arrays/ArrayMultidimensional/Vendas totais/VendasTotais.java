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
		double[][]sales = new double[5][4]; 
		
		for (int linha = 0; linha < sales.length; linha += 1)
		{
			//Iterando nos valores da coluna nós utilizamos o tamanho do array (length) da linha.
			//Com a manobra acima garantimos que todas as linhas sejam preenchidas
			for (int coluna = 0; coluna < sales[linha].length; coluna += 1)
			{
				//Preenchendo todas as posições do array
				sales[linha][coluna] = randomNumber.nextDouble() * 100;
			};//fim da sentença de iteração for interna (colunas)
		};//fim da sentença de iteração for externa (linhas)
		
		outputTabelaVendasTotais(sales);
		
	};//fim do método main
	
	/**MÉTODOS
	 * +outputTabelaVendasTotais(double[][]arr): void --> método para gerar as saídas da tabela de vendas totais por produto e por vendedor
	 * @param double[][]arr --> array bidimensional com os valores das vendas por produto e vendedor
	 * */
	public static void outputTabelaVendasTotais(double[][] arr)
	{
		
		//double valorTotalVendedor = 0.0;
		
		//Ajustando as colunas e as linhas
		System.out.printf("            ");
		
		//Criando um título de coluna para cada vendedor
		//O valor de length do primeiro array será utilizado como referência, i.e., o valor do array das linhas.
		//Como esse valor é 5 e temos 4 vendedores, utilizamos a notação arr.length - 1
		for (int vendedor = 0; vendedor < arr.length - 1; vendedor += 1)
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
			
			//Inserir lógica para calcular o valor total por produto (valor total por linha)
			//Variável para armazenar o total de vendas por produto
			double valorTotalProduto = 0.0;
			
			for (int coluna = 0; coluna < arr.length - 1; coluna += 1)
			{
				valorTotalProduto += arr[produto][coluna];			
			};//fim da sentença de iteração for externa (linhas)
			
			//Gerando a saída do valor total por linha
			System.out.printf("%15.1f", valorTotalProduto);
			//Gerando a nova linha para que a próxima linha da tabela seja posicionada no lugar adequado
			System.out.println();
		};//fim da sentença de iteração for
		
		//Gerando a linha de valor total de vendas de cada produto
		System.out.printf("%s", "Total (R$)");
		
		//Lógica para calcular o valor de vendas totais por vendedor (por colunas)
		//Utilização de variáveis em tempo de execução para capturar as colunas do array, e variáveis para iteração.
		double valorTotalVendedor = 0.0;
		double valorTotalVendedor2 = 0.0;
		double valorTotalVendedor3 = 0.0;
		double valorTotalVendedor4 = 0.0;
		int x = 0;
		int y = 1;
		int z = 2;
		int a = 3;
	
		while (x != 4)
		{
			//Primeira coluna
			for (double[] item : arr)
			{
				valorTotalVendedor += item[x];
			};//fim da sentença de iteração for aprimorado
			
			//Segunda coluna
			for (double[] item2 : arr)
			{
				valorTotalVendedor2 += item2[y];
			};//fim da sentença de iteração for aprimorado
			
			//Terceira coluna
			for (double[] item3 : arr)
			{
				valorTotalVendedor3 += item3[z];
			};//fim da sentença de iteração for aprimorado
			
			//Quarta coluna
			for (double[] item4 : arr)
			{
				valorTotalVendedor4 += item4[a];
			};//fim da sentença de iteração for aprimorado
			
			//Gerando a saída da última linha da tabela (valor total por coluna/vendedor)
			System.out.printf("%13.1f%13.1f%12.1f%14.1f", valorTotalVendedor, valorTotalVendedor2, valorTotalVendedor3, valorTotalVendedor4);
			x+=1;
			y+=1;
			z+=1;
			a+=1;
			break;
		};//fim da sentença de iteração while		
	};//fim do método outputTabelaVendasTotais();
};//fim da classe VendasTotais
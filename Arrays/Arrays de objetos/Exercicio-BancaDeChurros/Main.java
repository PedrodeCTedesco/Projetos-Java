/**Classe para testar o funcionamento da banca de churros, exercício da disciplina
 * de laboratório I da Unisinos - Análise e Desenvolvimento de Sistemas
 * @author Pedro de Castro Tedesco
 * @since 21/11/2023
 * */

import java.util.Random;
 
public class Main
{
	public static void main (String[]args)
	{
		//Variáveis de apoio
		Random randomNumbers = new Random();
		int quantidadeDeChurros = randomNumbers.nextInt(30);
		int count = 0;
		int j = 0;
		final String[] SABORES_DE_CHURROS = {"Chocolate", "Amendoim", "Doce de Leite", "Chocolate branco", "Mamão com canela", "Maça verde"};
		final String[] CLIENTES = {"Pedro Tedesco", "Eduarda Endler", "Lorenzo Tedesco", "Paulo Lopes", "Paulo de Tarso", "Maria Silvana", "Leonardo Endler", "Fernnda Kretschmer"};
		
		//Instanciando uma banca de churros
		BancaDeChurros banquinhaDoAle = new BancaDeChurros(quantidadeDeChurros);
		
		//Inserindo churros no array de objetos
		while (j < quantidadeDeChurros)
		{
			//Variáveis para instanciar os churros
			
			String saborDoChurros = SABORES_DE_CHURROS[randomNumbers.nextInt(5)]; 
			double valorDoChurros = randomNumbers.nextDouble(10);
			Churros novoChurro = new Churros (saborDoChurros, valorDoChurros);
							
			banquinhaDoAle.insereChurro(novoChurro);
			count += 1;
			j += 1;
			
		};//fim da sentença de iteração
		
		//Quantos churros foram inseridos

		System.out.printf("A banquinha possui %d churros e foram inseridos %d\n", quantidadeDeChurros, count);
		
		//Verificando o estoque de churros
		String verificaEstoqueDeChurros = SABORES_DE_CHURROS[randomNumbers.nextInt(5)];
		System.out.printf("Quantidade de churros sabor %s: %d\n", verificaEstoqueDeChurros, banquinhaDoAle.estoqueChurros(verificaEstoqueDeChurros));
		
		//Verificando o valor total dos churros na banquinha de churros
		System.out.printf("O valor total em churros na banquinha é %.2f\n", banquinhaDoAle.valorTotal());
		
		//Verificando quantidade atual de churros na banca
		System.out.printf("Quantos churros há na banca: %d\n", banquinhaDoAle.quantosChurrosTem());
		
		//Tentando vender um churro
		String vendaDeChurro = SABORES_DE_CHURROS[randomNumbers.nextInt(5)];
		System.out.println(banquinhaDoAle.vendeChurros(vendaDeChurro));
		
		//Quantidade atual de churros
		//System.out.printf("Antes tínhamos %d churros. Agora temos %d\n", quantidadeDeChurros, (quantidadeDeChurros - 1));
		System.out.printf("Quantos churros há na banca: %d\n", banquinhaDoAle.quantosChurrosTem());
		
		//Verificando se é possível vender a quantidade de churros solicitada pelo cliente
		System.out.println("Nova tentativa de venda de churros.");
		
		String cliente = CLIENTES[randomNumbers.nextInt(8)];
		String saborDoChurro = SABORES_DE_CHURROS[randomNumbers.nextInt(5)];
		int quantidadeDeChurrosSolicitados = (randomNumbers.nextInt(3) + 1);
		
		banquinhaDoAle.lePedidos(cliente, saborDoChurro, quantidadeDeChurrosSolicitados);
		
		//CONTROLE
		System.out.print("Demais opções de churros: \n");
		banquinhaDoAle.imprimeChurros();	
		
		
	};//fim do método main
};//fim da classe Main
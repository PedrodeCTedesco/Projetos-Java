/**Uma pequena companhia aérea acabou de comprar um computador para seu novo sistema 
automatizado de reservas. Você foi solicitado a desenvolver o novo sistema. Você escreverá um aplicativo para atribuir assentos em cada 
voo da companhia aérea (capacidade: 10 assentos).
Seu aplicativo deve exibir as seguintes alternativas: Please type 1 for First Class e Please type 2 for Economy. [Por favor digite 1 para 
Primeira Classe e digite 2 para Classe Econômica]. Se o usuário digitar 1, seu aplicativo deve atribuir assentos na primeira classe 
(poltronas 1 a 5). Se o usuário digitar 2, seu aplicativo deve atribuir um assento na classe econômica (poltronas 6 a 10). Seu aplicativo 
deve exibir um cartão de embarque indicando o número da poltrona da pessoa e se ela está na primeira classe ou na classe econômica.
Utilize um array unidimensional do tipo primitivo boolean para representar o gráfico de assentos do avião. Inicialize todos os elementos do
 array como false para indicar que todas as poltronas estão desocupadas. À medida que cada assento é atribuído, configure o elemento 
 correspondente do array como true para indicar que o assento não está mais disponível.
Seu aplicativo nunca deve atribuir uma poltrona que já foi reservada. Quando a classe econômica estiver lotada, seu aplicativo deve 
perguntar à pessoa se ela aceita ficar na primeira classe (e vice-versa). Se sim, faça a atribuição apropriada de assento. Se não, 
exiba a mensagem "Next flight leaves in 3 hours" [O próximo voo parte em 3 horas]
@author pedro de castro tedesco
@link "Java: Como programar" (Deitel e Deitel), capítulo 7
@since 15/12/2023 -- completo em 17/12/2023
 * */

import java.util.Scanner;
 
public class ReservaDePassagemArea
{
	public static void main(String[]args)
	{
		
		//Objeto para capturar input do usuário
		Scanner input = new Scanner(System.in);
		
		//Saídas de interação com o usuário
		//Variável gerada em tempo de execução para gerenciar as escolhas do usuário
		int opcao = 0;
		int counter = 0;
		
		System.out.printf("%s%n%s%n%s%n", "Qual sua opção?", "Digite \"1\" para poltronas na primeira classe", "Digite \"2\" para poltronas na classe econômica");
		
		while (counter != 10)
		{
			System.out.printf("Qual sua opção? Digite aqui: ");
			opcao = Integer.parseInt(input.nextLine());
			
			sistemaDeReservaDePassagensAereas(opcao);
			counter = todasAsPoltronasOcupadas(assentosDisponiveis);
		};//fim da sentença de iteração while
		
	};//fim do método main
	
	/**CAMPOS
	 * +assentosDisponiveis: boolean[] --> um array de booleanos que representam a disponibilidade de assentos no avião. Todas as posições estão vagas (false);
	 * */
	public static boolean[] assentosDisponiveis = new boolean[11];
	
	/**MÉTODOS
	 * +primeiraClasseReserva(boolean arr[]): boolean --> realiza a reserva de uma poltrona na primeira classe.
	 * @param boolean[] arr --> um array de valores booleanos
	 * @return boolean --> 'true' se a reserva ocorreu e 'false' se a reserva não ocorreu.
	 * 
	 * +primeiraClasseCheia(boolean[] arr): int --> verifica se todas as poltronas na primeira classe estão ocupadas.
	 * @param boolean[] arr --> um array de valores booleanos
	 * @return int counter --> retorna a quantidade de poltronas ocupadas.
	 * 
	 * +classeEconomiaReserva(boolean[]arr): boolean --> realiza a reserva de uma poltrona na classe econômica
	 * @param boolean[] arr --> um array de valores booleanos
	 * @return boolean --> 'true' se a reserva ocorreu e 'false' se a reserva não ocorreu.
	 * 
	 * +classeEconomicaCheia(boolean[]arr): int -->verifica se todas as poltronas na classe econômica estão ocupadas.
	 * @param boolean[] arr --> um array de valores booleanos
	 * @return int counter --> retorna a quantidade de poltronas ocupadas.
	 * 
	 * +todasAsPoltronasOcupadas(boolean[]arr): int --> verifica se todas as poltronas do avião estão ocupadas.
	 * @param boolean[]arr --> um array de valores booleanos
	 * @return int counter --> o total de poltronas ocupadas.
	 * 
	 * +sistemaDeReservaDePassagensAereas(int op): void --> verifica qual a opção do usuário e realiza a reserva da poltrona na primeira classe
	 * ou na segunda classe de acordo com a disponibilidade de assentos.
	 * @param int op --> a opção do usuário pela reserva na primeira classe ou pela classe econômica
	 * 
	 * */
	
	public static boolean primeiraClasseReserva(boolean[] arr)
	{
		//Variáveis de validação da operação
		int indicePassagem = 0;
		
		//Restringir até a posição 6 do array 
		for (int i = 1; i < 6; i+=1)
		{
			if (arr[i] == false && arr[i] != true)
			{
				arr[i] = true;
				indicePassagem = i;
				System.out.printf("%s%n%s%n%s%d%n", "CARTÃO DE EMBARQUE", "Primeira classe", "Poltrona: ", indicePassagem);
				return true;
			};//fim da sentença de seleção simples
		};//fim da sentença de iteração for	
		return false;
	};//fim do método primeiraClasse();
	
	public static int primeiraClasseCheia(boolean arr[])
	{
		//Variável de apoio
		int counter = 0;
		
		for (int i = 0; i < 6; i += 1)
		{
			if (arr[i] == true)
			{
				counter+=1;
			}//fim da sentença de seleção condicional simples
		};//fim da sentença de iteração for
		
		switch(counter)
		{
			case 5:
				System.out.printf("%s%n", "Todas as poltronas na primeira classe estão ocupadas");
			break;
		};//fim da sentença de seleção múltipla
		return counter;
	};//fim do método primeiraClasseCheia(boolean arr[])
	

	public static boolean classeEconomicaReserva(boolean[]arr)
	{
		//Variáveis de validação da operação
		int indicePassagem = 0;
				
		//Iniciar a partir da posição 6 do array 
		for (int i = 6; i < 11; i+=1)
		{
			if (arr[i] == false && arr[i] != true)
			{
				arr[i] = true;
				indicePassagem = i;
				System.out.printf("%s%n%s%n%s%d%n", "CARTÃO DE EMBARQUE", "Classe econômica", "Poltrona: ", indicePassagem);
				return true;
			};//fim da sentença de seleção simples
		};//fim da sentença de iteração for
		return false;
	};//fim do método classeEconomicaReserva(boolean[]arr);
	
	public static int classeEconomicaCheia(boolean[]arr)
	{
		//Variável de apoio
		int counter = 0;
				
		for (int i = 6; i < 11; i += 1)
		{
			if (arr[i] == true)
			{
				counter+=1;
			}//fim da sentença de seleção condicional simples
		};//fim da sentença de iteração for
				
		switch(counter)
		{
			case 5:
				System.out.printf("%s%n", "Todas as poltronas na classe econômica estão ocupadas");
			break;
		};//fim da sentença de seleção múltipla
		return counter;
	};//fim do método classeEconomicaCheia(boolean[]arr);
	
	public static int todasAsPoltronasOcupadas(boolean[]arr)
	{
		int counter = 0;
		
		for (int i = 0; i < arr.length; i += 1)
		{
			if (arr[i] == true)
			{
				counter+=1;
			}//fim da sentença de seleção condicional simples
		};//fim da sentença de iteração for
		return counter;
	};//fim do método todasAsPoltronasOcupadas(boolean[]arr)
	
	public static void sistemaDeReservaDePassagensAereas(int op)
	{
		Scanner input = new Scanner (System.in);
		//Sentença de seleção múltipla para venda das poltronas
		switch (op)
		{
			case 1:
				//Verifica se é possível realizar a reserva
				primeiraClasseReserva(assentosDisponiveis);
				
				//Avisa se não há mais poltronas disponíveis na primeira classe			
				if (primeiraClasseCheia(assentosDisponiveis) == 5)
				{
					System.out.printf("%s%n%s%n%s%n", "Você deseja uma poltrona na classe econômica?", "Digite \"Sim\" para realizar a troca caso tenhamos poltronas disponíveis na classe econômica", "Digite  \"Não\" para não realizar a troca e aguardar o próximo voo");
					
					String decisao = input.nextLine();
					String afirmativo = "Sim";
					
					if (decisao.equalsIgnoreCase(afirmativo))
					{
						boolean d = classeEconomicaReserva(assentosDisponiveis);
						System.out.printf("%s%n", (d == true) ? "Troca de poltronas concluída. Confira seu cartão de embarque." : "Não temos mais poltronas disponíveis na classe econômica.");
						break;
					} else
					{
						System.out.printf("%s%n", "Próximo voo parte em 3 horas");
						break;
					}//fim da sentença de seleção condicional composta		
				}//fim da sentença de seleção condicional simples
			break;
			case 2:
				//Verifica se é possível realizar a reserva
				classeEconomicaReserva(assentosDisponiveis);
				
				//Avisa se não há mais poltronas disponíveis na classe econômica
				if (classeEconomicaCheia(assentosDisponiveis) == 5)
				{
					
					System.out.printf("%s%n%s%n%s%n", "Você deseja uma poltrona na primeira classe?", "Digite \"Sim\" para realizar a troca caso tenhamos poltronas disponíveis na primeira classe", "Digite  \"Não\" para não realizar a troca e aguardar o próximo voo");
					String decisao = input.nextLine();
					String afirmativo = "Sim";
					
					if (decisao.equalsIgnoreCase(afirmativo)) 
					{
						boolean d = primeiraClasseReserva(assentosDisponiveis);
						System.out.printf("%s%n", (d == true)? "Troca de poltronas concluída. Confira seu cartão de embarque." : "Não temos mais poltronas disponíveis na primeira classe.");
						break;
					} else 
					{
						System.out.printf("%s%n", "Próximo voo parte em 3 horas");
						break;
					}//fim da sentença de seleção condicional composta
				}//fim da sentença de seleção condicional simples
			break;
		};//fim da sentença de seleção múltipla
	};//fim do método trocaDeClasse(boolean[]arr);

};//fim da classe ReservaDePassagemArea
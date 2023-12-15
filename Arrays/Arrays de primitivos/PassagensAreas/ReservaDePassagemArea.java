/**Uma pequena companhia aérea acabou de comprar um computador para seu novo sistema 
automatizado de reservas. Você foi solicitado a desenvolver o novo sistema. Você escreverá um aplicativo para atribuir assentos em cada 
voo da companhia aérea (capacidade: 10 assentos).
Seu aplicativo deve exibir as seguintes alternativas: Please type 1 for First Class e Please type 2 for Economy. [Por favor digite 1 para 
Primeira Classe e digite 2 para Classe Econômica]. Se o usuário digitar 1, seu aplicativo deve atribuir assentos na primeira classe 
(poltronas 1 a 5). Se o usuário digitar 2, seu aplicativo deve atribuir um assento na classe econômica (poltronas 6 a 10). Seu aplicativo 
deve exibir um cartão de embarque indicando o número da poltrona da pessoa e se ela está na primeira classe ou na classe econômica.
Utilize um array unidimensional do tipo primitivo boolean para representar o gráfico de assentos do avião. Inicialize todos os elementos do
 array como false para 4indicar que todas as poltronas estão desocupadas. À medida que cada assento é atribuído, configure o elemento 
 correspondente do array como true para indicar que o assento não está mais disponível.
Seu aplicativo nunca deve atribuir uma poltrona que já foi reservada. Quando a classe econômica estiver lotada, seu aplicativo deve 
perguntar à pessoa se ela aceita ficar na primeira classe (e vice-versa). Se sim, faça a atribuição apropriada de assento. Se não, 
exiba a mensagem "Next flight leaves in 3 hours" [O próximo voo parte em 3 horas]
@author pedro de castro tedesco
@link "Java: Como programar" (Deitel e Deitel), capítulo 7
@since 15/12/2023
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
		
		System.out.printf("%s%n%s%n%s%n%s%n", "Qual sua opção?", "Digite \"1\" para poltronas na primeira classe", "Digite \"2\" para poltronas na classe econômica", "Digite \"3\" para sair do programa");
		
		while (opcao != 3)
		{
			System.out.printf("Qual sua opção? Digite aqui: ");
			opcao = Integer.parseInt(input.nextLine());
			
			//Sentença de seleção múltipla para venda das poltronas
			switch (opcao)
			{
				case 1:
					primeiraClasse(assentosDisponiveis);
				break;
			};//fim da sentença de seleção múltipla
		};//fim da sentença de iteração while
		
	};//fim do método main
	
	/**CAMPOS
	 * +assentosDisponiveis: boolean[] --> um array de booleanos que representam a disponibilidade de assentos no avião. Todas as posições estão vagas (false);
	 * */
	public static boolean[] assentosDisponiveis = new boolean[10];
	
	/**MÉTODOS*/
	
	public static void primeiraClasse(boolean arr[])
	{
		//Variáveis de validação da operação
		int indicePassagem = 0;
		boolean poltronaOcupada = false;
		
		//Restringir até a posição 4 do array 
		for (int i = 0; i < 5; i+=1)
		{
			if (arr[i] == false && arr[i] != true)
			{
				arr[i] = true;
				indicePassagem = i;
				poltronaOcupada = true;
				break;
			} else
			{
				System.out.printf("%s%n", "O próximo voo parte em 3 horas.");
			};//fim da sentença de seleção simples
		};//fim da sentença de iteração for
		
		//Retornar informações: índice de pesagem (poltrona ocupada) e se a venda foi bem-sucedida;
		System.out.printf("Status da venda: %b%nPoltrona ocupada: %d%n", poltronaOcupada, indicePassagem);
		
	};//fim do método primeiraClasse();
	
};//fim da classe ReservaDePassagemArea
/**(Passeio do cavalo) Um problema interessante para os fãs de xadrez é o problema do Passeio do Cavalo, originalmente proposto pelo 
matemático Euler. A peça do cavalo pode mover-se em um tabuleiro vazio e tocar cada um dos 64 quadrados somente uma única vez? Aqui, 
estudamos esse intrigante problema em profundidade.
O cavalo só faz movimentos em forma de L (dois espaços em uma direção e um outro em uma direção perpendicular). Portanto, como 
mostrado na Figura 7.30, partindo de um quadrado próximo do centro de um tabuleiro de xadrez vazio, o cavalo (rotulado K) pode fazer oito 
movimentos diferentes (numerados de 0 a 7).
a) Desenhe um tabuleiro de xadrez oito por oito em uma folha de papel e tente o Passeio do Cavalo manualmente. Coloque um 1 no quadrado inicial,
um 2 no segundo quadrado, um 3 no terceiro e assim por diante. Antes de iniciar o passeio, estime até onde você chegará, 
lembrando que um passeio completo consiste em 64 movimentos. Até onde você foi? Isso foi próximo de sua estimativa?

b) Agora vamos desenvolver um aplicativo que moverá o cavalo pelo tabuleiro. O tabuleiro é representado por um array bidimensional 
oito por oito board. Cada quadrado é inicializado como zero. Descrevemos cada um dos oito possíveis movimentos em termos de 
seus componentes vertical e horizontal. Por exemplo, um movimento do tipo 0, como mostrado na Figura 7.30, consiste em mover 
dois quadrados horizontalmente para a direita e um quadrado verticalmente para cima. Um movimento do tipo 2 consiste em mover 
um quadrado horizontalmente para a esquerda e dois quadrados verticalmente para cima. Movimentos horizontais para a esquerda e 
movimentos verticais para cima são indicados com números negativos. Os oitos movimentos podem ser descritos por dois arrays unidimensionais, 
horizontal e vertical, como segue:

 horizontal[0] = 2 vertical[0] = -1 
 horizontal[1] = 1 vertical[1] = -2 
 horizontal[2] = -1 vertical[2] = -2 
 horizontal[3] = -2 vertical[3] = -1 
 horizontal[4] = -2 vertical[4] = 1 
 horizontal[5] = -1 vertical[5] = 2 
 horizontal[6] = 1 vertical[6] = 2 
 horizontal[7] = 2 vertical[7] = 1
 
 Faça com que as variáveis currentRow e currentColumn indiquem, respectivamente, a linha e a coluna da posição atual 
do cavalo. Para fazer um movimento do tipo moveNumber, em que moveNumber está entre 0 e 7, seu aplicativo deve utilizar as 
instruções:

currentRow += vertical[moveNumber]; 
 currentColumn += horizontal[moveNumber];
 
 Escreva um aplicativo para mover o cavalo pelo tabuleiro. Mantenha um contador que varia de 1 a 64. Registre a última contagem 
em cada quadrado para o qual o cavalo se move. Teste cada movimento potencial para ver se o cavalo já visitou esse quadrado. Teste 
cada movimento potencial para assegurar que o cavalo não saia fora do tabuleiro. Execute o aplicativo. Quantos movimentos o cavalo 
fez?
 
 */

import java.util.Random;

public class PasseioDoCavalo
{
	
	public static void main(String[]args)
	{
		//Para mover o cavalo temos que pegar o valor da posição de índice dos vetores HORIZONTAL e VERTICAL
		//e em seguida subtrair ou adicionar o valor das posições ao valor atual da posição de índice do cavalo.
		//Exemplo:
		//HORIZONTAL[3] = -2 "pegar o valor da posição de índice dos vetores" = -2
		//VERTICAL[3] = -1 "pegar o valor da posição de índice dos vetores" = -1
		//Em seguida: "subtrair ou adicionar o valor das posições ao valor atual da posição de índice do cavalo"
		//board[3][4] --> linha 3, coluna 4
		//O valor da posição de índice board[3], 3 - 1 = 2. Novo valor da posição de índice: board[2];
		//O valor da posição de índice board[][4], 4 - 2 = 2. Novo valor da posição de índice: board[][2];
		//Valor final da posição do cavalo será dado pelos valores do índices: board[2][2];
		board[3][4] = "K";
		board[2][2] = "3";
		System.out.printf("Valor de HORIZONTAL[3]: %d%n", HORIZONTAL[3]);
		System.out.printf("Valor de VERTICAL[3]: %d%n", VERTICAL[3]);
		
		board[4][2] = "4";
		System.out.printf("Valor de HORIZONTAL[3]: %d%n", HORIZONTAL[4]);
		System.out.printf("Valor de VERTICAL[3]: %d%n", VERTICAL[4]);
		
		board[5][3] = "5";
		System.out.printf("Valor de HORIZONTAL[5]: %d%n", HORIZONTAL[5]);
		System.out.printf("Valor de VERTICAL[5]: %d%n", VERTICAL[5]);		

		board[4][6] = "7";
		System.out.printf("Valor de HORIZONTAL[5]: %d%n", HORIZONTAL[7]);
		System.out.printf("Valor de VERTICAL[5]: %d%n", VERTICAL[7]);
		//Visualizando o tabuleiro
		print(board);
		
		//Variável moveNumber. É um número entre 0 e 7 que representa os movimentos do cavalo combinando os valores de ambos os arrays
		//Random randomNumber = new Random();
		//int moveNumber = randomNumber.nextInt(0, 8);
		
		
	};//fim do método main
	
	
	/**Campos
	 * -board: int[][] --> tabuleiro de xadrez. É uma matriz bidimensional 8 por 8 (8linhas e 8 colunas)
	 * -HORIZONTAL: int[] --> representa as possibilidades de movimento horizontal do cavalo. Movimentos para a esquerda possuem valores negativos.
	 * -VERTICAL: int[] --> representa as possibilidades de movimento vertical do cavalo. Movimentos verticais ascendentes possuem valores negativos.
	 * */
	private static String[][] board = new String[8][8];
	private static final int[] HORIZONTAL = {2, 1, -1, -2, -2, -1, 1, 2}; //mudança de coluna
	private static final int[] VERTICAL = {-1, -2, -2, -1, 1, 2, 2, 1}; //mudança de linha
	
	/**MÉTODOS
	 * -print(String[][]arr): void --> exibe o tabuleiro de xadrez.
	 * @param String[][] --> um array bidimensional de Strings
	 * Runtime: O(N^2);
	 * Complexidade de espaço: O(N^2);
	 * */
 	private static void print(String[][] arr)
	{
		//Visualizando todas as casas do tabuleiro
		//Nota: Todas as casas do tabuleiro inicializam com o valor padrão
		System.out.printf("%s%n", "Tabuleiro");
		
		for(int linha = 0; linha < arr.length; linha +=1)
		{
			for(int coluna = 0; coluna < arr.length; coluna +=1)
			{
				System.out.printf("%s ", (arr[linha][coluna] == null) ? "*" : arr[linha][coluna]);
			};//fim da sentença de iteração for interna
			System.out.println();
		};//fim da sentença de iteração for externa	
	};//fim do método print();

	
};//fim da classe PasseioDoCavalo
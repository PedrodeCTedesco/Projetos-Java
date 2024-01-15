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

import java.util.EnumSet;
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
		
		String p = PosicoesCriticas.H8.getPosicao(); //Valor: "H8"
		int p1 = PosicoesCriticas.H8.getIndexRow(); //Valor: 0
		int p2 = PosicoesCriticas.H8.getIndexColumn();//Valor: 7
		
		//board[3][5] = "K";
		//String e2 = p;
		//board[7][4] = p;
		
		//Visualizando o tabuleiro
		print(board);
		
		System.out.printf("%s%n", "Testando o método currentPosition() e os métodos decomposeArrayRow() e decomposeArrayColumn()");
		System.out.printf("Linha: %d%nColuna: %d%n", decomposeArrayRow(currentPosition(p)), decomposeArrayColumn(currentPosition(p)));
		
		System.out.printf("%s%n", "Testando método checkCurrentBoundary()");
		System.out.printf("Linha: %d%nColuna: %d", decomposeArrayRow(checkBoardBoundary(p)), decomposeArrayColumn(checkBoardBoundary(p)));
				
		//Testando o método nextPosition(String[][]arr, String element)
		//nextPosition(board, checkBoardBoundary(board, e2));
		
		//Avaliando se conseguimos mudar a posição do cavalo
		//int c1 = decomposeArrayRow(nextPosition(board, checkBoardBoundary(board, e2)));
		//int c2 = decomposeArrayColumn(nextPosition(board, checkBoardBoundary(board, e2)));
		
		//System.out.printf("linha: %d%n", c1);
		//System.out.printf("coluna: %d%n", c2);
		
		//board[c1][c2] = p; 
		
		//print(board);
		
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
	 * 
	 * -indexRow(String[][] arr, String element): int --> retorna a posição de índice da linha do elemento passado por parâmetro
	 * @param String[][] arr --> vetor bidimensional de Strings
	 * @param String element --> elemento que desejamos recuperar a posição de índice da linha
	 * @return int --> o valor da posição de índice da linha
	 * Runtime: O(N^2);
	 * Complexidade de espaço: O(N^2);
	 * 
	 * -indexColumn(String[][]arr, String element): int --> retorna a posição de índice da coluna do elemento passado por parâmetro
	 * @param String[][]arr --> vetor bidimensional de Strings
	 * @param String element --> elemento que desejamos recuperar a posição de índice da coluna
	 * @return int --> o valor da posição de índice da coluna 
	 * Runtime: O(N^2);
	 * Complexidade de espaço: O(N^2);
	 * 
	 * -checkBoardBoundary(String[][]arr, String currentKnightPosition): int[] --> o método verifica se a posição atual do cavalo 
	 * está em um dos quatro canto do tabuleiro (inferior, superior, esquerdo e direito). Se estiver em uma casa que esteja em 
	 * um desses cantos, retorna array de inteiros com a posição atual do cavalo.
	 * @param String[][]arr --> vetor bidimensional de Strings
	 * @param String currentKnightPosition --> posição de índice atual do cavalo (linha e coluna);
	 * @return int[] --> array de inteiros indicando qual é a posição atual do cavalo
	 * Runtime: O(1);
	 * Complexidade de espaço: O(1);
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

	private static int[] currentPosition(String element)
	{
		//Array de inteiros para armazenar a posição atual do cavalo no tabuleiro.
		int[] currentPosition = new int[2];
		
		//Iteração pelas constantes enum para identificar a posição
		for (PosicoesCriticas position : PosicoesCriticas.values())
		{
			if (position.getPosicao() == element)
			{
				currentPosition[0] = position.getIndexRow();
				currentPosition[1] = position.getIndexColumn();
			}//fim da sentença de seleção condicional simples
		}//fim do for aprimorado
		return currentPosition;
	};//fim do método currentPosition(String element);

	/*
	private static int indexColumn(String[][] arr, String element)
	{
		//Variável local 
		int colunaIndex = 0;
		
		//Itera peo array bidimensional em busca do elemento
		for(int linha = 0; linha < arr.length; linha +=1) 
		{
			for(int coluna = 0; coluna < arr.length; coluna +=1)
			{
				if(element == arr[linha][coluna])
				{
					colunaIndex = coluna;
				}//fim da sentença de seleção condicional simples
			};//fim da sentença de iteração for interna
		};//fim da sentença de iteração for externa
		return colunaIndex;
	};//fim do método returnRowAndColumnIndex(int element)
*/	
	
	private static int[] nextPosition(String[][]arr, int[]arr2) //invocamos o método checkBoardBoundary() que tem como retorno o array de inteiros
	{
		//Retornar o valor armazenado na posição de índice do array unidimensional HORIZONTAL (colunas) e VERTICAL (linhas)
		Random randomNumber = new Random();
		
		//Armazenando o valor da linha e da coluna
		int prevIndexRow = decomposeArrayRow(arr2); //valor virá do resultado de checkBoardBoundary(String[][]arr, currentKnightPosition);
		int prevIndexColumn = decomposeArrayColumn(arr2);//valor virá do resultado de checkBoardBoundary(String[][]arr, currentKnightPosition);
		
		//Array para armazenar os valores da próxima posição
		int[] nextPositionRowAndColumn = new int[2];
		
		//Validação dos movimentos.
		//As duas primeiras seleções condicionais simples avaliam a posição do cavalo nos cantos esquerdo e direito (utiliza o prevIndexColumn, o valor da coluna).
		//O segundo switch avalia a posição do cavalo nos cantos inferior e superior (utiliza o prevIndexRow, valor da linha).
		if ((prevIndexColumn == 0 && prevIndexRow == 1) || (prevIndexColumn == 0 && prevIndexRow == 2) || (prevIndexColumn == 0 && prevIndexRow == 3) ||
				(prevIndexColumn == 0 && prevIndexRow == 4) || (prevIndexColumn == 0 && prevIndexRow == 5) || (prevIndexColumn == 0 && prevIndexRow == 6))
		{
			//Se estiver no canto esquerdo não são válidas as posições de índice: 2, 3, 4, 5
			int moveNumber = randomNumber.nextInt(0, 8);
			//Variáveis para armazenar os próximos valores da posição do cavalo
			int indexRow = 0;
			int indexColumn = 0;

			while (moveNumber >= 2 && moveNumber <=5)
			{
				moveNumber = randomNumber.nextInt(0, 8);
				indexRow = HORIZONTAL[moveNumber];
				indexColumn = VERTICAL[moveNumber];
			};//fim da sentença de iteração while
			nextPositionRowAndColumn[0] = indexRow;
			nextPositionRowAndColumn[1] = indexColumn;
		
			return nextPositionRowAndColumn;
			//System.out.printf("%s:%d%n%s:%d", "Nova linha", indexRow, "Nova coluna", indexColumn); descomentar para visualizar os valores
		}//fim da sentença de seleção condicional simples
		
		if ((prevIndexColumn == 7 && prevIndexRow == 1) || (prevIndexColumn == 7 && prevIndexRow == 2) || (prevIndexColumn == 7 && prevIndexRow == 3) ||
				(prevIndexColumn == 7 && prevIndexRow == 4) || (prevIndexColumn == 7 && prevIndexRow == 5) || (prevIndexColumn == 7 && prevIndexRow == 6))
		{
			//Se estiver no canto direito não são válidos valores: 0, 1, 6, 7
			int moveNumber = randomNumber.nextInt(0, 8);
			
			int indexRow = 0;
			int indexColumn = 0;
			
			while (moveNumber <= 2 || moveNumber >= 5)
			{
				moveNumber = randomNumber.nextInt(0, 8);
				indexRow = HORIZONTAL[moveNumber];
				indexColumn = VERTICAL[moveNumber];
			};//fim da sentença de iteração while
			nextPositionRowAndColumn[0] = indexRow;
			nextPositionRowAndColumn[1] = indexColumn;
			
			return nextPositionRowAndColumn;
		}//fim da sentença de seleção condicional simples
		
		if ((prevIndexRow == 0 && prevIndexColumn == 1) || (prevIndexRow == 0 && prevIndexColumn == 2) || (prevIndexRow == 0 && prevIndexColumn == 3) ||
				(prevIndexRow == 0 && prevIndexColumn == 4) || (prevIndexRow == 0 && prevIndexColumn == 5) || (prevIndexRow == 0 && prevIndexColumn == 6))
		{
			//Se estiver no canto superior não são válidos valores: 0, 1, 2, 3
			int moveNumber = randomNumber.nextInt(0, 8);
			
			//Variáveis para armazenar os próximos valores da posição do cavalo
			int indexRow = 0;
			int indexColumn = 0;
			
			while (moveNumber <= 3)
			{
				moveNumber = randomNumber.nextInt(0, 8);
				indexRow = HORIZONTAL[moveNumber];
				indexColumn = VERTICAL[moveNumber];
			};//fim da sentença de iteração while
			
			nextPositionRowAndColumn[0] = indexRow;
			nextPositionRowAndColumn[1] = indexColumn;
			
			return nextPositionRowAndColumn;
		}//fim da sentença de seleção condicional simples
		
		if ((prevIndexRow == 7 && prevIndexColumn == 1) || (prevIndexRow == 7 && prevIndexColumn == 2) || (prevIndexRow == 7 && prevIndexColumn == 3) ||
				(prevIndexRow == 7 && prevIndexColumn == 4) || (prevIndexRow == 7 && prevIndexColumn == 5) || (prevIndexRow == 7 && prevIndexColumn == 6))
		{
			//Posições no canto inferior do tabuleiro. Não são válidos valores: 4, 5, 6, 7
			int moveNumber = randomNumber.nextInt(0, 8);
			int indexRow = 0;
			int indexColumn = 0;
			
			while (moveNumber >= 4)
			{
				moveNumber = randomNumber.nextInt(0, 8);
				indexRow = HORIZONTAL[moveNumber];
				indexColumn = VERTICAL[moveNumber];
			};//fim da sentença de iteração while
			nextPositionRowAndColumn[0] = indexRow;
			nextPositionRowAndColumn[1] = indexColumn;
			return nextPositionRowAndColumn;
		}//fim da sentença de seleção condicional simples]
		
		//Se nenhuma condição for aceita retornar na posição padrão
		nextPositionRowAndColumn[0] = 3;
		nextPositionRowAndColumn[1] = 4;
		return nextPositionRowAndColumn;
	};//fim do método nextPosition()

	private static int[] checkBoardBoundary(String currentKnightPosition)
	{
		//Críticas, canto esquerdo
		for (PosicoesCriticas positionLeft : EnumSet.range(PosicoesCriticas.A8, PosicoesCriticas.A1))
		{
			if (positionLeft.getPosicao() == currentKnightPosition)
			{
				return currentPosition(currentKnightPosition);
			}//fim da sentença de seleção condicional simples
		}//fim da sentença de iteração for aprimorada
		
		//Críticas, canto superior
		for (PosicoesCriticas positionTop : EnumSet.range(PosicoesCriticas.B8, PosicoesCriticas.H8))
		{
			if (positionTop.getPosicao() == currentKnightPosition)
			{
				return currentPosition(currentKnightPosition);
			}//fim da sentença de seleção condicional simples
		}//fim da sentença de iteração for aprimorada

		//Críticas, canto direito
		for (PosicoesCriticas positionRight : EnumSet.range(PosicoesCriticas.H7, PosicoesCriticas.H1))
		{
			if (positionRight.getPosicao() == currentKnightPosition)
			{
				return currentPosition(currentKnightPosition);
			}//fim da sentença de seleção condicional simples
		}//fim da sentença de iteração for aprimorada

		//Críticas, canto inferior
		for (PosicoesCriticas positionBottom : EnumSet.range(PosicoesCriticas.G1, PosicoesCriticas.B1))
		{
			if (positionBottom.getPosicao() == currentKnightPosition)
			{
				return currentPosition(currentKnightPosition);
			}//fim da sentença de seleção condicional simples
		}//fim da sentença de iteração for aprimorada
		
		return currentPosition(currentKnightPosition);
	};//fim do método checkBoardBoundary(String currentKnightPosition)

	private static int decomposeArrayRow(int[]arr)
	{
		return arr[0];
	};//fim do método decomposeArrayRow(int[]arr);
	
	private static int decomposeArrayColumn(int[]arr)
	{
		return arr[1];
	};//fim do método decomposeArrayColumn(int[]arr);
	
};//fim da classe PasseioDoCavalo
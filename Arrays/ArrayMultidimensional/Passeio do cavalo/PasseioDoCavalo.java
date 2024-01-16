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
		//O valor da posição de índice board[3], 3 - 1 = 2. Novo valor da posição de índice: board[2]; (decrementar/incrementar)
		//O valor da posição de índice board[][4], 4 - 2 = 2. Novo valor da posição de índice: board[][2]; (decrementar/incrementar)
		//Valor final da posição do cavalo será dado pelos valores do índices: board[2][2];
		int contador = 0;
		Random randomNumber = new Random();
		
		int[] initialPosition = {randomNumber.nextInt(0,8), randomNumber.nextInt(0,8)};
		
		while (contador != 64)
		{
			
			int currentRow = decomposeArrayRow(initialPosition);
			int currentColumn = decomposeArrayColumn(initialPosition);
			
			//Verificar onde inserir uma verificação das posições já visitadas pelo cavalo
			
			board[currentRow][currentColumn] = "K";
			System.out.printf("1) Current row: %d%nCurrent column: %d%n", currentRow, currentColumn);
			
			//Visualizando o tabuleiro
			print(board);
						
			int[]arr1 = nextPosition(initialPosition);
			
			
			
			
			currentRow+=decomposeArrayRow(arr1);
			currentColumn+=decomposeArrayColumn(arr1);
			
			System.out.printf("2) Current row: %d%nCurrent column: %d%n", currentRow, currentColumn);
			System.out.println();
			
			board[currentRow][currentColumn] = "k";
			
			print(board);
			
			initialPosition[0] = currentRow;
			initialPosition[1] = currentColumn;
			
			//System.out.printf("3) Current row: %d%nCurrent column: %d%n", currentRow, currentColumn);
			contador+=1;
		};//fim da sentença de iteração while
		
		
		
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

	private static int[] nextPosition(int[] arr) 
	{
		//Retornar o valor armazenado na posição de índice do array unidimensional HORIZONTAL (colunas) e VERTICAL (linhas)
		Random randomNumber = new Random();
		int moveNumber = randomNumber.nextInt(0, 8);
		
		//Array para armazenar os valores da próxima posição
		int[] nextPositionRowAndColumn = new int[2];
		
		//Validação dos movimentos.
		//Canto esquerdo (críticas). Não são permitidos movimentos à esquerda (números negativos de coluna)
		for (PosicoesCriticas positionLeft : EnumSet.range(PosicoesCriticas.A8, PosicoesCriticas.B7))
		{
			if (positionLeft.getIndexRow() == decomposeArrayRow(arr) && positionLeft.getIndexColumn() == decomposeArrayColumn(arr))
			{
				//Se estiver no canto esquerdo não são válidas as posições de índice: 1, 2, 3, 4, 5, 6
				//Se for B7, então não são válidas as posições: 1, 2, 3, 4, 5
				moveNumber = randomNumber.nextInt(0, 8);
				
				//Verificação de B7
				if (positionLeft.B7.getIndexRow() == decomposeArrayRow(arr) && positionLeft.B7.getIndexColumn() == decomposeArrayColumn(arr))
				{
					while (moveNumber >= 1 || moveNumber >= 6 )
					{
						moveNumber = randomNumber.nextInt(0, 8);
					};//fim da sentença de iteração while
					nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
					nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];
					
					return nextPositionRowAndColumn;
				}//fim da sentença de seleção condicional simples
				
				
				while (moveNumber >= 1 && moveNumber <=6)
				{
					moveNumber = randomNumber.nextInt(0, 8);
				};//fim da sentença de iteração while
				nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
				nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];
				
				return nextPositionRowAndColumn;
			}//fim da sentença de seleção condicional simples
		}//fim da sentença de iteração for aprimorada
		
		//Validação de movimentos
		//Canto direito (críticas). Não são permitidos movimentos à direita (números positivos de coluna)
		for (PosicoesCriticas positionRight : EnumSet.range(PosicoesCriticas.H7, PosicoesCriticas.G6))
		{
			if (positionRight.getIndexRow() == decomposeArrayRow(arr) && positionRight.getIndexColumn() == decomposeArrayColumn(arr))
			{
				//Se estiver no canto direito não são válidos valores: 0, 1, 3, 4, 5, 6, 7
				//Se for H7 temos uma verificação especial, pois somente seria válido o valor da posição 5
				moveNumber = randomNumber.nextInt(0, 8);
			
				//Verificação de H7
				if (positionRight.H7.getIndexRow() == decomposeArrayRow(arr) && positionRight.H7.getIndexColumn() == decomposeArrayColumn(arr))
				{
					while (moveNumber <= 4 || moveNumber >= 6 )
					{
						moveNumber = randomNumber.nextInt(0, 8);
					};//fim da sentença de iteração while
					nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
					nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];
					
					return nextPositionRowAndColumn;
				}//fim da sentença de seleção condicional simples
				
				while (moveNumber < 2 || moveNumber >= 3 )
				{
					moveNumber = randomNumber.nextInt(0, 8);
				};//fim da sentença de iteração while
				nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
				nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];
				
				return nextPositionRowAndColumn;
			}//fim da sentença de seleção condicional simples
		}//fim da sentença de iteração for aprimorada
	
		//Canto superior (críticas). Não são permitidos movimentos para cima (números negativos de linha)
		for (PosicoesCriticas positionTop : EnumSet.range(PosicoesCriticas.B8, PosicoesCriticas.G7))
		{
			if (positionTop.getIndexRow() == decomposeArrayRow(arr) && positionTop.getIndexColumn() == decomposeArrayColumn(arr))
			{
			//Se estiver no canto superior não são válidos valores: 0, 1, 2, 3, 4, 7
			moveNumber = randomNumber.nextInt(0, 8);
			
			while (moveNumber <= 4 || moveNumber == 7)
			{
				moveNumber = randomNumber.nextInt(0, 8);
			};//fim da sentença de iteração while
				
			nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
			nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];
			
			return nextPositionRowAndColumn;
			}//fim da sentença de seleção condicional simples
		};//fim da sentença de iteração for aprimorada
		
		//Validação de movimentos
		//Canto inferior (críicas). Não são permitidos movimentos para baixo (números positivos de linha)
		for (PosicoesCriticas positionBottom : EnumSet.range(PosicoesCriticas.G1, PosicoesCriticas.F2))
		{
			if (positionBottom.getIndexRow() == decomposeArrayRow(arr) && positionBottom.getIndexColumn() == decomposeArrayColumn(arr))
			{
			//Posições no canto inferior do tabuleiro. Não são válidos valores: 4, 5, 6, 7
			moveNumber = randomNumber.nextInt(0, 8);
			
			while (moveNumber >= 4)
			{
				moveNumber = randomNumber.nextInt(0, 8);
			};//fim da sentença de iteração while
			nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
			nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];
			return nextPositionRowAndColumn;
			}//fim da sentença de seleção condicional simples
		}//fim da sentença de iteração for aprimorada
		
	/*	
		//Inserir cuidados com as bordas internas
		//Canto esquerdo (internas)
		for (PosicoesCriticas positionLeft : EnumSet.range(PosicoesCriticas.B2, PosicoesCriticas.B7))
		{
			if (positionLeft.getIndexRow() == decomposeArrayRow(arr) && positionLeft.getIndexColumn() == decomposeArrayColumn(arr))
			{
				//Se estiver no canto esquerdo não são válidas as posições de índice: 3, 4 
				moveNumber = randomNumber.nextInt(0, 8);
				
				while (moveNumber >= 3 && moveNumber <= 4)
				{
					moveNumber = randomNumber.nextInt(0, 8);
				};//fim da sentença de iteração while
				nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
				nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];
				 
				return nextPositionRowAndColumn;
			}//fim da sentença de seleção condicional simples
		}//fim da sentença de iteração for aprimorada
		
		//Canto direito (internas)
		for (PosicoesCriticas positionRight : EnumSet.range(PosicoesCriticas.G2, PosicoesCriticas.G6))
		{
			if (positionRight.getIndexRow() == decomposeArrayRow(arr) && positionRight.getIndexColumn() == decomposeArrayColumn(arr))
			{
				//Se estiver no canto direito não são válidos valores: 0, 7
				moveNumber = randomNumber.nextInt(0, 8);
					
				while (moveNumber == 0 || moveNumber == 7)
				{
					moveNumber = randomNumber.nextInt(0, 8);
				};//fim da sentença de iteração while
				nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
				nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];
						
				return nextPositionRowAndColumn;
			}//fim da sentença de seleção condicional simples
		}//fim da sentença de iteração for aprimorada
		
		//Canto superior (internas)
		for (PosicoesCriticas positionTop : EnumSet.range(PosicoesCriticas.C7, PosicoesCriticas.G7))
		{
			if (positionTop.getIndexRow() == decomposeArrayRow(arr) && positionTop.getIndexColumn() == decomposeArrayColumn(arr))
			{
				//Se estiver no canto superior não são válidos valores: 1, 2
				moveNumber = randomNumber.nextInt(0, 8);
					
				while (moveNumber >= 1 && moveNumber <= 2)
				{
					moveNumber = randomNumber.nextInt(0, 8);
				};//fim da sentença de iteração while
						
				nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
				nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];
					
				return nextPositionRowAndColumn;
			}//fim da sentença de seleção condicional simples
		}//fim da sentença de iteração for aprimorada		
		
		//Canto inferior (internas)
		for (PosicoesCriticas positionBottom : EnumSet.range(PosicoesCriticas.C2, PosicoesCriticas.F2))
		{
			if (positionBottom.getIndexRow() == decomposeArrayRow(arr) && positionBottom.getIndexColumn() == decomposeArrayColumn(arr))
			{
				//Posições no canto inferior do tabuleiro. Não são válidos valores: 5, 6
				moveNumber = randomNumber.nextInt(0, 8);
					
				while (moveNumber >= 5 && moveNumber <= 6)
				{
					moveNumber = randomNumber.nextInt(0, 8);
				};//fim da sentença de iteração while
				nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
				nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];
				return nextPositionRowAndColumn;
			}//fim da sentença de seleção condicional simples
		}//fim da sentença de iteração for aprimorada
	*/		
		
		//Se nenhuma condição for aceita retornar na posição padrão
		nextPositionRowAndColumn[0] = VERTICAL[moveNumber];
		nextPositionRowAndColumn[1] = HORIZONTAL[moveNumber];
		return nextPositionRowAndColumn;
	};//fim do método nextPosition()
	
	private static int decomposeArrayRow(int[]arr)
	{
		return arr[0];
	};//fim do método decomposeArrayRow(int[]arr);
	
	private static int decomposeArrayColumn(int[]arr)
	{
		return arr[1];
	};//fim do método decomposeArrayColumn(int[]arr);
	
};//fim da classe PasseioDoCavalo
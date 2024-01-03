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
		
		String p = PosicoesCriticas.A5.getPosicao();
		int p1 = PosicoesCriticas.A5.getIndexRow();
		int p2 = PosicoesCriticas.A5.getIndexColumn();
		
		//board[3][5] = "K";
		String e2 = p;
		board[7][2] = p;
		
		//Visualizando o tabuleiro
		print(board);
		
		//Verificando o método checkBoardBoundary(String[][]arr, String currentKnightPosition) e printArray(int[]arr);
		//System.out.printf("%s:%d%n%s:%d", "Linha", decomposeArrayRow(checkBoardBoundary(board, e2)), "Coluna", decomposeArrayColumn(checkBoardBoundary(board, e2)));

		
		//Testando o método nextPosition(String[][]arr, String element)
		nextPosition(board, checkBoardBoundary(board, e2));
		
		
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
	 * -checkBoardBoundary(String[][]arr, String currentKnightPosition): String --> o método verifica se a posição atual do cavalo 
	 * está em um dos quatro canto do tabuleiro (inferior, superior, esquerdo e direito). Se estiver em uma casa que esteja em 
	 * um desses cantos, retorna uma String indicando qual é o canto.
	 * @param String[][]arr --> vetor bidimensional de Strings
	 * @param String currentKnightPosition --> posição de índice atual do cavalo (linha e coluna);
	 * @return String --> String indicando qual é a posição atual do cavalo
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

	private static int indexRow(String[][] arr, String element)
	{
		//Variável local 
		int linhaIndex = 0;
		
		//Itera peo array bidimensional em busca do elemento
		for(int linha = 0; linha < arr.length; linha +=1) 
		{
			for(int coluna = 0; coluna < arr.length; coluna +=1)
			{
				if(element == arr[linha][coluna])
				{
					linhaIndex = linha;
				}//fim da sentença de seleção condicional simples
			};//fim da sentença de iteração for interna
		};//fim da sentença de iteração for externa
		return linhaIndex;
	};//fim do método returnRowAndColumnIndex(int element)
	
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
	
	private static void nextPosition(String[][]arr, int[]arr2) //invocamos o método checkBoardBoundary() que tem como retorno o array de inteiros
	{
		//Retornar o valor armazenado na posição de índice do array unidimensional HORIZONTAL (colunas) e VERTICAL (linhas)
		Random randomNumber = new Random();
		
		//Armazenando o valor da linha e da coluna
		int prevIndexRow = decomposeArrayRow(arr2); //valor virá do resultado de checkBoardBoundary(String[][]arr, currentKnightPosition);
		int prevIndexColumn = decomposeArrayColumn(arr2);//valor virá do resultado de checkBoardBoundary(String[][]arr, currentKnightPosition);
		
		//Variáveis para armazenar os próximos valores da posição do cavalo
		int indexRow = 0;
		int indexColumn = 0;
		
		//Validação dos movimentos.
		//Se estiver no canto esquerdo não são válidas as posições de índice: 2, 3, 4, 5
		if( (prevIndexRow == PosicoesCriticas.A1.getIndexRow() && prevIndexColumn == PosicoesCriticas.A1.getIndexColumn()) ||
			(prevIndexRow == PosicoesCriticas.A2.getIndexRow() && prevIndexColumn == PosicoesCriticas.A2.getIndexColumn()) ||
			(prevIndexRow == PosicoesCriticas.A3.getIndexRow() && prevIndexColumn == PosicoesCriticas.A3.getIndexColumn()) ||
			(prevIndexRow == PosicoesCriticas.A4.getIndexRow() && prevIndexColumn == PosicoesCriticas.A4.getIndexColumn()) ||
			(prevIndexRow == PosicoesCriticas.A5.getIndexRow() && prevIndexColumn == PosicoesCriticas.A5.getIndexColumn()) ||
			(prevIndexRow == PosicoesCriticas.A6.getIndexRow() && prevIndexColumn == PosicoesCriticas.A6.getIndexColumn()) || 
			(prevIndexRow == PosicoesCriticas.A7.getIndexRow() && prevIndexColumn == PosicoesCriticas.A7.getIndexColumn()) ||
			(prevIndexRow == PosicoesCriticas.A8.getIndexRow() && prevIndexColumn == PosicoesCriticas.A8.getIndexColumn()))
		{
			int moveNumber = randomNumber.nextInt(0, 8);
			while ( moveNumber >= 2 && moveNumber <=5 )
			{
				moveNumber = randomNumber.nextInt(0, 8);
				//System.out.printf("%d%n", moveNumber);
				indexRow = HORIZONTAL[moveNumber];
				indexColumn = VERTICAL[moveNumber];
			};//fim da sentença de iteração while
			
			System.out.printf("%s:%d%n%s:%d", "Nova linha", indexRow, "Nova coluna", indexColumn);
			
		} else if ( (prevIndexRow == PosicoesCriticas.B8.getIndexRow() && prevIndexColumn == PosicoesCriticas.B8.getIndexColumn()) || 
			(prevIndexRow == PosicoesCriticas.C8.getIndexRow() && prevIndexColumn == PosicoesCriticas.C8.getIndexColumn()) ||
			(prevIndexRow == PosicoesCriticas.D8.getIndexRow() && prevIndexColumn == PosicoesCriticas.D8.getIndexColumn()) || 
			(prevIndexRow == PosicoesCriticas.E8.getIndexRow() && prevIndexColumn == PosicoesCriticas.E8.getIndexColumn()) || 
			(prevIndexRow == PosicoesCriticas.F8.getIndexRow() && prevIndexColumn == PosicoesCriticas.F8.getIndexColumn()) ||
			(prevIndexRow == PosicoesCriticas.G8.getIndexRow() && prevIndexColumn == PosicoesCriticas.G8.getIndexColumn()) ||
			(prevIndexRow == PosicoesCriticas.H8.getIndexRow() && prevIndexColumn == PosicoesCriticas.H8.getIndexColumn()))
		{
			//Se estiver no canto superior não são válidos valores: 0, 1, 2, 3
			int moveNumber = randomNumber.nextInt(0, 8);
			while ( moveNumber <= 3 )
			{
				moveNumber = randomNumber.nextInt(0, 8);
				//System.out.printf("%d%n", moveNumber);
				indexRow = HORIZONTAL[moveNumber];
				indexColumn = VERTICAL[moveNumber];
			};//fim da sentença de iteração while
				
			System.out.printf("%s:%d%n%s:%d", "Nova linha", indexRow, "Nova coluna", indexColumn);
			
		} else if ((prevIndexRow == PosicoesCriticas.H7.getIndexRow() && prevIndexColumn == PosicoesCriticas.H7.getIndexColumn()) || 
			(prevIndexRow == PosicoesCriticas.H6.getIndexRow() && prevIndexColumn == PosicoesCriticas.H6.getIndexColumn()) ||
			(prevIndexRow == PosicoesCriticas.H5.getIndexRow() && prevIndexColumn == PosicoesCriticas.H5.getIndexColumn()) || 
			(prevIndexRow == PosicoesCriticas.H4.getIndexRow() && prevIndexColumn == PosicoesCriticas.H4.getIndexColumn()) || 
			(prevIndexRow == PosicoesCriticas.H3.getIndexRow() && prevIndexColumn == PosicoesCriticas.H3.getIndexColumn()) ||
			(prevIndexRow == PosicoesCriticas.H2.getIndexRow() && prevIndexColumn == PosicoesCriticas.H2.getIndexColumn()) ||
			(prevIndexRow == PosicoesCriticas.H1.getIndexRow() && prevIndexColumn == PosicoesCriticas.H1.getIndexColumn()))
		{
			//Se estiver no canto direito não são válidos valores: 0, 1, 6, 7
			int moveNumber = randomNumber.nextInt(0, 8);
			while ( moveNumber > 2 && moveNumber < 5 )
			{
				moveNumber = randomNumber.nextInt(0, 8);
				System.out.printf("%d%n", moveNumber);
				indexRow = HORIZONTAL[moveNumber];
				indexColumn = VERTICAL[moveNumber];
			};//fim da sentença de iteração while
			
				System.out.printf("%s:%d%n%s:%d", "Nova linha", indexRow, "Nova coluna", indexColumn);
					
		} else if ((prevIndexRow == PosicoesCriticas.G1.getIndexRow() && prevIndexColumn == PosicoesCriticas.H7.getIndexColumn()) || 
			(prevIndexRow == PosicoesCriticas.F1.getIndexRow() && prevIndexColumn == PosicoesCriticas.H6.getIndexColumn()) ||
			(prevIndexRow == PosicoesCriticas.E1.getIndexRow() && prevIndexColumn == PosicoesCriticas.H5.getIndexColumn()) || 
			(prevIndexRow == PosicoesCriticas.D1.getIndexRow() && prevIndexColumn == PosicoesCriticas.H4.getIndexColumn()) || 
			(prevIndexRow == PosicoesCriticas.C1.getIndexRow() && prevIndexColumn == PosicoesCriticas.H3.getIndexColumn()) ||
			(prevIndexRow == PosicoesCriticas.B1.getIndexRow() && prevIndexColumn == PosicoesCriticas.H2.getIndexColumn()))
		{
				//Posições no canto inferior do tabuleiro. Não são válidos valores: 4, 5, 6, 7
				int moveNumber = randomNumber.nextInt(0, 8);
				while ( moveNumber > 3 )
				{
					moveNumber = randomNumber.nextInt(0, 8);
					//System.out.printf("%d%n", moveNumber);
					indexRow = HORIZONTAL[moveNumber];
					indexColumn = VERTICAL[moveNumber];
				};//fim da sentença de iteração while
					
				System.out.printf("%s:%d%n%s:%d", "Nova linha", indexRow, "Nova coluna", indexColumn);
		};//fim da sentença de seleção condicional composta
		
	};//fim do método nextPosition()
	
	private static int[] checkBoardBoundary(String[][]arr, String currentKnightPosition)
	{
		//Recupera os índices da posição atual do cavalo no tabuleiro
		int prevIndexRow = indexRow(arr, currentKnightPosition);
		int prevIndexColumn = indexColumn(arr, currentKnightPosition);
		boolean prevKnightPosition = (prevIndexRow == prevIndexRow && prevIndexColumn == prevIndexColumn); //Utilizado para identificar a posição
		int[]prevIndexRowAndColumn = new int[2]; //array para armazenar o valor da linha e coluna no formato: linha ([0]), coluna([1])
		
		//Críticas, canto esquerdo
		boolean a1 = (prevIndexRow == PosicoesCriticas.A1.getIndexRow() && prevIndexColumn == PosicoesCriticas.A1.getIndexColumn());
		boolean a2 = (prevIndexRow == PosicoesCriticas.A2.getIndexRow() && prevIndexColumn == PosicoesCriticas.A2.getIndexColumn());
		boolean a3 = (prevIndexRow == PosicoesCriticas.A3.getIndexRow() && prevIndexColumn == PosicoesCriticas.A3.getIndexColumn());
		boolean a4 = (prevIndexRow == PosicoesCriticas.A4.getIndexRow() && prevIndexColumn == PosicoesCriticas.A4.getIndexColumn());
		boolean a5 = (prevIndexRow == PosicoesCriticas.A5.getIndexRow() && prevIndexColumn == PosicoesCriticas.A5.getIndexColumn());
		boolean a6 = (prevIndexRow == PosicoesCriticas.A6.getIndexRow() && prevIndexColumn == PosicoesCriticas.A6.getIndexColumn());
		boolean a7 = (prevIndexRow == PosicoesCriticas.A7.getIndexRow() && prevIndexColumn == PosicoesCriticas.A7.getIndexColumn());
		boolean a8 = (prevIndexRow == PosicoesCriticas.A8.getIndexRow() && prevIndexColumn == PosicoesCriticas.A8.getIndexColumn());
	
		//Críticas, canto superior
		boolean b8 = (prevIndexRow == PosicoesCriticas.B8.getIndexRow() && prevIndexColumn == PosicoesCriticas.B8.getIndexColumn());
		boolean c8 = (prevIndexRow == PosicoesCriticas.C8.getIndexRow() && prevIndexColumn == PosicoesCriticas.C8.getIndexColumn());
		boolean d8 = (prevIndexRow == PosicoesCriticas.D8.getIndexRow() && prevIndexColumn == PosicoesCriticas.D8.getIndexColumn());
		boolean e8 = (prevIndexRow == PosicoesCriticas.E8.getIndexRow() && prevIndexColumn == PosicoesCriticas.E8.getIndexColumn());
		boolean f8 = (prevIndexRow == PosicoesCriticas.F8.getIndexRow() && prevIndexColumn == PosicoesCriticas.F8.getIndexColumn());
		boolean g8 = (prevIndexRow == PosicoesCriticas.G8.getIndexRow() && prevIndexColumn == PosicoesCriticas.G8.getIndexColumn());
		boolean h8 = (prevIndexRow == PosicoesCriticas.H8.getIndexRow() && prevIndexColumn == PosicoesCriticas.H8.getIndexColumn());
		//Críticas, canto direito
		boolean h7 = (prevIndexRow == PosicoesCriticas.H7.getIndexRow() && prevIndexColumn == PosicoesCriticas.H7.getIndexColumn());
		boolean h6 = (prevIndexRow == PosicoesCriticas.H6.getIndexRow() && prevIndexColumn == PosicoesCriticas.H6.getIndexColumn());
		boolean h5 = (prevIndexRow == PosicoesCriticas.H5.getIndexRow() && prevIndexColumn == PosicoesCriticas.H5.getIndexColumn());
		boolean h4 = (prevIndexRow == PosicoesCriticas.H4.getIndexRow() && prevIndexColumn == PosicoesCriticas.H4.getIndexColumn());
		boolean h3 = (prevIndexRow == PosicoesCriticas.H3.getIndexRow() && prevIndexColumn == PosicoesCriticas.H3.getIndexColumn());
		boolean h2 = (prevIndexRow == PosicoesCriticas.H2.getIndexRow() && prevIndexColumn == PosicoesCriticas.H2.getIndexColumn());
		boolean h1 = (prevIndexRow == PosicoesCriticas.H1.getIndexRow() && prevIndexColumn == PosicoesCriticas.H1.getIndexColumn());
		//Críticas, canto inferior
		boolean b1 = (prevIndexRow == PosicoesCriticas.B1.getIndexRow() && prevIndexColumn == PosicoesCriticas.B1.getIndexColumn());
		boolean c1 = (prevIndexRow == PosicoesCriticas.C1.getIndexRow() && prevIndexColumn == PosicoesCriticas.C1.getIndexColumn());
		boolean d1 = (prevIndexRow == PosicoesCriticas.D1.getIndexRow() && prevIndexColumn == PosicoesCriticas.D1.getIndexColumn());
		boolean e1 = (prevIndexRow == PosicoesCriticas.E1.getIndexRow() && prevIndexColumn == PosicoesCriticas.E1.getIndexColumn());
		boolean f1 = (prevIndexRow == PosicoesCriticas.F1.getIndexRow() && prevIndexColumn == PosicoesCriticas.F1.getIndexColumn());
		boolean g1 = (prevIndexRow == PosicoesCriticas.G1.getIndexRow() && prevIndexColumn == PosicoesCriticas.G1.getIndexColumn());
		
		//Array de todas as posições críticas
		boolean[] todasPosicoesCriticas = {a1, b1, c1, d1, e1, f1, g1, h1, h2, h3, h4, h5, h6, h7, h8, f8, g8, e8, d8, c8, b8, a8, a7, a6, a5, a4, a3, a2};
		
		for (int i = 0; i < todasPosicoesCriticas.length; i+=1)
		{
			if (prevKnightPosition == todasPosicoesCriticas[i])
			{
				prevIndexRowAndColumn[0] = prevIndexRow;
				prevIndexRowAndColumn[1] = prevIndexColumn;
				break;
			}//fim da sentença de seleção condicional simples
		};//fim da sentença de iteração for
		
		return prevIndexRowAndColumn;
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
/**Essa classe será um tipo enumeração para mapearmos as posições críticas, i.e., posiçõe no tabuleiro 
 * nas quais o cavalo não possa realizar movimentos para esquerda, direita, cima ou baixo por conta da 
 * limitação física de um tabuleiro de xadrez 
 * @author pedro de castro tedesco
 * @since 31/12/2023
 * */
 
public enum PosicoesCriticas
{
	//Constantes enum
	//As constantes serão as posições críticas
	//As posições críticas no lado esquerdo do tabuleiro. Não são permitidos movimentos à esquerda (números negativos de coluna)
	A8("A8", 0, 0), A7("A7", 1, 0), A6("A6", 2, 0), A5("A5", 3, 0), A4("A4", 4, 0), A3("A3", 5, 0), A2("A2", 6, 0), A1("A1", 7, 0),
	//As posições críticas no canto esquerdo (internas)
	B2("B2", 6, 1), B3("B3", 5, 1), B4("B4", 4, 1), B5("B5", 3, 1), B6("B6", 2, 1), B7("B7", 1, 1),
	
	//As posições críticas no canto superior do tabuleiro. Não são permitidos movimentos para cima (números negativos de linha)
	B8("B8", 0, 1), C8("C8", 0, 2), D8 ("D8", 0, 3), E8("E8", 0, 4), F8("F8", 0, 5), G8("G8", 0, 6), H8("H8", 0, 7),
	//As posições críticas no canto superior (internas)
	C7("C7", 1, 2), D7("D7", 1, 3), E7("E7", 1, 4), F7("F7", 1, 5), G7("G7", 1, 6),
	
	//As posições críticas no canto direito do tabuleiro. Não são permitidos movimentos à direita (números positivos de coluna)
	H7("H7", 1, 7), H6("H6", 2, 7), H5("H5", 3, 7), H4("H4", 4, 7), H3("H3", 5, 7), H2("H2", 6, 7), H1("H1", 7, 7),
	//As posições críticas no canto direito (internas)
	G2("G2", 6, 6), G3("G3", 5, 6), G4("G4", 4, 6), G5("G5", 3, 6), G6("G6", 2, 6),	
	
	//As posições críticas no canto inferior do tabuleiro. Não são permitidos movimentos para baixo (números positivos de linha)
	G1("G1", 7, 6), F1("F1", 7, 5), E1("E1", 7, 4), D1("D1", 7, 3), C1("C1", 7, 2), B1("B1", 7, 1),
	//As posições críticas no canto inferior(internas)
	C2("C2", 6, 2), D2("D2", 6, 3), E2("E2", 6, 4), F2("F2", 6, 5);
	
	/**Campos*/
	private String posicao;
	private int indexRow;
	private int indexColumn;
	
	/**Construtor*/
	PosicoesCriticas(String posicao, int indexRow, int indexColumn)
	{
		this.posicao = posicao;
		this.indexRow = indexRow;
		this.indexColumn = indexColumn;
	};//fim do construtor
	
	/**Métodos de consulta*/
	public String getPosicao()
	{
		return posicao;
	};//fim do método getPosicao();
	
	public int getIndexRow()
	{
		return indexRow;
	};//fim do método getIndexRow()
	
	public int getIndexColumn()
	{
		return indexColumn;
	};//fim do método getIndexColumn;
	
	/**Métodos*/
	public String toString()
	{
		return String.format("Posição no tabuleiro: %s%nValor da linha: %d%nValor da coluna: %d%n", getPosicao(), getIndexRow(), getIndexColumn());
	};//fim do método toString();
};//fim do enum PosicoesCriticas
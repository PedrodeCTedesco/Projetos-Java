/** Essa classe enumeração será utilizada para criar as posições do tabuleiro com seu índice de acessibilidade. 
 * 
 * Se o cavalo estiver em C6 ele tem acesso as casas: B8 (3) A7 (3) A5 (4) B4 (4) D4 (8) E5(8) E7 (6) D8 (4)
 * De acordo com a heurística da acessibilidade o cavalo deve se mover preferencialmente para B8 ou A7.
 * 
 * */

public enum PosicoesAcessibilidade 
{
	//As constantes enum
	
	//Nível de acessibilidade: 8
	C3("C3", 5, 2, 8), D3("D3", 5, 3, 8), E3("E3", 5, 4, 8), F3("F3", 5, 5, 8), C4("C4", 4, 2, 8), D4("D4", 4, 3, 8), E4("E4", 4, 4, 8),
	F4("F4", 4, 5, 8), C5("C5", 3, 2, 8), D5("D5", 3, 3, 8), E5("E5", 3, 4, 8), F5("F5", 3, 5, 8), C6("C6", 2, 2, 8), D6("D6", 2, 3, 8),
	E6("E6", 2, 4, 8), F6("F6", 2, 5, 8),
	
	//Nível de acessibilidade: 6
	C2("C2", 6, 2, 6), D2("D2", 6, 3, 6), E2("E2", 6, 4, 6), F2("F2", 6, 5, 6), B3("B3", 5, 1, 6), G3("G3", 5, 6, 6), B4("B4", 4, 1, 6),
	G4("G4", 4, 6, 6), B5("B5", 3, 1, 6), G5("G5", 3, 6, 6), G6("G6", 2, 6, 6), B6("B6", 2, 1, 6), C7("C7", 1, 2, 6), D7("D7", 1, 3, 6), 
	E7("E7", 1, 4, 6), F7("F7", 1, 5, 6),
	
	//Nível de acessibilidade: 4
	F1("F1", 7, 5, 4), E1("E1", 7, 4, 4), D1("D1", 7, 3, 4), C1("C1", 7, 2, 4), G2("G2", 6, 6, 4), B2("B2", 6, 1, 4), A6("A6", 2, 0, 4), 
	A5("A5", 3, 0, 4), A4("A4", 4, 0, 4), A3("A3", 5, 0, 4), H6("H6", 2, 7, 4), H5("H5", 3, 7, 4), H4("H4", 4, 7, 4), H3("H3", 5, 7, 4),
	B7("B7", 1, 1, 4), G7("G7", 1, 6, 4), C8("C8", 0, 2, 4), D8 ("D8", 0, 3, 4), E8("E8", 0, 4, 4), F8("F8", 0, 5, 4),
	
	//Nível de acessibilidade: 3
	A2("A2", 6, 0, 3), B1("B1", 7, 1, 3), G1("G1", 7, 6, 3), H2("H2", 6, 7, 3), A7("A7", 1, 0, 3), B8("B8", 0, 1, 3), G8("G8", 0, 6, 3),
	H7("H7", 1, 7, 3),
	
	//Nível de acessibilidade: 2
	A8("A8", 0, 0, 2), A1("A1", 7, 0, 2), H1("H1", 7, 7, 2), H8("H8", 0, 7, 2);
	
	//Campos
	private String posicao;
	private int row;
	private int column;
	private int access;
	
	//Construtor
	PosicoesAcessibilidade(String posicao, int row, int column, int access)
	{
		this.posicao = posicao;
		this.row = row;
		this.column = column;
		this.access = access;
	};//fim do construtor
	
	/**Métodos de consulta */
	public String getPosicao()
	{
		return posicao;
	}
	
	public int getRow ()
	{
		return row;
	}
	
	public int getColumn()
	{
		return column;
	}
	
	public int getAccess()
	{
		return access;
	}
};//fim da classe enum Acessibilidade
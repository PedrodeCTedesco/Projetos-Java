/**Classe enum para movimentos do cavalo
 * 
 * 	private static final int[] HORIZONTAL = {2, 1, -1, -2, -2, -1, 1, 2}; //mudança de coluna
	private static final int[] VERTICAL = {-1, -2, -2, -1, 1, 2, 2, 1}; //mudança de linha
	
 *  */

public enum MovimentosCavalo
{
	//constantes enum
	Mov0(-1, 2), Mov1(-2, 1), Mov2(-2, -1), Mov3(-1, -2), Mov4(1, -2), Mov5(2, -1), Mov6(2, 1), Mov7(1, 2);
	
	//campos
	private int row;
	private int column;
	
	//construtor;
	MovimentosCavalo (int row, int column)
	{
		this.row = row;
		this.column = column;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getColumn()
	{
		return column;
	}
};//fim da classe enum MovimentosCavalo
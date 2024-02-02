package org.conductor.arrays.arraysMultidimensionais.passeioDoCavalo;

public enum MovimentosDoCavalo
{
    //Enum constants
    Mov0(-1, 2), Mov1(-2, 1), Mov2(-2, -1),
    Mov3(-1, -2), Mov4(1, -2), Mov5(2, -1),
    Mov6(2, 1), Mov7(1, 2);

    //campos
    private final int row;
    private final int column;

    //Constructor
    MovimentosDoCavalo (int row, int column)
    {
        this.row = row;
        this.column = column;
    };//end of constructor

    public int getRow()
    {
        return row;
    };//end of getRow();

    public int getColumn()
    {
        return column;
    };//end of getColumn();
};//end of the enum class

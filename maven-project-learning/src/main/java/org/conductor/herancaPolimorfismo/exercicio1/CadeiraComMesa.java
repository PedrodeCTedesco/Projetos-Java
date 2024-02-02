/**A classe faz parte do exercício sobre Herança e Polimorfismo da
 * disciplina de Laboratório I. É uma subclasse de Cadeira
 * @author Pedro de Castro Tedesco
 * @version 1.0
 * @since 19/10/2023
 */

package org.conductor.herancaPolimorfismo.exercicio1;

public class CadeiraComMesa extends Cadeira
{
    private double width;
    private double depth;
    private Cor color;

    //constructor
    public CadeiraComMesa (Cor color, double width, double depth)
    {
        super();
        this.width = width;
        this.depth = depth;
        this.color = color;
    };//end of constructor

    //query methods
    public double getWidth()
    {
        return width;
    };

    public double getDepth()
    {
        return depth;
    };

    public Cor getChairColor()
    {
        return color;
    }

    //configuration methods
    public void setWidth(double width)
    {
        this.width = width;
    };

    public void setDepth (double depth)
    {
        this.depth = depth;
    };

    @Override
    public String toString()
    {
        return String.format("%nLargura: " + getWidth() + "%nProfundidade: " + getDepth());
    };
};//end of class

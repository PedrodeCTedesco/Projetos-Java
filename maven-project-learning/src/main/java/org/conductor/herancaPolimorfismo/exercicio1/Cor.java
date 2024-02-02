/**A classe faz parte do exercício sobre Herança e Polimorfismo da
 * disciplina de Laboratório I
 * @author Pedro de Castro Tedesco
 * @version 1.0
 * @since 19/10/2023
 */

package org.conductor.herancaPolimorfismo.exercicio1;

public class Cor
{
    private int R;
    private int G;
    private int B;

    public Cor (int R, int G, int B)
    {
        this.R = R;
        this.G = G;
        this.B = B;
    };//end of constructor

    //query methods
    public int getR()
    {
        return R;
    };//end of getR();

    public int getG()
    {
        return G;
    };//end of getG();

    public int getB()
    {
        return B;
    };//end of getB();

    //configuration methods
    public void setR(int R)
    {
        this.R = R;
    };//end of setR(int R);

    public void setG(int G)
    {
        this.G = G;
    };//end of setG(int G);

    public void setB(int B)
    {
        this.B = B;
    };//end of setB(int B);

    @Override
    public String toString()
    {
        return String.format("%nR: %d%nG: %d%nB: %d", getR(), getG(), getB());
    };//end of toString() method
};//end of class Cor

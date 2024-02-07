/**Classe que será superclasse do exercício dirigido n.2 da disciplina de laboratório I.
 * @autor Pedro de Castro Tedesco
 * @since 22/10/2023
 */

package org.conductor.heranca.exercicio2;

public class Figure
{
    private double x;
    private double y;

    public Figure (double x, double y)
    {
        this.x = x;
        this.y = y;
    };

    public Figure () {}

    //quet methods
    public double getX()
    {
        return x;
    };

    public double getY()
    {
        return y;
    };

    //configuration methods
    public void setX (double x)
    {
        this.x = x;
    };

    public void setY (double y)
    {
        this.y = y;
    };

    @Override
    public String toString()
    {
        return String.format("%nO valor da coordenada abscissa é: " + getX() + "%nO valor da coordenada ordenada é: " + getY());
    };
};//end of class Figure

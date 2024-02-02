/**A classe faz parte do exercício sobre Herança e Polimorfismo da
 * disciplina de Laboratório I
 * @author Pedro de Castro Tedesco
 * @version 1.0
 * @since 19/10/2023
 */

package org.conductor.herancaPolimorfismo.exercicio1;

public class Cadeira
{
    private Cor color;
    private Aluno aluno;

    //Constructor
    public Cadeira (Cor color)
    {
        this.color = color;
        aluno = null;
    };

    //query methods
    public Cor getColor()
    {
        return color;
    };

    public Aluno getAluno()
    {
        return aluno;
    };

    //configuration methods
    public void setColor(Cor color)
    {
        this.color = color;
    };

    public void setAluno (Aluno aluno)
    {
        this.aluno = aluno;
    };

    @Override
    public String toString()
    {
        return String.format("%nCor da cadeira: " + getColor() + "%nAluno que a ocupa: " + getAluno());
    };
};//end of Cadeira class

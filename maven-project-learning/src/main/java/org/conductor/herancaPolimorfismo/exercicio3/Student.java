/**Classe que pertence a atividade de estudo dirigido sobre Herança e Polimorfismo
 * da disciplina de Laboratório I
 * @author Pedro de Castro Tedesco
 * @since 23/10/2023
 * @see ./Exercicio3/Grau.java
 */

package org.conductor.herancaPolimorfismo.exercicio3;

public class Student
{
    private String name;
    private GrauA ga;
    private GrauB gb;

    //Constructor
    public Student (String name, GrauA ga, GrauB gb)
    {
        this.name = name;
        this.ga = ga;
        this.gb = gb;
    };

    //query methods
    public String getName()
    {
        return name;
    };

    public GrauA getGa()
    {
        return ga;
    };

    public GrauB getGb()
    {
        return gb;
    };

    //configuration methods
    public void setName(String name)
    {
        this.name = name;
    };

    public void setGa(GrauA ga)
    {
        this.ga = ga;
    };

    public void setGb(GrauB gb)
    {
        this.gb = gb;
    };

    //client methods
    public double finalGrade()
    {
        return (this.getGa().calculaNotaFinalGrau() * 0.33) + (this.getGb().calculaNotaFinalGrau() * 0.67);
    };//Fim do método calculaNotaFinal()

    public String toString()
    {
        Double notaA = this.getGa().calculaNotaFinalGrau();
        Double notaB = this.getGb().calculaNotaFinalGrau();
        return String.format("\nNome do aluno: %s\nNota da prova de grau A: %.2f\nNota da prova de grau B: %.2f", this.getNome(), notaA, notaB);
    };//Fim da classe toString();
}

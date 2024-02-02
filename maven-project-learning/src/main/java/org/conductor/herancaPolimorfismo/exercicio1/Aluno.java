/**A classe faz parte do exercício sobre Herança e Polimorfismo da
 * disciplina de Laboratório I
 * @author Pedro de Castro Tedesco
 * @version 1.0
 * @since 19/10/2023
 */

package org.conductor.herancaPolimorfismo.exercicio1;

public class Aluno
{
    private String name;
    private int age;

    public Aluno (String name, int age)
    {
        this.name = name;
        this.age = age;
    };

    //query methods
    public String getName()
    {
        return name;
    };

    public Integer getAge()
    {
        return age;
    };

    //configuration methods
    public void setName(String name)
    {
        this.name = name;
    };

    public void setAge (int age) {
        this.age = age;
    };

    @Override
    public String toString()
    {
        return String.format("%nNome: %s%nIdade:%d", getName(), getAge());
    };
};//end of class

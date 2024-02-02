/** Classe criada para entender melhor o funcionamento do modificador static em um campo e método (campos e métodos de classe).
 * @author pedro de castro tedesco
 * @link Java: Como programar (Deitel e Deitel, 10ª ed, cap. 8)
 * */


package org.conductor.classesEobjetos.estudoAprofundado.employee;

public class Employee
{
    /**CAMPOS.
     * A variável static será utilizada para manter a contagem do número de objetos
     * Employee presentes na memória */
    private static int count = 0; //Se não inicializarmos o campo agora o compilador fornecerá seu valor padrão
    private String firstName;
    private String lastName;

    /**CONSTRUTOR
     * */
    public Employee (String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;

        //Toda vez que o construtor for invocado ele incrementará o valor da contadem de empregados
        //Note que é um operador de incremento pré-fixado. Logo, o valor trabalhado é o valor já atualizado
        ++count;
        System.out.printf("Employee constructor: %s %s; count: %d%n", firstName, lastName, count);
    };//fim do construtor

    /**MÉTODOS DE CONSULTA
     * */
    public String getFirstName()
    {
        return firstName;
    };//fim do método getFirstName()

    public String getLastName()
    {
        return lastName;
    };//fim do método getLastName();

    //O método abaixo é estático e serve exclusivamente para sabermos a quantidade de instâncias da classe presentes em memória
    //Ainda, sendo um método estático qualquer instância da classe terá acesso a essa informação
    public static int getCount()
    {
        return count;
    };//fim do método getCount();
}

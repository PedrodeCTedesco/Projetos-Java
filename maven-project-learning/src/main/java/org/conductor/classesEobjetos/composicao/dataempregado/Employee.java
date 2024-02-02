package org.conductor.classesEobjetos.composicao.dataempregado;

public class Employee
{
    /**CAMPOS. Todos são variáveis de instância. Note que dois dos campos são referências a instâncias da classe Date
     * -firstName: String --> o primeiro nome do empregado.
     * -lastName: String --> o sobrenome do empregado.
     * -hireDate: Date --> a data de contratação do empregado.
     * -birthDate: Date --> a data de nascimento do empregado.
     * */
    private String firstName;
    private String lastName;
    private Date hireDate;
    private Date birthDate;

    public Employee (String firstName, String lastName, Date hireDate, Date birthDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
    };//fim do construtor

    /**MÉTODOS
     * +toString(): String --> retorna uma String com as informações da instância.
     * @return String
     * */
    public String toString()
    {
        //Repare que como estamos formatando as saídas como Strings, o método toString() da classe Date é
        //implicitamente invocado quando os objetos da classe são invocados.
        return String.format("%s, %s, Hired: %s Birthday: %s", lastName, firstName, hireDate, birthDate);
    };//fim do método toString();
}

package org.conductor.classesEobjetos.composicao.dataempregado;

public class EmployeeTest
{
    public static void main (String[]args)
    {
        //Criação em tempo de execução dos objetos
        Date birth = new Date(7, 24, 1949);
        Date hire = new Date (3, 12, 1988);
        Employee employee = new Employee("Bob", "Blue", hire, birth);

        //Invocação implícita do método toString() de Employee
        System.out.println(employee);
    };//fim do método main
}

package org.conductor.classesEobjetos.estudoAprofundado.time;

public class Time1Test
{
    public static void main(String[]args)
    {
        //Cria e inicializa uma instância de Time1
        //Note que o construtor utilizado é o construtor padrão fornecido pelo compilador.
        Time1 time = new Time1();

        //Gera saídas de data nos formatos universal e padrão
        displayTime("After time object is created", time);
        System.out.println();

        //Alterando a data/hora e gerando saída de data e hora atualizada
        time.setTime1(13, 27, 6);
        displayTime("After calling setTime", time);
        System.out.println();

        //Tentando definir hora com valores inválidos
        try
        {
            time.setTime1(99, 99, 99);
        } catch (IllegalArgumentException e)
        {
            System.out.printf("Exception: %s%n%n", e.getMessage());
        };//fim do tratamento de exceções

        displayTime("After calling setTime with invalid values", time);
    };//fim do método main

    //O método displayTime(String header, Time1 t) é um método com modificador de acesso 'private' porque diz respeito a
    //detalhes da implementação. Isso significa que ele não pode ser acessado por outros métodos, nem mesmo pelo cliente da classe.
    private static void displayTime(String header, Time1 t)
    {
        System.out.printf("%s%nUniversal time: %s%nStandard time: %s%n", header, t.toUniversalString(), t.toString());
    };//fim do método displayTime(String header, Time1 t);
}

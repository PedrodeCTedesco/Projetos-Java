package org.conductor.classesEobjetos.estudoAprofundado.time2;

public class Time2Test
{
    public static void main (String[]args)
    {
        /**Criando as instâncias de Time2*/
        Time2 t1 = new Time2(); //invoca o construtor sem parâmetros. Terá a hora universal 00:00:00
        Time2 t2 = new Time2(2); //invoca o construtor com 1 parâmetro (hora). Terá hora 02:00:00
        Time2 t3 = new Time2(23, 54); //invoca o construtor com 2 parâmetros (hora, minuto). Terá hora 23:54:00
        Time2 t4 = new Time2(11, 44, 52); //invoca o construtor com 3 parâmetrs (hora, minuto, segundo). Terá hora 11:44:52
        Time2 t5 = new Time2(t4); //invoca o construtor que tem como parâmetro uma instância da classe. Terá o mesmo horário de t4.

        System.out.println("Constructed with:");
        displayTime("t1: all default arguments", t1);
        displayTime("t2: hour specified; default minute and second", t2);
        displayTime("t3: hour and minute specified; default second", t3);
        displayTime("t4: hour, minute and second specified", t4);
        displayTime("t5: Time2 object t4 specified", t5);

        /**Tentando inicializar uma instância da classe com valores inválidos*/
        try
        {
            Time2 t6 = new Time2(99, 542, 1);
        } catch (IllegalArgumentException e)
        {
            System.out.printf("%nException while initializing t6: %s%n", e.getMessage());
        };//fim do tratamento de exceções
    };//fim da classe main

    /**Método utilitário*/
    private static void displayTime(String header, Time2 t)
    {
        System.out.printf("%s%n      %s%n      %s%n", header, t.toUniversalString(), t.toString());
    };//fim do método displayTime(String header, Time2 t);
}

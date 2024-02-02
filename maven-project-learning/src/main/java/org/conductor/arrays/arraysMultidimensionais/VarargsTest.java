package org.conductor.arrays.arraysMultidimensionais;

public class VarargsTest
{
    //Método para calcular a média de valores independente da quantidade de valores recebermos
    public static double media (double... numbers)
    {
        double total = 0.0;

        for (double numero : numbers)
        {
            total += numero;
        };//fim da sentença de iteração for aprimorado

        return total / numbers.length;
    };//fim do método media(double... numbers);


    public static void main (String[] args)
    {
        double n1 = 4.1;
        double n2 = 5.2;
        double n3 = 10;
        double n4 = 6.9;
        double n5 = 9.7;
        double n6 = 8.4;
        double n7 = 6.1;
        double n8 = 9.6;
        double n9 = 9.7;
        double n10 = 8.4;

        System.out.printf("Média com 2 argumentos: %.1f%n", media(n4, n5));
        System.out.printf("Média com 3 argumentos: %.1f%n", media(n1, n4, n5));
        System.out.printf("Média com 4 argumentos: %.1f%n", media(n1, n4, n5, n8));
        System.out.printf("Média com 5 argumentos: %.1f%n", media(n2, n3, n4, n7, n8));
        System.out.printf("Média com 6 argumentos: %.1f%n", media(n1, n2, n3, n4, n5, n7));
        System.out.printf("Média com 7 argumentos: %.1f%n", media(n1, n3, n4, n5, n7, n8, n10));
        System.out.printf("Média com 8 argumentos: %.1f%n", media(n1, n3, n4, n5, n7, n8, n9, n10));
        System.out.printf("Média com 9 argumentos: %.1f%n", media(n1, n2, n3, n4, n5, n6, n7, n8, n9));
        System.out.printf("Média com 10 argumentos: %.1f%n", media(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10));

    };//fim do método main

}

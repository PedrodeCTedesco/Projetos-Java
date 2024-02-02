package org.conductor.arrays.arraysDePrimitivos.jogoDeDados;

import java.util.Random;
public class JogoDeDados
{
    public static void main (String[]args)
    {
        //Criação do cabeçalho para exibição dos dados
        System.out.printf("%6s%15s%n", "Soma", "Frequência");

        //Variáveis de instância geradas em tempo de execução para os valores dos dados
        int dado1 = 0;
        int dado2 = 0;

        //Array de inteiro gerado em tempo de execução cujas posições de índice servirão de contadores dos resultados
        int[]frequencia = new int [13];

        //Lançando o dado 36.000.000 de vezes
        for(int counter = 0; counter < 36000000; counter += 1)
        {
            //Realizando o lançamento dos dados
            dado1 = lancaDados();
            dado2 = lancaDados();

            ++frequencia[somaDados(dado1, dado2)];
        };//fim da sentença de iteração for

        //Apresentando a frequência dos resultados dos lançamentos anteriores
        for (int resultado = 0; resultado < frequencia.length; resultado += 1)
        {
            System.out.printf("%5d%10d%n", resultado, frequencia[resultado]);
        };//fim da sentença de iteração for

        /**	 -----INSTRUÇÃO PARA TESTE DOS MÉTODOS ----
         //Instrução para realizar o lançamento dos dados
         for (int i = 0; i < resultados.length; i += 1)
         {
         dado1 = lancaDados();
         dado2 = lancaDados();

         valorDado1[i] = dado1;
         valorDado2[i] = dado2;
         resultados[i] = somaDados(dado1, dado2);
         };//fim da sentença de iteração for

         */

    };//fim da classe main

    /**CAMPOS. Todos são variáveis de instância
     * dado1: int --> o primeiro dado;
     * dado2: int --> o segundo dado;
     * */
    private int dado1;
    private int dado2;

    private static int lancaDados()
    {
        //Instanciar um objeto da classe Random
        Random randomNumber = new Random();

        //O objeto deve retornar um valor entre 1 e 6 (ambos inclusos)
        int valor = randomNumber.nextInt(1, 7);

        return valor;
    };//fim da classe lancaDados();

    private static int somaDados(int d1, int d2)
    {
        int soma = d1 + d2;
        return soma;
    };//fim do método somaDados(int d1, int d2);

    public static void displayArray(int[] arr)
    {

        for (int x : arr)
        {
            System.out.printf("%d ", x);
        }
    };//fim do método displayArray(int[]arr)
}

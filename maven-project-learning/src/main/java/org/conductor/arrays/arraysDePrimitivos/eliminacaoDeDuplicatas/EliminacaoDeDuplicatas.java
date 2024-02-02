package org.conductor.arrays.arraysDePrimitivos.eliminacaoDeDuplicatas;

import java.util.Scanner;
public class EliminacaoDeDuplicatas
{
    public static void main (String[]args)
    {

        Scanner input = new Scanner (System.in);

        int[] array = new int [5];
        int i = 0;

        while (i <= 4)
        {
            System.out.printf("Digite um número: ");
            int num = Integer.parseInt(input.nextLine());

            if (num < 10 || num > 100)
            {
                System.out.printf("%s%n", "Erro, número deve estar entre 10 e 100 (incluso)");

            } else
            {
                int verificador = addItem(array,num);

                switch (verificador)
                {
                    case 1:
                        System.out.printf("Numero repetido %n");
                        break;

                    case 0:
                        array[i] = num;
                        i+=1;
                        break;
                };//fim da sentença de seleção múltipla
            };//fim da sentença de seleção composta
        };//fim da sentença de iteração while

        //Apresentando os valores únicos digitados pelo usuário
        displayArray(array);

    };//fim do método main

    private static int addItem(int[]arr, int item)
    {
        int verdadeiro = 1;
        int falso = 0;

        for (int i = 0; i < arr.length; i += 1)
        {
            if (arr[i] == item)
            {
                return verdadeiro;
            };//fim da sentença de seleção simples
        };//fim da sentença de iteração for
        return falso;
    };//fim do método addItem(int[]arr, int item);

    private static void displayArray (int[] arr)
    {
        for (int i = 0; i < arr.length; i += 1)
        {
            if (arr[i] != 0)
            {
                System.out.printf("%n%s: %d%n", "Valores do array", arr[i]);
            };//fim da sentença de seleção simples
        };//fim da sentença de iteração for
    };//fim do método displayArray(int[]arr);
}

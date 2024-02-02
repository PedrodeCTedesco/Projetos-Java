package org.conductor.arrays.arraysDeObjetos;

import java.util.Scanner;

public class ExerciciosTeste
{
    public static void main(String[] args)
    {
        Exercicios ex = new Exercicios();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = {11, 12, 13};
        String[] arrayString = {"Pedro", "Eduarda", "Ana", "Vera", "Paulo", "Lua", "Vênus", "Nuvem"};
        boolean[] bool = {true, true, true, false, true, false, false, true, false, false, false};
        int[] array3 = {-1, 4, 5, -23, 2, 0, 5, -3};
        int[] array4 = {12, 5, 2, 64, -1231, 5, 41, -22, -1};
        char[] char1 = {'A', 'm', '$', 's', 'l', 'P'};
        int x = 2;
        double[] d1 = {1.23, -0.5, 12, 5.6};
        char[] char2 = {'p', 'e', 'd', 'r', 'o'};

        ex.exercicio1(array);

        System.out.println("\nExercício 3: ");
        ex.exercicio3(array);

        System.out.println("\nExercício 4: ");
        ex.exercicio4(arrayString, "Lopes");

        System.out.println("\nExercício 5: ");
        ex.exercicio5(bool);

        System.out.println("\nExercício 6: ");
        ex.exercicio6(array, array2);

        System.out.println("\nExercício 7: ");
        ex.exercicio7(array3, array4);

        System.out.println("\nExercício 8: ");
        ex.exercicio8(char1);

        System.out.println("\nExercício 9: ");
        ex.exercicio9(array);

        System.out.println("\nExercício 10: ");
        ex.exercicio10(array);

        System.out.println("\nExercício 11: ");
        ex.exercicio11(array, x);

        System.out.println("\nExercício 12: ");
        ex.exercicio12(d1);

        System.out.println("\nExercício 13: ");
        ex.exercicio13(array4);

        System.out.println("\nExercício 14: ");
        ex.exercicio14(array3);

        System.out.println("\nExercício 15: ");
        ex.exercicio15(array4);

        System.out.println("\nExercício 16: ");
        ex.exercicio16(array4);

        System.out.println("\nExercício 17: ");
        ex.exercicio17(array4, array);

        System.out.println("\nExercício 18: ");
        ex.exercicio18(char2);

        //Para exercício 19

        Scanner input = new Scanner (System.in);

        System.out.println("Por favor, quantos números inteiros você deseja inserir?");
        int count = Integer.parseInt(input.nextLine());
        int contador = 0;
        int[] array19 = new int[count];

        while (contador < count)
        {
            int numeros = 0;

            System.out.print("Insira o valor inteiro: ");
            numeros = Integer.parseInt(input.nextLine());
            array19[contador] = numeros;
            contador += 1;
        };//fim do while

        ex.exercicio19(array19);
    };//Fim do método main

};//end of ExerciciosTeste

package org.conductor.iteracao.forExamples;

import java.util.Scanner;

public class ExerciciosTeste
{
    public static void main (String[] args) {
        //Instanciando Exercicios
        Exercicios testeFor = new Exercicios();
        Integer num, num1, num2;

        //Solicitando as entradas de cada método
        Scanner input = new Scanner(System.in);

        //Exercicio 1
        System.out.println("***Exercício 1***");
        System.out.println("Informe a quantidade de pessoas que você desejada cadastrar: ");
        num = Integer.parseInt(input.nextLine());
        testeFor.exercicio1(num);

        //Exercício 2
        System.out.println("***Exercício 2***");
        System.out.println("Informe um número e imprimirei na tela todos os números de 0 até o número informado por você: ");
        num = Integer.parseInt(input.nextLine());
        testeFor.exercicio2(num);

        //Exercício 3
        System.out.println("***Exercício 3***");
        System.out.print("Informe um número e imprimirei os números pares de 0 até o número indicado: ");
        num = Integer.parseInt(input.nextLine());
        testeFor.exercicio3(num);

        //Exercício 4
        System.out.println("***Exercício 4***");
        System.out.print("Informe um número " + "x" + " e imprimirei os números em ordem decrescente a partir do número inserido por você: ");
        num = Integer.parseInt(input.nextLine());
        testeFor.exercicio4(num);

        //Exercício 5
        System.out.println("***Exercício 5***");
        System.out.print("Informe quantos usuários serão cadastrados: ");
        num = Integer.parseInt(input.nextLine());
        testeFor.exercicio5(num);

        //Exercício 6
        System.out.println("***Exercício 6***");
        System.out.print("Informe quantos números de ponto flutuante você deseja somar: ");
        num = Integer.parseInt(input.nextLine());
        testeFor.exercicio6(num);

        //Exercício 7
        System.out.println("***Exercício 7***");
        System.out.print("Informe quantos números inteiros você deseja somar: ");
        num = Integer.parseInt(input.nextLine());
        testeFor.exercicio7(num);

        //Exercício 8
        System.out.println("***Exercício 8***");
        System.out.println("Informe os números e saiba quais são positivos, negativos ou são 0.");
        System.out.print("Quantos números você digitará: ");
        num = Integer.parseInt(input.nextLine());
        testeFor.exercicio8(num);

        //Exercício 9
        System.out.println("***Exercício 9***");
        System.out.println("Informe 2 números inteiros e imprimerei todos os números entre eles.");
        System.out.println("Informe o primeiro número inteiro: ");
        num1 = Integer.parseInt(input.nextLine());

        System.out.println("Informe o segundo número inteiro: ");
        num2 = Integer.parseInt(input.nextLine());
        testeFor.exercicio9(num1, num2);

        //Exercício 10
        System.out.println("***Exercício 10***");
        System.out.println("Este método retorna a soma dos números entre 0 e 198. Deseja continuar?");
        System.out.print("Digite 1 para sim; digite 0 para não.");
        num = Integer.parseInt(input.nextLine());
        testeFor.exercicio10(num);

        //Exercício 11
        System.out.println("***Exercício 11***");
        System.out.println("Este método retorna a soma dos números ímpares entre dois números inseridos por você.");
        System.out.print("Informe o número inicial: ");
        num1 = Integer.parseInt(input.nextLine());

        System.out.print("Informe o número final: ");
        num2 = Integer.parseInt(input.nextLine());
        testeFor.exercicio11(num1, num2);

        //Exercício 12
        System.out.println("***Exercício 12***");
        System.out.println("Digite quantos números inteiros positivos você quiser. Ao inserir um número negativo retornarmos a média de todos os inteiros digitados antes do número negativo.");
        testeFor.exercicio12();

        //Exercício 13
        System.out.println("***Exercício 13***");
        System.out.print("Este método calcula o fatorial de um número inteiro.");
        System.out.print("Insira o número que você deseja calcular o fatorial: ");
        num = Integer.parseInt(input.nextLine());
        testeFor.exercicio13(num);

        //Exercício 14
        System.out.println("***Exercício 14***");
        System.out.print("Insira um número inteiro para saber se ele é primo: ");
        num = Integer.parseInt(input.nextLine());
        testeFor.exercicio14(num);

        //Exercício 15
        System.out.println("***Exercício 15***");
        System.out.print("Insira um número inteiro para todos os números primos entre zero e o número inserido por você.");
        System.out.print("Além disso, saiba a soma destes números.");
        System.out.print("Informe o número desejado: ");
        num = Integer.parseInt(input.nextLine());
        testeFor.exercicio15(num);

        input.close();

    };
}

package org.conductor.iteracao.whileExamples;

import java.util.Scanner;
public class Main
{
    public static void main (String[] args) {
        //Atributos

        Exercicios ex1;
        Integer exit, option, num;

        //Scanner

        Scanner input = new Scanner (System.in);

        //Imprimir um menu com as opções de 1 a 3

        exit = 0;

        System.out.print("Olá! A seguir temos opções de operações para você realizar:\n 1 - Contagem até 300; \n 2 - Impressão de números pares inteiros; \n 3 - Verifique se um número é primo; \n Digite 0 para sair do programa.");
        System.out.println("Informe a opção desejada: ");
        option = Integer.parseInt(input.nextLine());

        while (exit != option) {

            ex1 = new Exercicios();

            if (option == 1) {
                System.out.println("Você selecionou a opção de contagem até 300.");
                System.out.print("Informe o inteiro desejado: ");
                num = Integer.parseInt(input.nextLine());

                ex1.contador(num);
            }

            if (option == 2) {
                System.out.println("Você selecionou a opção de impressão de números pares.");
                System.out.print("Informe o inteiro desejado para impressão de todos os pares entre 0 e o inteiro indicado por você: ");
                num = Integer.parseInt(input.nextLine());
                ex1.imprimePares(num);
            };

            if (option == 3) {
                System.out.println("Você selecionou a opção de verificação de número primo.");
                System.out.print("Informe o número que você deseja saber se é primo: ");
                num = Integer.parseInt(input.nextLine());

                if (ex1.verificaPrimo(num)) {
                    System.out.print("O número " + num + " é primo.\n");
                } else {
                    System.out.print("O número " + num + " não é primo.\n");
                }
            }

            System.out.println("O que gostaria de realizar agora? Digite a opção desejada: ");
            option = Integer.parseInt(input.nextLine());
        };

        input.close();

    }

}

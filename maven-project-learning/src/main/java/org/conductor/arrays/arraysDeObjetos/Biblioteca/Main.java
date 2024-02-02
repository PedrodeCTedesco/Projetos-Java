package org.conductor.arrays.arraysDeObjetos.Biblioteca;

import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class Main
{
    public static void main (String[] args)
    {
        //Classe para geração de números aleatórios
        Random randomNumber = new Random ();

        //Variáveis para a geração de titulos aleatórios e nomes de autores aleatórios
        final String[] TITULOS = {"Venus", "Grama", "Caminhao", "Arroz", "Palmeira", "Luz"};
        final String[] AUTORES = {"Eduarda", "Pedro", "Foucalt", "Bill", "Jazira"};

        //Variáveis para contagem da quantidade de livros antigos e novos
        int countNovo = 0;
        int countAntigo = 0;

        //Criando uma biblioteca com um número entre 1 e 200.
        int capacidadeLivrosBiblioteca = randomNumber.nextInt(201);
        Biblioteca biblioteca = new Biblioteca (capacidadeLivrosBiblioteca);
        System.out.printf("A capacidade da biblioteca é de %d livros\n", capacidadeLivrosBiblioteca);

        //Sorteando um valor entre 1 e 300
        int quant = randomNumber.nextInt(301);

        //Iniciando um sorteio entre 1 e 2 para inserir os livros na Biblioteca.
        //Criando a variável de contagem de ciclos da sentença de iteração while
        int j = 0;

        while (j < capacidadeLivrosBiblioteca)
        {
            //Variável sorteio para criação de livros antigos e novos.
            int sorteio = randomNumber.nextInt(2) + 1;

            switch (sorteio)
            {
                case 1:
                    //Valores das variáveis para o Livro
                    String titulo = TITULOS[randomNumber.nextInt(6)];
                    String autor = AUTORES[randomNumber.nextInt(4)];
                    double preco = randomNumber.nextDouble(200);
                    int ano = randomNumber.nextInt(2023);
                    double valorDesconto = randomNumber.nextDouble(100);

                    //Instanciação do Livro novo
                    biblioteca.insereLivro(new Novo(titulo, autor, preco, ano, valorDesconto));
                    System.out.println("Inserido livro do tipo Novo.");
                    countNovo += 1;
                    break;

                case 2:
                    //Valores das variáveis para o livro antigo
                    titulo = TITULOS[randomNumber.nextInt(5)];
                    autor = AUTORES[randomNumber.nextInt(4)];
                    preco = randomNumber.nextDouble(200);
                    ano = randomNumber.nextInt(2023);
                    int edicaoLivro = randomNumber.nextInt(2023);

                    //Instanciação do Livro antigo
                    biblioteca.insereLivro(new Antigo(titulo, autor, preco, ano, edicaoLivro));
                    System.out.println("Inserido livro do tipo Antigo.\n");
                    countAntigo += 1;
            };//fim do switch
            j += 1;

        };//fim do while

        //Apresentando quantos livros novos e quantos livros antigos
        System.out.printf("Temos %d livros novos.\n", countNovo);
        System.out.printf("Temos %d livros antigos.\n", countAntigo);

        //Solicitando que o usuário procure pelo título de um livro
        Scanner input = new Scanner (System.in);

        System.out.print("Por favor, insira o título do livro que deseja buscar: ");
        String buscaPorLivro = input.nextLine();

        biblioteca.procuraLivroPorTitulo(buscaPorLivro);

        //Solicitando ao usuário que informe o título do livro do qual deseja verificar o desconto
        System.out.println("Por favor, insira o título do livro cujo desconto você deseja saber o valor: ");
        String buscaPorLivroDesconto = input.nextLine();

        System.out.print("O livro que você busca é: " + biblioteca.verificaDesconto(buscaPorLivroDesconto));

        input.close();

        //Imprimindo o valor das edições dos livros antigos
        System.out.println("As edições dos livros antigos na biblioteca são: ");
        biblioteca.imprimeEdicoes();

        //Imprimindo os livros em ordem decrescente do ano de criação
        //A ideia é organizar o array em ordem ascedente da data de criação e depois reverter sua ordem
        System.out.println("Livros ordenados por ordem de publicação de forma decrescente: ");
        biblioteca.imprimeLivroPorAno();

        //Imprimindo a média dos preços dos livros
        System.out.printf("O valor médio dos livros da biblioteca é: %.2f\n", biblioteca.calculaMediaPreco());

        //Informações do livro com maior título
        System.out.print("O livro com maior título é: " + biblioteca.livroComMaiorTitulo());

    };//fim do método main
}

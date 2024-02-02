package org.conductor.selecao;

import java.util.Scanner;
public class Main
{
    public static void main (String[] args) {

        //Atributos

        String nome, sexo, endereco;
        Integer idade, qtdIrmaos, cadastro;
        Double altura;

        //Scanner

        Scanner input = new Scanner(System.in);

        //Criando o cadastro de pessoas
        //Variável tipo List que armazenará as pessoas cadastradas
        //Variável que indicará a quantidade de pessoas cadastradas

        System.out.println("Informe quantas pessoas deseja cadastrar no sistema: ");
        cadastro = Integer.parseInt(input.nextLine());

        Pessoa[] pessoasCadastradas = new Pessoa[cadastro];

        //Sentença de iteração

        for (Integer i = 0; i < cadastro; i++) {

            System.out.println("Informe o nome do cadastro número " + i + ": ");
            nome = input.nextLine();
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Informe o sexo do cadastro número " + i + ": ");
            sexo = input.nextLine();
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Informe o endereço do cadastro número: " + i + ": ");
            endereco = input.nextLine();
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Informe a idade do cadastro número " + i + ": ");
            idade = Integer.parseInt(input.nextLine());
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Informe a quantidade de irmãos do cadastro número " + i + ": ");
            qtdIrmaos = Integer.parseInt(input.nextLine());
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Informe a altura do cadastro número: " + i + ": ");
            altura = Double.parseDouble(input.nextLine());
            input.skip("((?<!\\R)\\s)*");

            pessoasCadastradas[i] = new Pessoa (nome, sexo, endereco, idade, qtdIrmaos, altura);
        };

        input.close();

        //Sentença de iteração para impressão dos dados das pessoas cadastradas

        for (Integer i = 0; i < cadastro; i++) {
            System.out.println(pessoasCadastradas[i].toString());
        };

        //Imprimindo a frase "Filho(a) único(a)" para quem é filho(a) único(a)
        //e a frase "Não é filho(a) único(a)" para quem não é

        for (Pessoa filhoUnico : pessoasCadastradas) {
            if (filhoUnico.isFilhoUnico(filhoUnico)) {
                System.out.println(filhoUnico.getNome() + " é filho único");
            };

            if (filhoUnico.isFilhoUnico(filhoUnico) == false) {
                System.out.println(filhoUnico.getNome() + " não é filho único.");
            }
        }

    }
}

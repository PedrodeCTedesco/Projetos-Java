package lab1_javaExercicios;
import java.util.Scanner;


public class Main {
    public static void main (String[] args) {

        //Livros. Declaração das variáveis

        String tituloLivro, autorLivro;
        Integer pubLivro, qtdPagLivro;
        Double valorLivro;

        //Instância do objeto Scanner e criação do array

        Scanner input = new Scanner (System.in);
        Livro Livros[] = new Livro[3];

        //Laço for

        for (Integer i = 0; i < 3; i++) {

            System.out.println("Digite o título do livro: ");
            tituloLivro = input.nextLine();
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Digite o nome do autor: ");
            autorLivro = input.nextLine();
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Digite o ano de publicação do livro: ");
            pubLivro = Integer.parseInt(input.nextLine());
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Insira a quantidade de páginas do livro: ");
            qtdPagLivro = Integer.parseInt(input.nextLine());
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Insira o valor do livro: ");
            valorLivro = Double.parseDouble(input.nextLine());
            input.skip("((?<!\\R)\\s)*");

            Livros[i] = new Livro (tituloLivro, autorLivro, pubLivro, qtdPagLivro, valorLivro);
            Double resultado = Livros[i].valorPrecoPorPagina(qtdPagLivro, valorLivro);
            System.out.print("O valor do preço por página do livro " + Livros[i].getTitulo() + " é: " + resultado + "\n");
        };

        System.out.print("Os livros registrados são: " + "\n");

        for (Integer i = 0; i < 3; i++) {
            Livros[i].informacoesLivro();
        };

        //Clientes. Declaração das variáveis

        String nome, email, sexo;
        Integer idade, senha;

        //Criação do array de objetos CLiente

        Cliente Clientes[] = new Cliente[3];

        //Laço for para criação de múltiplos objetos

        for (Integer i = 0; i < 3; i++) {

            System.out.println("Informe o nome do(a) cliente: ");
            nome = input.nextLine();
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Informe o e-mail do(a) cliente: ");
            email = input.nextLine();
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Informa a idade do(a) cliente: ");
            idade = Integer.parseInt(input.nextLine());
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Informe a senha do(a) cliente: ");
            senha = Integer.parseInt(input.nextLine());
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Informe o sexo do cliente. \n" + "M para masculino e F para feminino: ");
            sexo = input.nextLine();             
            input.skip("((?<!\\R)\\s)*");

            Clientes[i] = new Cliente(nome, email, idade, senha, sexo);
        };
        input.close();

        System.out.print("Os dados cadastrados são: ");
        for (Integer i = 0; i < 3; i++) {
            Clientes[i].imprimeInformacoes();
        };
    };
;}

package lab1_javaExercicios_5;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

    //Atributos

    String nome;
    Double preco;
    Prateleira prateleiraP1;
    Produto prod1, prod2, prod3;

    //Scanner

    Scanner input = new Scanner(System.in);

    //Criando uma prateleira com 3 produtos a partir do teclado


    Produto[] produtosMercado = new Produto[3];

    for (Integer i = 0; i < 3; i++) {

        Data dataDeValidade = new Data();

        System.out.print("Informe o primeiro produto: ");
        nome = input.nextLine();

        System.out.print("Informe o preço do(a) " + nome + ": ");
        preco = Double.parseDouble(input.nextLine());

        System.out.println("Informe a validade do(a) " + nome );

        System.out.print("Dia: ");
        dataDeValidade.setDia(Integer.parseInt(input.nextLine()));

        System.out.print("Mês: ");
        dataDeValidade.setMes(Integer.parseInt(input.nextLine()));

        System.out.print("Ano: ");
        dataDeValidade.setAno(Integer.parseInt(input.nextLine()));

        produtosMercado[i] = new Produto (nome, preco, dataDeValidade);
 
        };

        prateleiraP1 = new Prateleira ();

        prod1 = produtosMercado[0];
        prod2 = produtosMercado[1];
        prod3 = produtosMercado[2];

        prateleiraP1.setProduto1(prod1);
        prateleiraP1.setProduto2(prod2);
        prateleiraP1.setProduto3(prod3);

        System.out.println(prateleiraP1);

        //Crie uma prateleira sem produtos. Na sequência inserir um produto

        Data dataDeValidadeCortina = new Data (4, 12, 2012);
        Produto cortina = new Produto("Cortina", 167.98, dataDeValidadeCortina);
        Prateleira prateleiraP2 = new Prateleira ();
        prateleiraP2.setProduto1(cortina);

        //Crie um mercado com 2 prateleiras. A prateleirzaCortina e produtosMercado;

        Mercado mercadoTedesco = new Mercado (prateleiraP1, prateleiraP2); 
        
        //Mostrar na tela as informações dos produtos vencidos supondo a data 25/04/2023
        //Produtos: prod1, prod2, prod3, cortina

        Data dataDeComparacao = new Data (3, 10, 2023);

        System.out.println("*** Produtos vencidos ***");
        System.out.println(prateleiraP1.getProduto1().getNome() + " está vencido? " + prateleiraP1.getProduto1().verificaProduto(dataDeComparacao, prateleiraP1.getProduto1().getDataDeValidade()));
        System.out.println(prateleiraP1.getProduto2().getNome() + " está vencido? " + prateleiraP1.getProduto2().verificaProduto(dataDeComparacao, prateleiraP1.getProduto2().getDataDeValidade()));
        System.out.println(prateleiraP1.getProduto3().getNome() + " está vencido? " + prateleiraP1.getProduto3().verificaProduto(dataDeComparacao, prateleiraP1.getProduto3().getDataDeValidade()));
        System.out.println(prateleiraP2.getProduto1().getNome() + " está vencido? " + prateleiraP2.getProduto1().verificaProduto(dataDeComparacao, prateleiraP2.getProduto1().getDataDeValidade()));

        //Média dos valores dos produtos do mercado

        System.out.println(mercadoTedesco.mediaValorProdutos());
        input.close();

    };
}
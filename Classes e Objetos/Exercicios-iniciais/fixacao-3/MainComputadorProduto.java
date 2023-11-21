package lab1_javaExercicios_3;
import java.util.Scanner;

public class MainComputadorProduto {
    public static void main (String[] args) {

    //Declarando as variáveis da classe Produto

    String nome, descricao;
    Double valor;
    Integer qtdEstoque;

    //Declarando as variáveis da classe Computador

    String marca;
    Double velocidade;
    Integer anoFabricacao;
    Boolean novo = true;

    //Instanciando Scanner

    Scanner input = new Scanner (System.in);

    //Criando um novo Computador

    System.out.println("Insira as informações do novo computador: ");
    marca = input.nextLine();
    input.skip("((?<!\\R)\\s)*");

    System.out.println("Velocidade: ");
    velocidade = Double.parseDouble(input.nextLine());   
    input.skip("((?<!\\R)\\s)*");

    System.out.println("Ano de fabricação: ");
    anoFabricacao = Integer.parseInt(input.nextLine());
    input.skip("((?<!\\R)\\s)*");

    Computador vostroPC = new Computador (marca, velocidade, anoFabricacao, novo);

    //Criando um novo Produto

    System.out.println("Iniciemos o registro do novo produto.\n");
    System.out.println("Insira o nome do produto: ");
    nome = input.nextLine();
    input.skip("((?<!\\R)\\s)*");

    System.out.println("Descrição: ");
    descricao = input.nextLine();
    input.skip("((?<!\\R)\\s)*");

    System.out.println("Valor do produto: ");
    valor = Double.parseDouble(input.nextLine());
    input.skip("((?<!\\R)\\s)*");

    System.out.println("Quantidade disponível em estoque: ");
    qtdEstoque = Integer.parseInt(input.nextLine());
    input.skip("((?<!\\R)\\s)*");

    Produto novoProduto = new Produto(nome, descricao, valor, qtdEstoque, vostroPC);

    //Utilizando um método da classe Computador na instância da classe Produto

    novoProduto.infoPc();
    input.close();
    };
};
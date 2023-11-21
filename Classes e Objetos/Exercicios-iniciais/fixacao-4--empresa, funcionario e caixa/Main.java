package lab1_javaExercicios_4;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        //Atributos necessários. Ordem: FuncionarioCaixa, Calculadora, Empresa

        String nome, endereco, sexo, cor, nomeEmpresa;
        Integer memoria = 0;
        
        //Instanciando Scanner

        Scanner input = new Scanner (System.in);

        //Criando um funcionário

        System.out.println("Informe o nome do(a) funcionário(a): ");
        nome = input.nextLine();
        input.skip("((?<!\\R)\\s)*");

        System.out.println("Informe o endereço do(a) funcionário(a): ");
        endereco = input.nextLine();
        input.skip("((?<!\\R)\\s)*");

        System.out.println("Informe o sexo do(a) funcionário(a): ");
        sexo = input.nextLine();
        input.skip("((?<!\\R)\\s)*");

        //Configurando as cores das calculadoras dos funcionários

        System.out.println("Informe a cor da calculadora do(a) primeiro(a) funcionário(a): ");
        cor = input.nextLine();

        Calculadora calcFuncionario1 = new Calculadora (cor, memoria);

        System.out.println("Informe a cor da calculadora do(a) segundo(a) funcionário(a): ");
        cor = input.nextLine();

        Calculadora calcFuncionario2 = new Calculadora (cor, memoria);

        FuncionarioCaixa funcionario = new FuncionarioCaixa (nome, endereco, sexo, calcFuncionario1);

        //Operações solicitadas

        System.out.print("*****Resultados das operações*****");

        System.out.println(funcionario.somaFuncionario(2.0, 2.0));
        System.out.println(funcionario.subtraiFuncionario(5.0, 4.0));
        System.out.println(funcionario.multiplicaFuncionario(2.0, 3.0));
        System.out.println(funcionario.divideFuncionario(6.0, 3.0));
        System.out.println(funcionario.elevaAoQuadradoFuncionario(72));
        System.out.println(funcionario.elevaAoCuboFuncionario(83));

        //Criando uma empresa e um novo funcionário

        System.out.println("Informe o nome da empresa: ");
        nomeEmpresa = input.nextLine();
        input.skip("((?<!\\R)\\s)*");

        System.out.println("Informe o nome do(a) funcionário(a): ");
        nome = input.nextLine();
        input.skip("((?<!\\R)\\s)*");

        System.out.println("Informe o endereço do(a) funcionário(a): ");
        endereco = input.nextLine();
        input.skip("((?<!\\R)\\s)*");

        System.out.println("Informe o sexo do(a) funcionário(a): ");
        sexo = input.nextLine();
        input.skip("((?<!\\R)\\s)*");

        FuncionarioCaixa funcionario2 = new FuncionarioCaixa (nome, endereco, sexo, calcFuncionario2);
        Empresa empresa1 = new Empresa (nomeEmpresa, funcionario.getNome(), funcionario2.getNome());


        //Exibindo informações da empresa

        System.out.println("***INFORMAÇÕES DA EMPRESA***");

        empresa1.imprimeInfoEmpresa();

        System.out.println("***INFORMAÇÕES DAS CALCULADORAS***");

        calcFuncionario1.imprimeInfo();
        calcFuncionario2.imprimeInfo();

        System.out.println("***INFORMAÇÕES DOS FUNCIONÁRIOS***");

        funcionario.imprimeInfoFuncionario();
        funcionario2.imprimeInfoFuncionario();

        input.close();
    }
}

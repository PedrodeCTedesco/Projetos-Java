package lab1_javaExercicios_2;
import java.util.Scanner;


public class MainAluno {
    public static void main (String[] args) {

        //Declaração das variáveis da classe Aluno

        String nome;
        Integer matricula;
        Double notaGrauA, notaGrauB;

        //Declaração da variável de alteração de nota

        Double novaNota;

        //Declaração do objeto Scanner

        Scanner input = new Scanner (System.in);

        //Inicialização do array que armazenará os objetos da classe Aluno

        Aluno[] AlunosUni = new Aluno [3];

        //Sentença de iteração for para criação dos objetos da classe Aluno

        for (Integer i = 0; i < 3; i++) {
            System.out.println("Insira o nome do(a) aluno(a): ");
            nome = input.nextLine();
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Informe o número da matrícula do(a) aluno(a): ");
            matricula = Integer.parseInt(input.nextLine());
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Informe a nota de Grau A do(a) aluno(a): ");
            notaGrauA = Double.parseDouble(input.nextLine());
            input.skip("((?<!\\R)\\s)*");

            System.out.println("Informe a nota de Grau B do(a) aluno(a): ");
            notaGrauB = Double.parseDouble(input.nextLine());
            input.skip("((?<!\\R)\\s)*");

            AlunosUni[i] = new Aluno (nome, matricula, notaGrauA, notaGrauB);
        };

        //Imprimindo os dados recebidos

        System.out.println("Você inseriu os dados dos(as) seguintes alunos(as): \n");
        
        for (Integer i = 0; i < 3; i++) {
            AlunosUni[i].imprimeInfo();
        };

        //Alterações

        AlunosUni[1].setNotaGrauA(9.0);

        //Dados atualizados da aluna Radibunda

        System.out.println("A média final de " + AlunosUni[1].getNome() + " é: " + AlunosUni[1].calculaMediaFinal(AlunosUni[1].getNotaGrauA(), AlunosUni[1].getNotaGrauB()));

        //Imprimindo matrícula do aluno Vitimado

        System.out.println("A matrícula de: " + AlunosUni[2].getNome() + " é: " + AlunosUni[2].getMatricula());

        //Alterando a matrícula do aluno Brandamente

        AlunosUni[0].setMatricula(1585228);

        //Alterando a nota de grau B da aluna Radibunda por um valor lido do teclado

        System.out.println("Insira o valor da nota de grau B da aluna " + AlunosUni[1].getNome() + ": ");
        novaNota = Double.parseDouble(input.nextLine());
        AlunosUni[1].setNotaGrauB(novaNota);
        input.close();

        //Exibindo novamente as informações dos alunos

        for (Integer i = 0; i < 3; i++) {
            AlunosUni[i].imprimeInfo();
        };
    };
};

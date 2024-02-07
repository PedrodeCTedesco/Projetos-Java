/**Classe de teste para o exercício 1 da série de exercícios da disciplina de Laboratório I
 * sobre Herança e Polimorfismo.
 * @author Pedro de Castro Tedesco
 * @since 19/10/2023
 */

package org.conductor.heranca.exercicio1;

import java.util.Scanner;
public class PrincipalExercicio1
{
    public static void main (String[] args)
    {
        /**Criação da instância para entrada de dados */
        Scanner input = new Scanner(System.in);

        /**Criando as cores.
         * O usuário entrará 4 cores pelo teclado.
         * Sentença de iteração for será utilizada para que ele dê a entrada das cores.
         */

        Cor Cores[] = new Cor[4];

        for (Integer i = 0; i < 4; i++)
        {
            String posicoes[] = {"primeira", "segunda", "terceira", "quarta"};

            /**Criando as instâncias de cores */
            System.out.printf("Insira a cor da %s cadeira no formato RGB.", posicoes[i]);
            System.out.print("\nR: ");
            Integer R = Integer.parseInt(input.nextLine());

            System.out.print("\nG: ");
            Integer G = Integer.parseInt(input.nextLine());

            System.out.print("\nB: ");
            Integer B = Integer.parseInt(input.nextLine());

            Cores[i] = new Cor (R, G, B);

        };//Fim da sentença de iteração for

        /**Criação das cadeiras.
         * A lógica será idêntica a da criação das cores.
         */

        Cadeira cadeiras[] = new Cadeira[5];

        for (Integer i = 0; i < cadeiras.length - 1; i++)
        {
            String posicoes[] = {"primeira", "segunda", "terceira", "quarta"};
            Integer escolhaDaMesa;

            System.out.print("Qual o tipo de cadeira que você deseja que a sala possua?\nDigite \"1\" para uma cadeira com mesa;\nDigite \"2\" para uma cadeira com rodinhas: ");
            escolhaDaMesa = Integer.parseInt(input.nextLine());

            if (escolhaDaMesa == 1)
            {
                Double largura, profundidade;
                System.out.print("\nQual a largura da " + posicoes[i] + " mesa: ");
                largura = Double.parseDouble(input.nextLine());

                System.out.print("\nQual a profundidade da " + posicoes[i] + " mesa: ");
                profundidade = Double.parseDouble(input.nextLine());

                cadeiras[i] = new CadeiraComMesa (Cores[i], largura, profundidade);

            } else if (escolhaDaMesa == 2)
            {
                Data data;
                Integer dia, mes, ano;

                System.out.println("Insira a data da última manutenção.");

                System.out.print("\nDia: ");
                dia = Integer.parseInt(input.nextLine());
                input.skip("((?<!\\R)\\s)*");

                System.out.print("\nMês: ");
                mes = Integer.parseInt(input.next());
                input.nextLine();

                System.out.print("\nAno: ");
                ano = Integer.parseInt(input.nextLine());

                data = new Data (dia, mes, ano);
                data.getAno();
                cadeiras[i] = new CadeiraComRodinhas(Cores[i], data);

            } else
            {
                System.out.print("Insira uma opção válida");
            }
        };//Fim da sentença de iteração for

        /**Criando instância da classe Sala */
        System.out.println("Insira o nome da sala: ");
        String nome = input.nextLine();

        /**Criando uma variável que armazenará um número inteiro aleatório. */

        Cadeira cadeira1 = cadeiras[0];
        Cadeira cadeira2 = cadeiras[1];
        Cadeira cadeira3 = cadeiras[2];
        Cadeira cadeira4 = cadeiras[3];

        Sala sala = new Sala (nome, cadeira1, cadeira2, cadeira3, cadeira4);
        System.out.print(sala.toString());

        /**Encerrando a captação de dados */
        input.close();

        System.out.println("\nMesa: " + sala.cadeirasComMesaDisponiveis());
        System.out.println("Rodinha: " + sala.cadeirasComRodinhasDisponiveis());

        Aluno a1 = new Aluno("Pedro", 31);
        Aluno a2 = new Aluno ("Eduarda", 27);
        Aluno a3 = new Aluno ("Lorenzo", 29);
        Aluno a4 = new Aluno ("Sofia", 26);
        Aluno a5 = new Aluno ("Cicero", 32);
        sala.entraAluno(a1, "Mesa");
        sala.entraAluno(a2, "Rodinha");
        sala.entraAluno(a3, "rodinha");
        sala.entraAluno(a4, "mesa");
        sala.entraAluno(a5, "rodinha");
    };//Fim do método main
}

package org.conductor.arrays.arraysDePrimitivos.passagensAereas;

import java.util.Scanner;

public class ReservaDePassagensAereas
{
    public static void main(String[]args)
    {

        //Objeto para capturar input do usuário
        Scanner input = new Scanner(System.in);

        //Saídas de interação com o usuário
        //Variável gerada em tempo de execução para gerenciar as escolhas do usuário
        int opcao = 0;
        int counter = 0;

        System.out.printf("%s%n%s%n%s%n", "Qual sua opção?", "Digite \"1\" para poltronas na primeira classe", "Digite \"2\" para poltronas na classe econômica");

        while (counter != 10)
        {
            System.out.printf("Qual sua opção? Digite aqui: ");
            opcao = Integer.parseInt(input.nextLine());

            sistemaDeReservaDePassagensAereas(opcao);
            counter = todasAsPoltronasOcupadas(assentosDisponiveis);
        };//fim da sentença de iteração while

    };//fim do método main

    /**CAMPOS
     * +assentosDisponiveis: boolean[] --> um array de booleanos que representam a disponibilidade de assentos no avião. Todas as posições estão vagas (false);
     * */
    public static boolean[] assentosDisponiveis = new boolean[11];

    private static boolean primeiraClasseReserva(boolean[] arr)
    {
        //Variáveis de validação da operação
        int indicePassagem = 0;

        //Restringir até a posição 6 do array
        for (int i = 1; i < 6; i+=1)
        {
            if (!arr[i] && !arr[i])
            {
                arr[i] = true;
                indicePassagem = i;
                System.out.printf("%s%n%s%n%s%d%n", "CARTÃO DE EMBARQUE", "Primeira classe", "Poltrona: ", indicePassagem);
                return true;
            };//fim da sentença de seleção simples
        };//fim da sentença de iteração for
        return false;
    };//fim do método primeiraClasse();

    private static int primeiraClasseCheia(boolean arr[])
    {
        //Variável de apoio
        int counter = 0;

        for (int i = 0; i < 6; i += 1)
        {
            if (arr[i])
            {
                counter+=1;
            }//fim da sentença de seleção condicional simples
        };//fim da sentença de iteração for

        switch(counter)
        {
            case 5:
                System.out.printf("%s%n", "Todas as poltronas na primeira classe estão ocupadas");
                break;
        };//fim da sentença de seleção múltipla
        return counter;
    };//fim do método primeiraClasseCheia(boolean arr[])

    private static boolean classeEconomicaReserva(boolean[]arr)
    {
        //Variáveis de validação da operação
        int indicePassagem = 0;

        //Iniciar a partir da posição 6 do array
        for (int i = 6; i < 11; i+=1)
        {
            if (!arr[i] && !arr[i])
            {
                arr[i] = true;
                indicePassagem = i;
                System.out.printf("%s%n%s%n%s%d%n", "CARTÃO DE EMBARQUE", "Classe econômica", "Poltrona: ", indicePassagem);
                return true;
            };//fim da sentença de seleção simples
        };//fim da sentença de iteração for
        return false;
    };//fim do método classeEconomicaReserva(boolean[]arr);

    private static int classeEconomicaCheia(boolean[]arr)
    {
        //Variável de apoio
        int counter = 0;

        for (int i = 6; i < 11; i += 1)
        {
            if (arr[i] == true)
            {
                counter+=1;
            }//fim da sentença de seleção condicional simples
        };//fim da sentença de iteração for

        switch(counter)
        {
            case 5:
                System.out.printf("%s%n", "Todas as poltronas na classe econômica estão ocupadas");
                break;
        };//fim da sentença de seleção múltipla
        return counter;
    };//fim do método classeEconomicaCheia(boolean[]arr);

    private static int todasAsPoltronasOcupadas(boolean[]arr)
    {
        int counter = 0;

        for (int i = 0; i < arr.length; i += 1)
        {
            if (arr[i] == true)
            {
                counter+=1;
            }//fim da sentença de seleção condicional simples
        };//fim da sentença de iteração for
        return counter;
    };//fim do método todasAsPoltronasOcupadas(boolean[]arr)

    public static void sistemaDeReservaDePassagensAereas(int op)
    {
        Scanner input = new Scanner (System.in);
        //Sentença de seleção múltipla para venda das poltronas
        switch (op)
        {
            case 1:
                //Verifica se é possível realizar a reserva
                primeiraClasseReserva(assentosDisponiveis);

                //Avisa se não há mais poltronas disponíveis na primeira classe
                if (primeiraClasseCheia(assentosDisponiveis) == 5)
                {
                    System.out.printf("%s%n%s%n%s%n", "Você deseja uma poltrona na classe econômica?", "Digite \"Sim\" para realizar a troca caso tenhamos poltronas disponíveis na classe econômica", "Digite  \"Não\" para não realizar a troca e aguardar o próximo voo");

                    String decisao = input.nextLine();
                    String afirmativo = "Sim";

                    if (decisao.equalsIgnoreCase(afirmativo))
                    {
                        boolean d = classeEconomicaReserva(assentosDisponiveis);
                        System.out.printf("%s%n", (d == true) ? "Troca de poltronas concluída. Confira seu cartão de embarque." : "Não temos mais poltronas disponíveis na classe econômica.");
                        break;
                    } else
                    {
                        System.out.printf("%s%n", "Próximo voo parte em 3 horas");
                        break;
                    }//fim da sentença de seleção condicional composta
                }//fim da sentença de seleção condicional simples
                break;
            case 2:
                //Verifica se é possível realizar a reserva
                classeEconomicaReserva(assentosDisponiveis);

                //Avisa se não há mais poltronas disponíveis na classe econômica
                if (classeEconomicaCheia(assentosDisponiveis) == 5)
                {

                    System.out.printf("%s%n%s%n%s%n", "Você deseja uma poltrona na primeira classe?", "Digite \"Sim\" para realizar a troca caso tenhamos poltronas disponíveis na primeira classe", "Digite  \"Não\" para não realizar a troca e aguardar o próximo voo");
                    String decisao = input.nextLine();
                    String afirmativo = "Sim";

                    if (decisao.equalsIgnoreCase(afirmativo))
                    {
                        boolean d = primeiraClasseReserva(assentosDisponiveis);
                        System.out.printf("%s%n", (d == true)? "Troca de poltronas concluída. Confira seu cartão de embarque." : "Não temos mais poltronas disponíveis na primeira classe.");
                        break;
                    } else
                    {
                        System.out.printf("%s%n", "Próximo voo parte em 3 horas");
                        break;
                    }//fim da sentença de seleção condicional composta
                }//fim da sentença de seleção condicional simples
                break;
        };//fim da sentença de seleção múltipla
    };//fim do método trocaDeClasse(boolean[]arr);
}

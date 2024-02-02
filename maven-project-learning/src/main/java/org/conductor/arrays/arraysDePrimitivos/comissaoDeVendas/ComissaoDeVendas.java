package org.conductor.arrays.arraysDePrimitivos.comissaoDeVendas;

public class ComissaoDeVendas
{
    public static void main (String[]args)
    {
        //Gerando o array em formato tabular
        System.out.printf("%5s%25s%8s%12s%18s%n", "Intervalo", "Salário base", "Bônus", "Comissão", "Salário mensal");

        for(int i = 0; i < INTERVALOS.length; i += 1)
        {
            System.out.printf("%s%12.1f%12.1f%10.1f%15.1f%n", INTERVALOS[i], SALARIO_BASE, BONUS, valorComissao(VENDAS_BRUTAS[i]), salarioMensal(VENDAS_BRUTAS[i]));
        };//fim da sentença de iteração

    };//fim do método main


    /**INTEFACE PÚBLICA */

    /**Campos
     * BONUS: double --> representa o bônus cujo valor fixo é de R$ 200,00
     * */

    static final double BONUS = 200;
    static final double SALARIO_BASE = 5000;
    static final String[] INTERVALOS = {"R$ 200,00 - 299,00", "R$ 300,00 - 399,00", "R$ 400,00 - 499,00", "R$ 500,00 - 599,00", "R$ 600,00 - 699,00", "R$ 700,00 - 799,00", "R$ 800,00 - 899,00", "R$ 900,00 - 999,00", "R$ 1.000,00 - mais"};
    static final double[] VENDAS_BRUTAS = {270, 390, 460, 560, 699, 730, 811, 987, 1340};

    private static double valorComissao(double vendasBrutas)
    {
        /**Variável de apoio
         * PERCENTUAL: double {valor constante}*/
        final double PERCENTUAL = 0.09;
        double valorComissao = 0.0;

        valorComissao = vendasBrutas * PERCENTUAL;

        return valorComissao;
    };//fim do método valorComissao(double vendasBrutas);

    private static double salarioMensal(double vendasBrutas)
    {
        double salario = SALARIO_BASE + BONUS + valorComissao(vendasBrutas);
        return salario;
    };//fim do método salario();

}

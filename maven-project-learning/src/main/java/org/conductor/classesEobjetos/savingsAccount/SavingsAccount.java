/** Crie uma classe SavingsAccount. Utilize uma variável static annualInterestRate para armazenar a taxa de juros anual para todos os correntistas.
 *  Cada objeto da classe contém uma variável de instância private savingsBalance para indicar a quantidade que o poupador atualmente tem em
 *  depósito. Forneça o método calculateMonthlyInterest para calcular os juros mensais multiplicando o savingsBalance por annualInterestRate
 *  dividido por 12 — esses juros devem ser adicionados ao savingsBalance. Forneça um método static modifyInterestRate que configure o
 *   annualInterestRate com um novo valor. Escreva um programa para testar a classe SavingsAccount. Instancie dois objetos savingsAccount,
 *   saver1 e saver2, com saldos de R$ 2.000,00 e R$ 3.000,00, respectivamente. Configure annualInterestRate como 4% e então calcule o juro mensal
 *   de cada um dos 12 meses e imprima os novos saldos para os dois poupadores. Em seguida, configure annualInterestRate para 5%, calcule a
 *   taxa do próximo mês e imprima os novos saldos para os dois poupadores.
 */

package org.conductor.classesEobjetos.savingsAccount;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.Locale;

public class SavingsAccount
{
    /** CAMPOS.
     * -annualInterestRate: BigDecimal --> para armazenar o valor da taxa de juros anual para todos os correntistas.
     * -savingsBalance: BigDecimal --> indica a quantidade que o poupador atualmente tem em depósito.
     * */
    private static double annualInterestRate;
    private double savingsBalance;

    /** CONSTRUTOR*/
    public SavingsAccount(double savingsBalance)
    {
        if (savingsBalance < 0.0)
        {
            throw new IllegalArgumentException("The initial amount cannot be less tha zero.");
        };//fim da sentença de seleção condicional simples

        this.savingsBalance = savingsBalance;
    };//fim do construtor

    /** MÉTODOS DE CONSULTA
     * */
    public static double getAnnualInterestRate()
    {
        return annualInterestRate;
    };//fim do método getAnnualInterestRate()

    public double getSavingsBalance()
    {
        return savingsBalance;
    };//fim do método getSavingsBalance()

    /** MÉTODOS MODIFICADORES
     * */
    public void setSavingsBalance(double savingsBalance)
    {
        this.savingsBalance = savingsBalance;
    };//fim do método setSavingsBalance(double savingsBalance);

    /** MÉTODOS
     * */
    public double calculateMonthlyInterest ()
    {
        //Cálculo:
        //Etapa 1: multiplicar o savingsBalance por annualInterestRate
        //Etapa 2: dividir o resultado da etapa 1 por 12;
        //Etapa 3: retornar esse valor para adicionar esses juros devem ser adicionados ao valor de savingsBalance
        return (savingsBalance * annualInterestRate) / 12;
    };//fim do método calculateMonthlyInterest()

    public void addMonthlyInterest (double monthlyInterest)
    {
        savingsBalance+=monthlyInterest;
    };//fim do método addMonthlyInterest(BigDecimal monthlyInterest);

    public static void modifyInterestRate (double newAnnualInterestRate)
    {
        if (annualInterestRate < 0.0)
        {
            throw new IllegalArgumentException("The value of interest rate cannot be smaller than zero.");
        };//fim da sentença de seleção condicional simples

        annualInterestRate = newAnnualInterestRate;
    };//fim do método setAnnualInterestRate(double annualInterestRate)
}

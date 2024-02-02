/** Classe de teste da classe SavingsAccount. Objetivo do teste:
 * Instancie dois objetos savingsAccount, saver1 e saver2, com saldos de R$ 2.000,00 e R$ 3.000,00, respectivamente.
 * Configure annualInterestRate como 4% e então calcule o juro mensal de cada um dos 12 meses e imprima os novos saldos
 * para os dois poupadores. Em seguida, configure annualInterestRate para 5%, calcule a taxa do próximo mês e imprima os
 * novos saldos para os dois poupadores.
 */

package org.conductor.classesEobjetos.savingsAccount;

public class SavingsAccountTest
{
    public static void main (String[]args)
    {
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);

        System.out.printf("Initial balance on saver1: %.2f -- Initial annual interest rate: %.2f%n", saver1.getSavingsBalance(), saver1.getAnnualInterestRate());
        System.out.printf("Initial balance on saver1: %.2f -- Initial annual interest rate: %.2f%n", saver2.getSavingsBalance(), saver2.getAnnualInterestRate());

        //Configurando a taxa de juros para 4%
        SavingsAccount.modifyInterestRate(0.04);
        System.out.printf("New annual interest rate: %.2f%n", SavingsAccount.getAnnualInterestRate());

        //Calculando os juros mensais
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        //Verificando o valor dos juros mensais
        System.out.printf("Monthly interest rate for saver1: %.2f%n", saver1.calculateMonthlyInterest());
        System.out.printf("Monthly interest rate for saver2: %.2f%n", saver2.calculateMonthlyInterest());

        //Adicionar os valores dos juros em cada conta
        saver1.addMonthlyInterest(saver1.calculateMonthlyInterest());
        saver2.addMonthlyInterest(saver2.calculateMonthlyInterest());

        //Exibindo os novos valores em conta
        System.out.printf("Actual savings balance for saver1: %.2f%n", saver1.getSavingsBalance());
        System.out.printf("Actual savings balance for saver2: %.2f%n", saver2.getSavingsBalance());

        //Configurando a taxa de juros para 5%
        SavingsAccount.modifyInterestRate(0.05);
        System.out.printf("New annual interest rate: %.2f%n", SavingsAccount.getAnnualInterestRate());

        //Calculando os juros mensais
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        //Verificando o valor dos juros mensais
        System.out.printf("Monthly interest rate for saver1: %.2f%n", saver1.calculateMonthlyInterest());
        System.out.printf("Monthly interest rate for saver2: %.2f%n", saver2.calculateMonthlyInterest());

        //Adicionar os valores dos juros em cada conta
        saver1.addMonthlyInterest(saver1.calculateMonthlyInterest());
        saver2.addMonthlyInterest(saver2.calculateMonthlyInterest());

        //Exibindo os novos valores em conta
        System.out.printf("Actual savings balance for saver1: %.2f%n", saver1.getSavingsBalance());
        System.out.printf("Actual savings balance for saver2: %.2f%n", saver2.getSavingsBalance());
    };//fim do método main
}

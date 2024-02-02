package org.conductor.iteracao.whileExamples;

public class Exercicios
{
    //Atributos
    Exercicios ex1;

    //Construtor

    public Exercicios () {};

    //Métodos

    public void contador (Integer inicioContagem) {

        //Variável de iteração

        Integer contador = 300;

        if (inicioContagem ==0) {
            System.out.print("Informe um número maior do que zero.");
        };

        if (inicioContagem > 300) {
            System.out.print("O número deve ser menor do que 300 e maior do que 0.");
        }

        while (contador >= inicioContagem) {

            System.out.println(inicioContagem);
            inicioContagem++;
        };
    }

    public void imprimePares (Integer num) {
        if (num < 0) {
            System.out.println("O inteiro inserido é menor do que zero.");
        };

        if (num % 2 == 0) {

            Integer contador = 0;

            while (contador <= num) {

                System.out.println(contador);
                contador++;
                contador++;
            };
        };

        if (num % 2 != 0) {

            Integer contador = 0;

            while (contador < num) {
                System.out.println(contador);
                contador++;
                contador++;
            };
        };
    }

    public Boolean verificaPrimo (Integer num) {
        if (num % num == 0 && num % 1 == 0 && num > 1) {
            return true;
        } else {
            return false;
        }
    }

}

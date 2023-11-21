/**Classe principal do exercício 2 de Laboratório 1
 * @author Pedro de Castro Tedesco
 * @see ./Exercicio2/Figura.java
 */

import Exercicio2.Circulo;
import Exercicio2.Figura;
import Exercicio2.Retangulo;
import java.util.Random;

public class PrincipalExercicio2 
{
    public static void main (String[] args)
    {
        /**Criando as 4 referências do tipo Figura */
        Random randomNumber = new Random();

        Figura fig1 = new Circulo (randomNumber.nextDouble(0, 10) * 10);
        Figura fig2 = new Circulo (randomNumber.nextDouble(0, 10) * 10);
        Figura fig3 = new Retangulo(randomNumber.nextDouble(0, 10) * 10, randomNumber.nextDouble(0, 10) * 10);
        Figura fig4 = new Retangulo (randomNumber.nextDouble(0, 10) * 10, randomNumber.nextDouble(0, 10) * 10);

        /**Imprima a área de cada figura dependendo se for um círculo ou um retângulo */

        if (fig1 instanceof Retangulo)
        {
            System.out.printf("\nA área do retângulo é: %f", ((Retangulo)fig1).calculaArea());
        }
    
        if (fig1 instanceof Circulo)
        {
            System.out.printf("\nA área do círculo é: %f", ((Circulo)fig1).calculaArea());
        }

        System.out.print(fig1.toString());

        if (fig2 instanceof Retangulo)
        {
            System.out.printf("\nA área do retângulo é: %f", ((Retangulo)fig2).calculaArea());
        }

        if (fig2 instanceof Circulo)
        {
            System.out.printf("\nA área do círculo é: %f", ((Circulo)fig2).calculaArea());
        }

        System.out.print(fig2.toString());

        if (fig3 instanceof Retangulo)
        {
            System.out.printf("\nA área do retângulo é: %f", ((Retangulo)fig3).calculaArea());
        }

        if (fig3 instanceof Circulo)
        {
            System.out.printf("\nA área do círculo é: %f", ((Circulo)fig3).calculaArea());
        }

        System.out.print(fig3.toString());

        if (fig4 instanceof Retangulo)
        {
            System.out.printf("\nA área do retângulo é: %f", ((Retangulo)fig4).calculaArea());
        }

        if (fig4 instanceof Circulo)
        {
            System.out.printf("\nA área do círculo é: %f", ((Circulo)fig4).calculaArea());
        }

        System.out.print(fig4.toString());


    };//Fim do método main
};//Fim da classe 

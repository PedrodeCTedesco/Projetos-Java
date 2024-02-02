/**Classe principal do exercício 2 de Laboratório 1
 * @author Pedro de Castro Tedesco
 * @see ./Exercicio2/Figura.java
 */

package org.conductor.herancaPolimorfismo.exercicio2;
import java.util.Random;
public class Main
{
    public static void main (String[] args)
    {
        Random randomNumber = new Random();

        Figure fig1 = new Circle (randomNumber.nextDouble(0, 10) * 10);
        Figure fig2 = new Circle (randomNumber.nextDouble(0, 10) * 10);
        Figure fig3 = new Rectangle(randomNumber.nextDouble(0, 10) * 10, randomNumber.nextDouble(0, 10) * 10);
        Figure fig4 = new Rectangle (randomNumber.nextDouble(0, 10) * 10, randomNumber.nextDouble(0, 10) * 10);


        if (fig1 instanceof Rectangle)
        {
            System.out.printf("%nA área do retângulo é: %.2f", ((Rectangle)fig1).rectangleArea());
        }

        if (fig1 instanceof Circle)
        {
            System.out.printf("\nA área do círculo é: %f", ((Circle)fig1).circleArea());
        }

        System.out.print(fig1.toString());

        if (fig2 instanceof Rectangle)
        {
            System.out.printf("%nA área do retângulo é: %f", ((Rectangle)fig2).rectangleArea());
        }

        if (fig2 instanceof Circle)
        {
            System.out.printf("\nA área do círculo é: %f", ((Circle)fig2).circleArea());
        }

        System.out.print(fig2.toString());

        if (fig3 instanceof Rectangle)
        {
            System.out.printf("\nA área do retângulo é: %f", ((Rectangle)fig3).rectangleArea());
        }

        if (fig3 instanceof Circle)
        {
            System.out.printf("\nA área do círculo é: %f", ((Circle)fig3).circleArea());
        }

        System.out.print(fig3.toString());

        if (fig4 instanceof Rectangle)
        {
            System.out.printf("\nA área do retângulo é: %f", ((Rectangle)fig4).rectangleArea());
        }

        if (fig4 instanceof Circle)
        {
            System.out.printf("\nA área do círculo é: %f", ((Circle)fig4).circleArea());
        }

        System.out.print(fig4.toString());

};//end of class Main

/** Classe de teste para a classe Rational
 * @author pedro de castro tedesco
 * @link "Java: como programar" (Deitel e Deitel, 10ªed, cap. 8)
 * @since 24/01/2024
 * */

package org.conductor.classesEobjetos.rationalNumbers;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class RationalTest
{
    public static void main (String[]args)
    {
        //Instâncias da classe
        Rational rational = new Rational(3, 4);
        System.out.printf("%s%n", rational);
        //System.out.printf("Testing toStrinfFloat(): %s%n", rational.toStringFloat());

        System.out.printf("Testing addTwoRationals(): %s%n", Rational.addTwoRationals(3, 4, 5, 6));
        System.out.printf("Testing subtractTwoRationals(): %s%n", Rational.subtractTwoRationls(3, 4, 1, 6));
        System.out.printf("Testing productTwoRationals(): %s%n", Rational.productTwoRationals(23, 5, 123, 41));
        System.out.printf("Testing divdeTwoRationals(): %s%n", Rational.divideTwoRationals(8, 9, 4, 5));
    };//fim do método main
};//end of RationalTest class
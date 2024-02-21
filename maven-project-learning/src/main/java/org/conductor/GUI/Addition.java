/** This class is used to create a simple GUI that receives two int number, adds them and return the
 * result to the user.
 * @author pedro de castro tedesco
 * @see Java: how to program (Deitel and Deitel, chapter 12)
 * @since 20/02/2024
 * */

package org.conductor.GUI;

import javax.swing.*;

public class Addition
{
   public static void main (String[]args)
   {
       //get the entries numbers
       String fistNumber = JOptionPane.showInputDialog("Enter the first numbre");
       String secondNumber = JOptionPane.showInputDialog("Enter the second number");

       //convert string to integer
       int number1 = Integer.parseInt(fistNumber);
       int number2 = Integer.parseInt(secondNumber);

       int sum = number1 + number2;

       //show the result to the user
       JOptionPane.showMessageDialog(null, "The sum is " + sum, "Sum of two integers",
               JOptionPane.PLAIN_MESSAGE);
   };//end of main()
};//end of Addition

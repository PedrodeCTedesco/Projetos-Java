/** Checks the beahvior of radio buttons
 * @author pedro de castro tedesco
 * @since 05/03/2024
 * @see Java: how to program (Deitel and Deitel, 10 ed, chapter 12)
 * */

package org.conductor.GUI.buttons;

import javax.swing.*;

public class RadioButtonSpec
{
    public static void main(String[] args)
    {
        RadioButtonFrame radioButton = new RadioButtonFrame();
        radioButton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        radioButton.setSize(400, 300);
        radioButton.setVisible(true);
    };//end of main
};//end of RadioButtonSpec

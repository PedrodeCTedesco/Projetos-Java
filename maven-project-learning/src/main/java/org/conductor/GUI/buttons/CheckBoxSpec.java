/**@author pedro de castro tedescp
 * @since 05/03/2024
 * @see Java: how to program (Deitel and Detel, 10ed, chapter 12)
 * */

package org.conductor.GUI.buttons;

import javax.swing.*;

public class CheckBoxSpec
{
    public static void main (String[]args)
    {
        CheckBoxFrame checkbox = new CheckBoxFrame();
        checkbox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkbox.setSize(340, 150);
        checkbox.setVisible(true);
    };//end of main
};//end of CheckBoxSpec

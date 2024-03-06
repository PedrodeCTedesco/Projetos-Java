/** Class to test the behavior of ButtonFrame
 * @author pedro de castro tedesco
 * @since 05/03/2024
 * @see Java: how to program (Deitel and Deitel, 10 ed, chapter 12)
 * */

package org.conductor.GUI.buttons;

import javax.swing.*;

public class ButtonFrameSpec
{
    public static void main (String[]args)
    {
        ButtonFrame buttonFrame = new ButtonFrame();

        buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonFrame.setSize(275, 110);
        buttonFrame.setVisible(true);
    };//end of main
};//end of ButtonFrameSpec

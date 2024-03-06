/** This class show how JButton works
 * @author pedro de castro tedesco
 * @since 05/03/2024
 * @see Java: how to program (Deitel and Deitel, 10ed, chapter 12)
 * */

package org.conductor.GUI.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame extends JFrame
{
    //fields
    private final JButton plainJButoon; //button with text only;
    //private final JButton fancyJButton; //button with icon

    //constructor
    //ButtonFrame adds buttons to JFrame
    public ButtonFrame()
    {
        super("Testing buttons");
        setLayout(new FlowLayout());

        plainJButoon = new JButton("Quem é o amor da minha vida?");
        add(plainJButoon);

        /** as imagens devem estar no mesmo diretório do app */
        //Icon bug1 = new ImageIcon(getClass().getResource("logo-jpg.jpg"));
        //Icon bug2 = new ImageIcon(getClass().getResource("logo-jpg.jpg"));
        //fancyJButton = new JButton("Icon button", bug1); //set icon of the button
        //fancyJButton.setRolloverIcon(bug2); //set roll over icon
        //add(fancyJButton);

        //The handler object of the internal class for the event treatment
        ButtonHandler handler = new ButtonHandler();
        //fancyJButton.addActionListener(handler);
        plainJButoon.addActionListener(handler);
    };//end of constructor

    private class ButtonHandler implements ActionListener
    {
        //treats button events
        @Override
        public void actionPerformed(ActionEvent event)
        {
            JOptionPane.showMessageDialog(ButtonFrame.this,
                    String.format("É a Duda: %s", event.getActionCommand()));
        };//end of actionPerformed(ActionEvent event)
    };//end of ButtonHandler
};//end of ButtonFrame

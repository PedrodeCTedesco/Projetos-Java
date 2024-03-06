/** Class to show the checkbox button
 * @author pedro de castro tedesco
 * @since 05/03/2024
 * @see Java: how to program (Deitel and Deitel, 10 ed, chapter 12)
 * */

package org.conductor.GUI.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxFrame extends JFrame
{
    //fields
    private final JTextField textField; //shows the text alterations
    private final JCheckBox boldJCheckBox; //the bold style
    private final JCheckBox italicJCheckBox; //the italic style

    //constructor
    //adds the JCheckBox to the JFrame
    public CheckBoxFrame ()
    {
        super("JCheckBox");
        setLayout(new FlowLayout());

        //sets the textField and the font style
        textField = new JTextField("Watch the font style change", 20);
        textField.setFont(new Font("Serif", Font.PLAIN, 14));
        add(textField); //adds to JFrame

        boldJCheckBox = new JCheckBox("Bold");
        italicJCheckBox = new JCheckBox("Italic");
        add(boldJCheckBox); //adds to JFrame
        add(italicJCheckBox); //adds to JFrame

        //listeners for the events (handlers, treatment of the events)
        CheckBoxHandler handler = new CheckBoxHandler();
        boldJCheckBox.addItemListener(handler);
        italicJCheckBox.addItemListener(handler);
    };//end of constructor

    private class CheckBoxHandler implements ItemListener
    {
        //response to the events in the checkbox
        @Override
        public void itemStateChanged(ItemEvent event)
        {
            Font font = null; //storages the new font style

            //checks the checkboxes and creates the font
            if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            else if (boldJCheckBox.isSelected())
                font = new Font("Serif", Font.BOLD, 14);
            else if (italicJCheckBox.isSelected())
                font = new Font("Serif", Font.ITALIC, 14);
            else
                font = new Font("Serif", Font.PLAIN, 14);

            textField.setFont(font);
        };//end of itemStateChange
    };//end of CheckBoxHandler

};//end of CheckBoxFrame

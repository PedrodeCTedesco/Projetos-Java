/** This class shows how the radio buttons works
 * @author pedro de castro tedesco
 * @since 05/03/2024
 * @see Java: how to program (Deitel and Deitel, 10 ed, chapter 12)
 * */

package org.conductor.GUI.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioButtonFrame extends JFrame
{
    //fields
    private final JTextField textField; //shows fonts alterations
    private final Font plainFont; //regular font style
    private final Font boldFont;
    private final Font italicFont;
    private final Font boldAndItalicFont;
    private final JRadioButton plainRadioButton;
    private final JRadioButton boldRadioButton;
    private final JRadioButton italicRadioButton;
    private final JRadioButton boldAndItalicRadioButton;
    private final ButtonGroup radioGroup; //to organize the radio buttons

    //constructor
    public RadioButtonFrame()
    {
        super("Radio button test");
        setLayout(new FlowLayout());

        textField = new JTextField("Watch the font style change", 25);
        add(textField); //adds to JFrame

        plainRadioButton = new JRadioButton("Plain", true);
        boldRadioButton = new JRadioButton("Bold", false);
        italicRadioButton = new JRadioButton("Italic", false);
        boldAndItalicRadioButton = new JRadioButton("Bold and Italicc", false);
        add(plainRadioButton);
        add(boldAndItalicRadioButton);
        add(boldRadioButton);
        add(italicRadioButton);

        //sets the logical relationship between the radio buttons
        radioGroup = new ButtonGroup();
        radioGroup.add(plainRadioButton);
        radioGroup.add(boldRadioButton);
        radioGroup.add(italicRadioButton);
        radioGroup.add(boldAndItalicRadioButton);

        plainFont = new Font("Serif", Font.PLAIN, 14);
        boldFont = new Font("Serif", Font.BOLD, 14);
        italicFont = new Font("Serif", Font.ITALIC, 14);
        boldAndItalicFont = new Font("Serif", Font.ITALIC + Font.BOLD, 14);

        textField.setFont(plainFont);

        //listeners
        plainRadioButton.addItemListener(new RadioButtonHandler(plainFont));
        boldRadioButton.addItemListener(new RadioButtonHandler(boldFont));
        italicRadioButton.addItemListener(new RadioButtonHandler(italicFont));
        boldAndItalicRadioButton.addItemListener(new RadioButtonHandler(boldAndItalicFont));
    };//end of constructor

    private class RadioButtonHandler implements ItemListener
    {
        private Font font;

        public RadioButtonHandler(Font f)
        {
            font = f;
        }

        @Override
        public void itemStateChanged(ItemEvent event)
        {
            textField.setFont(font);
        }
    };//end of RadioButtonHandler
};//end of RadioButtonFrame

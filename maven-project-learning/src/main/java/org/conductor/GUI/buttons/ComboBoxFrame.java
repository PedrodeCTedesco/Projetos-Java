/** Class to show combo box components
 * @author pedro de castro tedesco
 * @since 05/03/2024
 * @see Java: how to program (Deitel and Deitel, 10ed, chapter 12)
 * */

package org.conductor.GUI.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBoxFrame extends JFrame
{
    //fields
    private final JComboBox<String> imagesJComboBox; //for the names of the icons
    private final JLabel label; //shows the name of the icon selected
    private static final String[] names = {"bug1.gif", "bug2.gif", "bug3.gif", "bug4.gif"};
    private final Icon[] icons = {
            new ImageIcon(getClass().getResource(names[0])),
            new ImageIcon(getClass().getResource(names[1])),
            new ImageIcon(getClass().getResource(names[2])),
            new ImageIcon(getClass().getResource(names[3]))};

    //constructor
    public ComboBoxFrame()
    {
        super("Testing combo box");
        setLayout(new FlowLayout());

        imagesJComboBox = new JComboBox<String>(names); //sets JComboBox
        imagesJComboBox.setMaximumRowCount(3); //shows 3 lines
        imagesJComboBox.addItemListener(
                new ItemListener() //instance of the anonymous internal class
                { //anonymous internal class
                    @Override
                    public void itemStateChanged(ItemEvent event) {
                        //checks to see if the item is selected
                        if (event.getStateChange() == ItemEvent.SELECTED)
                            label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
                    }
                });

        add(imagesJComboBox);
        label = new JLabel(icons[0]);
        add(label);
    };//end of constructor

};//end of ComboBoxFrame

/** Shows how to use JList
 * @author pedro de castro tedesco
 * @since 05/03/2024
 * @see Java: how to program (Deitel and Deitel, 10ed, chapter 12)
 * */

package org.conductor.GUI.jlists;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ListFrame extends JFrame
{
    //fields
    private final JList<String> colorList; //list to show the colors
    private static final String[] colorNmaes = {"Black", "Blue", "Cyan", "Dark Gray", "Gray",
    "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
    private static final Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
    Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.PINK,
    Color.RED, Color.WHITE, Color.YELLOW};

    //constructor
    public ListFrame()
    {
        super("Test list");
        setLayout(new FlowLayout());

        colorList = new JList<String>(colorNmaes);
        colorList.setVisibleRowCount(5);
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(colorList));

        //Register the listener using anonymous internal class
        colorList.addListSelectionListener(
                new ListSelectionListener()
                {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        getContentPane().setBackground(colors[colorList.getSelectedIndex()]);
                    }
                }
        );
    };//end of constructor
};//end of ListFrame

/** Multiple selection lists
 * @author pedro de castro tedesco
 * @since 05/03/2024
 * @see Java: how to program (Deitel and Deitel, 10ed, chapter 12)
 * */

package org.conductor.GUI.jlists;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListMultipleSelectionFrame extends JFrame
{
    //fields
    private final JList<String> colorJList; //list to store color names
    private final JList<String> copyJList; // list to store copied names
    private JButton copyJButton; //button to create the copy
    private static final String[] colorNames = {"Black", "Blue", "Cyan", "Dark Gray", "Gray",
            "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};

    //constructor
    public ListMultipleSelectionFrame()
    {
        super("Multiple selection list");
        setLayout(new FlowLayout());

        colorJList = new JList<String>(colorNames);
        colorJList.setVisibleRowCount(5);
        colorJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(colorJList));

        copyJButton = new JButton("Copy >>>");
        copyJButton.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        copyJList.setListData(
                                colorJList
                                        .getSelectedValuesList()
                                        .toArray(new String[0]));
                    }
                }
        );

        add(copyJButton);

        copyJList = new JList<String>();
        copyJList.setVisibleRowCount(5);
        copyJList.setFixedCellWidth(100); //to show the area of the list if none item is selected
        copyJList.setFixedCellHeight(15); //same reason as above
        copyJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        add(new JScrollPane(copyJList));
    };//end of constructor
};//end of ListMultipleSelectionFrame

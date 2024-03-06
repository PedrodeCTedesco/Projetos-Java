/** Check the behavior of the multiple selection list*/

package org.conductor.GUI.jlists;

import javax.swing.*;

public class ListMultipleSelectionFrameSpec
{
    public static void main(String[]args)
    {
        ListMultipleSelectionFrame multipleList = new ListMultipleSelectionFrame();
        multipleList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        multipleList.setSize(350, 150);
        multipleList.setVisible(true);
    };//end of main
};//end of ListMultipleSelectionFrameSpec

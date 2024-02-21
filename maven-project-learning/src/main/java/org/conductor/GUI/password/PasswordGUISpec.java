package org.conductor.GUI.password;

import javax.swing.*;

public class PasswordGUISpec
{
    public static void main(String[]args)
    {
        PasswordGUI passwordGUIFrame = new PasswordGUI();
        passwordGUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        passwordGUIFrame.setSize(350, 120);
        passwordGUIFrame.setVisible(true);
    }
}

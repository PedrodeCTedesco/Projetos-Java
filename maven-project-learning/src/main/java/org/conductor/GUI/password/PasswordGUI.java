/** Represents the GUI for a password field
 * @author pedro de castro tedesco
 * @since 20/02/2024
 * @see Java: how to program (Deitel and Deitel, chapter 12)
 * */
package org.conductor.GUI.password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGUI extends JFrame
{
    private final JTextField textField1;
    private final JTextField textField2;
    private final JTextField textField3;
    private final JPasswordField passwordField;

    public PasswordGUI()
    {
        super("Testing JTextField and JPasswordField");
        setLayout(new FlowLayout());

        //text field with 10 cols
        textField1 = new JTextField(10);
        add(textField1);

        //text field with standard text
        textField2 = new JTextField("Enter the text field");
        add(textField2);

        //text field with standard text and 21 cols
        textField3 = new JTextField("Uneditable text field", 21);
        textField3.setEditable(false);
        add(textField3);

        //password field with standard text
        passwordField = new JPasswordField("Hidden text");
        add(passwordField);

        //rotinas de tratamento de evento
        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);
    };//end of constructor

    //internal class
    private class TextFieldHandler implements ActionListener
    {
        //processa eventos de campo de texto
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String string = "";

            //Usuário pressionou Enter no JTextField textField1
            if (event.getSource() == textField1)
            {
                string = String.format("text field 1: %s", event.getActionCommand());
            } else if (event.getSource() == textField2)
            {
                string = String.format("text field 2: %s", event.getActionCommand());
            } else if (event.getSource() == textField3)
            {
                string = String.format("text field 3: %s", event.getActionCommand());
            } else if(event.getSource() == passwordField)
            {
                string = String.format("passwordField: %s", event.getActionCommand());
            }

            //Exibe o conteúdo do JTextField
            JOptionPane.showMessageDialog(null, string);
        };//end of actionPerformed(...)
    };//end of TextFieldHandler
};//end of PasswordGUI

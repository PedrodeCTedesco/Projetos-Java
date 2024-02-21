/** This class shows examples os the functionalities of GUI components.
 * @author pedro de castro tedesco
 * @since 20/02/2024
 * @see Java: how to program (Deitel and Deitel, chapter 12)
 * */
package org.conductor.GUI.textAndIcon;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class LabelFrame extends JFrame
{
    //Fields
    private final JLabel textLabel;
    private final JLabel textAndIconLabel;
    private final JLabel addedTextAndIconLabel;

    //Constructor LabelFrame adds JLabels to JFrame
    public LabelFrame ()
    {
        super("Testing JLabel");
        setLayout(new FlowLayout()); //configure the frame's layout

        //JLabel's constructor with a string argument
        textLabel = new JLabel("Label with text");
        textLabel.setToolTipText("This is textLabel component");
        add(textLabel); //adds textLabel to JFrame

        //JLabel's constructor with string, icon and args
        Icon bug = new ImageIcon(Objects.requireNonNull(getClass()
                .getResource("../resources/static/images/logo-jpg.jpg")));
        textAndIconLabel = new JLabel("Label with text and icon", bug, SwingConstants.LEFT);
        textAndIconLabel.setToolTipText("This is textAndIconLabel component");
        add(textAndIconLabel);

        //JLabel's constructor with no args
        addedTextAndIconLabel = new JLabel();
        addedTextAndIconLabel.setText("Label with text and icon at bottom");
        addedTextAndIconLabel.setIcon(bug); //adds icon to JLabel
        addedTextAndIconLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        addedTextAndIconLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        addedTextAndIconLabel.setToolTipText("This is label with icon and text added");
        add(addedTextAndIconLabel);
    };//end of LabelFrame();
};//end of LabelFrame

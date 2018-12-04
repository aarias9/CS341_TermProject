/**
 *  Alfonso Arias
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part V
 *
 *  GUI_1.java
 *
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GUI_1 implements UserInterface {

    @Override
    public void display()
    {
        JFrame gui_1 = new JFrame("AARIAS9 GUI");
        gui_1.setSize(250, 250);
        gui_1.setLocation(300,200);
        final JTextArea textArea = new JTextArea(10,40);
        gui_1.getContentPane().add(BorderLayout.CENTER, textArea);
        final JButton button = new JButton("Done");
        gui_1.getContentPane().add(BorderLayout.SOUTH, button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Button was clicked\n");
            }
        });

        gui_1.setVisible(true);

    }

    @Override
    public String getLine() {
        return null;
    }
}

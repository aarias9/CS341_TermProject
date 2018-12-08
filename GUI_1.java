/**
 *  Alfonso Arias
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part V
 *
 *  GUI_1.java
 *
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GUI_1 implements UserInterface{

    public GUI_1()
    {
        JFrame gui_1 = new JFrame("AARIAS9_GUI_1");
        gui_1.setSize(1080, 750);
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
    public void display(String s)
    {

    }

    @Override
    public String getLine() {
        return null;
    }
    
    public void switchVisibility() {
    	// if gui_1 is visible
    	// gui_1.setVisiblie(false)
    	// else gui_1.setVisiblie(true)
    }
}

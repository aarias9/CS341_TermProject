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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class GUI_1 extends JFrame implements UserInterface{

    private JFrame gui_1;
    private JPanel north;
    private JPanel south;

    private JTextField commandField;
    private JTextArea messageArea;
    private JTextArea inventoryArea;
    private JButton commandButton;

    private JLabel gameMessageLable;
    private JLabel inventoryLabel;

    private String commandString;
    private boolean isVisible = false;

    public GUI_1()
    {
        gui_1 = new JFrame("AARIAS9_GUI_1");
        gui_1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        north = new JPanel();
        south = new JPanel();

        Container container = gui_1.getContentPane();
        container.setLayout(new BorderLayout(0,0));


        north.setLayout(new GridLayout(1, 2));
        south.setLayout(new FlowLayout());

        // JPanel for displaying messages/ game Info
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        gameMessageLable = new JLabel("Game Message", SwingConstants.CENTER);
        messagePanel.add(gameMessageLable);
        messageArea = new JTextArea(10,10);
        messageArea.setEditable(false);
        messageArea.setFont(new Font("Times Header", Font.BOLD, 12));
        messageArea.setForeground(Color.WHITE);
        messageArea.setBackground(Color.DARK_GRAY);
        messagePanel.add(new JScrollPane(messageArea));
        messagePanel.setBackground(Color.RED);


        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));
        inventoryLabel = new JLabel("Inventory", SwingConstants.CENTER);
        inventoryLabel.setBackground(Color.RED);
        inventoryPanel.add(inventoryLabel);
        inventoryArea = new JTextArea(10, 20);
        inventoryArea.setEditable(false);
        inventoryArea.setFont(new Font("Times Header", Font.BOLD, 12));
        inventoryArea.setForeground(Color.WHITE);
        inventoryArea.setBackground(Color.DARK_GRAY);
        inventoryPanel.add(new JScrollPane(inventoryArea));
        inventoryPanel.setBackground(Color.RED);

        north.add(messagePanel);
        north.add(inventoryPanel);

        commandField = new JTextField("Enter Command Here", 34);
        commandField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                commandField.setText("");
            }
        });

        commandButton = new JButton("Send Command");
        commandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandString = commandField.getText().trim();
                commandField.setText("");
                messageArea.append(commandString + "\n");
            }
        });

        south.add(commandField);
        south.add(commandButton);
        south.setBackground(Color.RED);

        container.add(north, BorderLayout.NORTH);
        container.add(south, BorderLayout.CENTER);

        gui_1.setSize(500, 250);
        gui_1.setLocation(300,200);
        gui_1.setVisible(isVisible);

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
    	if (!isVisible) {
    		gui_1.setVisible(true);
			isVisible = true;
		}
		else {
			gui_1.setVisible(false);
			isVisible = false;
		}
    }
}

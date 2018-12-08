/**
 *  Juan Zambrano
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part V
 *
 *  GUI_2.java
 *
 */
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;
public class GUI_2 implements UserInterface {
    // GUI items
    private JFrame gui_3; //COMMANDS
    private JFrame gui_4; //INVENTORY
    private JFrame frame; //BUTTON LAYOUT
    private JLabel gameMessagesLabel;
    private JTextArea messagesArea;
    private JLabel commandLabel;
    private JTextField commandField;
    private JButton commandButton;
    private String commandBuffer;
    private JLabel inventoryLabel;
    private JTextArea inventory;

    // Menu Items
    private JMenu fileMenu;
    private JMenuItem exitItem;
    private JMenuItem aboutItem;
    private JMenuItem howToItem;

    //HTML Files
    private final File ABOUTFILE = new File("aboutAuthors.html");    //File: about file
    private final File HOWTOPLAY = new File("howToPlay.html");        //Help: how to play file

    private boolean isVisible = false;

    public GUI_2() {

        gui_3 = new JFrame("JZAMBR7 Command and Action");
        gui_3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gui_4 = new JFrame("JZAMBR7 Inventory");
        gui_4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set up menu items
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');

        aboutItem = new JMenuItem("About Authors");
        fetch(aboutItem, ABOUTFILE);

        howToItem = new JMenuItem("How to Play");
        fetch(howToItem, HOWTOPLAY);

        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        fileMenu.add(aboutItem);
        fileMenu.add(howToItem);
        fileMenu.add(exitItem);
        JMenuBar bar = new JMenuBar();
        gui_3.setJMenuBar(bar);
        bar.add(fileMenu);

        // get content pane and set its layout
        Container container = gui_3.getContentPane();
        container.setLayout(new GridLayout(2, 1));

        // set up the Panels
        JPanel messagesPanel = new JPanel();
        messagesPanel.setLayout(new BoxLayout(messagesPanel, BoxLayout.Y_AXIS));
        JPanel commandsPanel = new JPanel();
        commandsPanel.setLayout(new BoxLayout(commandsPanel, BoxLayout.Y_AXIS));
        JPanel directionsPanel = new JPanel();
        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));
        container.add(messagesPanel);
        container.add(directionsPanel);
        container.add(commandsPanel);
        container.add(inventoryPanel);


        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 1));

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));

        // create labels, text fields, and buttons
        gameMessagesLabel = new JLabel("Game Messages", SwingConstants.CENTER);
        messagesPanel.add(gameMessagesLabel);
        messagesArea = new JTextArea(10, 10);
        messagesArea.setEditable(false);
        messagesPanel.add(new JScrollPane(messagesArea));
        //container.add(new JScrollPane(messagesArea), BorderLayout.NORTH);

        commandLabel = new JLabel("Command Field", SwingConstants.CENTER);
        commandsPanel.add(commandLabel);
        commandField = new JTextField("", 40);
        commandsPanel.add(commandField);
        commandButton = new JButton("Send Command");
        commandButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                commandBuffer = commandField.getText();
                commandField.setText("");
                messagesArea.append(commandBuffer + "\n");
            }
        });

        commandsPanel.add(commandButton);

        //inventoryLabel = new JLabel("Inventory", SwingConstants.CENTER);
        //gui_4.add(inventoryLabel);
        inventory = new JTextArea(5, 10);
        inventory.setEditable(false);
        gui_4.add(new JScrollPane(inventory));

        //Dimensions of Command window
        gui_3.setSize(1080, 720);
        gui_3.setVisible(isVisible);

        ImageIcon mascot = new ImageIcon("src/vaultBoy.png");
        Image scaleImage = mascot.getImage().getScaledInstance(320, 288, Image.SCALE_SMOOTH);

        gui_3.add(new JLabel(new ImageIcon(scaleImage)));

        //Dimensions and Starting position of Inventory window
        Point newLocation = new Point(340, 650);
        gui_4.setLocation(newLocation);

        gui_4.setSize(400, 320);
        gui_4.setVisible(isVisible);

        //GRIDBAG LAYOUT
        frame = new JFrame("JZAMBR7 Action Grid");

        //BUTTON NAMING
        JButton btn1 = new JButton("NW");
        JButton btn2 = new JButton("NNW");
        JButton btn3 = new JButton("N");
        JButton btn4 = new JButton("NNE");
        JButton btn5 = new JButton("NE");
        JButton btn6 = new JButton("WNW");
        JButton btn7 = new JButton("UP");
        JButton btn8 = new JButton("ENE");
        JButton btn9 = new JButton("W");
        JButton btn10 = new JButton("LOOK");
        JButton btn11 = new JButton("E");
        JButton btn12 = new JButton("WSW");
        JButton btn13 = new JButton("DOWN");
        JButton btn14 = new JButton("ESE");
        JButton btn15 = new JButton("SW");
        JButton btn16 = new JButton("SWS");
        JButton btn17 = new JButton("S");
        JButton btn18 = new JButton("SES");
        JButton btn19 = new JButton("SE");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cst = new GridBagConstraints();

        //BUTTON PLACEMENT
        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 0;
        panel.add(btn1, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 1;
        cst.gridy = 0;
        panel.add(btn2);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 0;
        panel.add(btn3, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 3;
        cst.gridy = 0;
        panel.add(btn4, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 4;
        cst.gridy = 0;
        panel.add(btn5, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 1;    //third row
        panel.add(btn6, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 1;
        panel.add(btn7, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 4;
        cst.gridy = 1;
        panel.add(btn8, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 2;
        panel.add(btn9, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 2;
        panel.add(btn10, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 4;
        cst.gridy = 2;
        panel.add(btn11, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 3;
        panel.add(btn12, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 3;
        panel.add(btn13, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 4;
        cst.gridy = 3;
        panel.add(btn14, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 0;
        cst.gridy = 4;
        panel.add(btn15, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 1;
        cst.gridy = 4;
        panel.add(btn16, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 2;
        cst.gridy = 4;
        panel.add(btn17, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 3;
        cst.gridy = 4;
        panel.add(btn18, cst);

        cst.fill = GridBagConstraints.HORIZONTAL;
        cst.gridx = 4;
        cst.gridy = 4;
        panel.add(btn19, cst);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.getContentPane().add(panel);
        frame.setVisible(isVisible);

        Point newLocation2 = new Point(340, 100);
        frame.setLocation(newLocation2);

    }

    @Override
    public void display(String s) {
        messagesArea.append(s + "\n");
    }

    @Override
    public String getLine() {
        return commandBuffer;
    }

    @Override
    public void switchVisibility() {
        if (!isVisible) {
            frame.setVisible(true);
            gui_3.setVisible(true);
            gui_4.setVisible(true);
            isVisible = true;
        } else {
            gui_3.setVisible(false);
            isVisible = false;
        }

    }

    /**
     * function to get the content of the file and display in dialog box
     */
    private void fetch(JMenuItem menuItem, File source) {
        try {
            String content;
            if (source.isFile()) {
                content = new Scanner(source).useDelimiter("\\Z").next();
            } else {
                content = "on " + menuItem.getText() + " failed to find source file \"" + source.getName() + "\". Please check the path.";
            }
            JLabel message = new JLabel(content);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JMenuItem self = (JMenuItem) e.getSource();
                    JOptionPane.showMessageDialog(gui_3, message, self.getText(), JOptionPane.INFORMATION_MESSAGE);
                }
            });

        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }
}
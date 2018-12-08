/**
 *  Robert Barrera
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part V
 *
 *  GUI_3.java
 *
 */
import java.io.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;
public class GUI_3 implements UserInterface {
	// GUI items
	private JFrame gui_3;
	private JLabel gameMessagesLabel;
	private JTextArea messagesArea;
	private JLabel commandLabel;
	private JTextArea commandHistory;
	private JTextField commandField;
	private JButton commandButton;
	private String commandBuffer;
	private JLabel inventoryLabel;
	private JTextArea inventory;
	private boolean check;
	
	// Menu Items
	private JMenu fileMenu;
	private JMenuItem exitItem;
	private JMenuItem aboutItem;
	private JMenuItem howToItem;
	  
	//HTML Files
	private final File ABOUTFILE = new File("aboutAuthors.html");	//File: about file
	private final File HOWTOPLAY = new File("howToPlay.html"); 		//Help: how to play file

	private boolean isVisible = false;
	
	public GUI_3() {
		gui_3 = new JFrame("RBARRE4 GUI");
		gui_3.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		// set up menu items
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic( 'F' );
		
		aboutItem = new JMenuItem("About Authors");
		fetch(aboutItem, ABOUTFILE);
		
		howToItem = new JMenuItem("How to Play");
		fetch(howToItem, HOWTOPLAY);
		
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent event )
			{
				System.exit( 0 );
			}
		});
		
		fileMenu.add( aboutItem );     
		fileMenu.add( howToItem );
		fileMenu.add( exitItem );
		JMenuBar bar = new JMenuBar();
		gui_3.setJMenuBar(bar);
		bar.add(fileMenu);
		
		// get content pane and set its layout
		Container container = gui_3.getContentPane();
		container.setLayout(new GridLayout (2,1));
		
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
		
		
		// create labels, text fields, and buttons
		gameMessagesLabel = new JLabel ("Game Messages", SwingConstants.CENTER);
		messagesPanel.add(gameMessagesLabel);
		messagesArea = new JTextArea(10, 10);
		messagesArea.setEditable(false);
		messagesPanel.add(new JScrollPane(messagesArea));
		
		commandLabel = new JLabel("Command Field", SwingConstants.CENTER);
		commandsPanel.add(commandLabel);
		commandField = new JTextField("", 40);
		commandsPanel.add(commandField);
		commandButton = new JButton("Send Command");
		check = false;
		commandButton.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent event )
			{
				commandBuffer = commandField.getText();
				commandField.setText("");
				messagesArea.append(commandBuffer+"\n");
				check = true;
			}
		});
		commandsPanel.add(commandButton);
		
		inventoryLabel = new JLabel ("Inventory", SwingConstants.CENTER);
		inventoryPanel.add(inventoryLabel);
		inventory = new JTextArea(10, 20);
		inventory.setEditable(false);
		inventoryPanel.add(new JScrollPane(inventory));
		    
		    
		gui_3.setSize( 1080, 720 );
		gui_3.setVisible(isVisible);
		commandBuffer = "";
	}
	
	@Override
	public void display(String s) {
		messagesArea.append(s+"\n");
	}

	@Override
	public String getLine() {
		while (true) {
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e){
				display("OOOPS");
			}
			if (check){
				check = false;
				return commandBuffer;
			}
		}
	}

	@Override
	public void switchVisibility() {
		if (!isVisible) {
			gui_3.setVisible(true);
			isVisible = true;
		}
		else {
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
            if(source.isFile()){
                content = new Scanner(source).useDelimiter("\\Z").next();
            }else{
                content = "on " + menuItem.getText() + " failed to find source file \"" + source.getName() + "\". Please check the path.";
            }
            JLabel message = new JLabel(content);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JMenuItem self = (JMenuItem)e.getSource();
                    JOptionPane.showMessageDialog(gui_3, message, self.getText(), JOptionPane.INFORMATION_MESSAGE);
                }
            });

        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

}

//import java.net.*; 
import java.io.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;

public class GameGUI extends JFrame {
	// GUI items
	JLabel gameMessagesLabel;
	JTextArea messagesArea;
	JLabel commandLabel;
	JTextArea commandHistory;
	JTextField commandField;	
	JLabel inventoryLabel;
	JTextArea inventory;
	
	// Menu Items
	private JMenu fileMenu;
	private JMenuItem exitItem;
	private JMenuItem aboutItem;
	private JMenuItem howToItem;
	  
	//HTML Files
	private final File ABOUTFILE = new File("aboutAuthors.html");	//File: about file
	private final File HOWTOPLAY = new File("howToPlay.html"); 		//Help: how to play file
	  
	public GameGUI () {
		super ("Homework 5");
		
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
	      setJMenuBar(bar);
	      bar.add(fileMenu);
	      
	      // get content pane and set its layout
	      Container container = getContentPane();
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
	      
	      
	      JPanel northPanel = new JPanel ();
	      northPanel.setLayout (new GridLayout (2,1));
	      //container.add (northPanel, BorderLayout.NORTH);
	      
	      JPanel southPanel = new JPanel ();
	      southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
	      //container.add (southPanel, BorderLayout.SOUTH);
	      
	      // create labels, text fields, and buttons
	      gameMessagesLabel = new JLabel ("Game Messages", SwingConstants.CENTER);
	      messagesPanel.add(gameMessagesLabel);
	      messagesArea = new JTextArea(10, 20);
	      messagesArea.setEditable(false);
	      messagesPanel.add(new JScrollPane(messagesArea));
	      //container.add(new JScrollPane(messagesArea), BorderLayout.NORTH);
	      
	      commandLabel = new JLabel("Command Field", SwingConstants.CENTER);
	      commandsPanel.add(commandLabel);
	      //commandHistory = new JTextArea(5, 20);
	      //commandHistory.setEditable(false);
	      //commandsPanel.add(commandHistory);
	      commandField = new JTextField("", 40);
	      commandsPanel.add(commandField);
	      
	      inventoryLabel = new JLabel ("Inventory", SwingConstants.CENTER);
	      inventoryPanel.add(inventoryLabel);
	      inventory = new JTextArea(10, 20);
	      inventory.setEditable(false);
	      inventoryPanel.add(new JScrollPane(inventory));
	      
	      
	      setSize( 1080, 720 );
	      setVisible( true );
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
                    JOptionPane.showMessageDialog(GameGUI.this, message, self.getText(), JOptionPane.INFORMATION_MESSAGE);
                }
            });

        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }
}

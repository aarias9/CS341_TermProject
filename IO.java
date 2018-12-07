/**
 *  Alfonso Arias
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part V
 *
 *  IO.java
 *
 */
import java.util.Scanner;

public class IO { // Does not implement
	public static final int TEXT = 0;
    public static final int GUI_1 = 1;	// Alfonso
    public static final int GUI_2 = 2;	// Juan
    public static final int GUI_3 = 3;	// Robert
    
    private UserInterface TxtInterfaceImp = new TxtInterface();
    //private UserInterface GUI1 = new GUI_1();
    //private UserInterface GUI2 = new GUI_1();
    private UserInterface GUI3 = new GUI_1(); 

    private UserInterface ui = TxtInterfaceImp;	// default implementor

    public void display(String s)
    {
        ui.display(s);
    }

    public String getLine()
    {
        // I believe this should just be ui.getLine() and would do the same thing in
    	// TxtInterface that being done in the if statement if ui was an instance
    	// of TxtInterface. In other words, all we would need here is ui.getLine()
    	
    	if(ui instanceof TxtInterface) {
            Scanner scanner = keyboardScanner.getKeyboardScan();
            String userInput = scanner.nextLine();
            return userInput;
        }
        else
        {
            return ui.getLine();
        }
    }

    public void selectInterface(int i)
    {
        if(i == GUI_1) {
        	if (!(ui instanceof GUI_1)) {
        		ui.switchVisibility();
        		new GUI_1().display("");
        	}
        }
        else if(i == GUI_2) {
            // new GUI_1().display();
        }
        else if(i == GUI_3) {
        	if (!(ui instanceof GUI_3)) {
        		ui.switchVisibility();
        		ui = GUI3;
        	}
        }
        else if (i == TEXT) {
        	ui.switchVisibility();
        	ui = TxtInterfaceImp;
        }
        else {	// might use ui.display() instead
            System.out.println("Error, No GUI under that name found");
        }
    }

}
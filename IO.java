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
    private UserInterface GUI1, GUI2, GUI3;

    private static UserInterface ui = new TxtInterface();	// default implementor

    public IO( ) {
    	//GUI1 = new GUI_1();
    	//GUI2 = new GUI_2();
    	GUI3 = new GUI_3();
    }

    public static void display(String s)
    {
        ui.display(s);
    }

    public String getLine()
    {
        // I believe this should just be ui.getLine() and would do the same thing in
    	// TxtInterface that being done in the if statement if ui was an instance
    	// of TxtInterface. In other words, all we would need here is ui.getLine()
    	
//    	if(ui instanceof TxtInterface) {
//            Scanner scanner = keyboardScanner.getKeyboardScan();
//            String userInput = scanner.nextLine();
//            return userInput;
//        }
//        else
//        {
//            return ui.getLine();
//        }
    	return ui.getLine();
    }

    public void selectInterface(int i)
    {
        if(i == GUI_1) {
        	if (!(ui instanceof GUI_1)) {
        		ui.switchVisibility();
        		ui = GUI1;
        		ui.switchVisibility();
        		display("UI switched to GUI1");
        	}
        	else {
        		display("UI is already GUI1");
        	}
        }
        else if(i == GUI_2) {
        	//if (!(ui instanceof GUI_2)) {
        	//	ui.switchVisibility();
        	//	ui = GUI2;
    		//	ui.switchVisibility();
        	//	display("UI switched to GUI2");
        	//}
        	//else { 
        	//	display("UI is already GUI2");
        	//}
        }
      
        else if(i == GUI_3) {
        	if (!(ui instanceof GUI_3)) {
        		ui.switchVisibility();
        		ui = GUI3;
        		ui.switchVisibility();
        		display("UI switched to GUI3");
        	}
        	else {
        		display("UI is already GUI3");
          }

        }
        else if (i == TEXT) {
        	if (!(ui instanceof TxtInterface)) {
        		ui.switchVisibility();
        		ui = TxtInterfaceImp;
        		display("UI switched to TEXT");
        	}
        	else {
        		display("UI is already GUI1");
        	}
        }
        else {	// might use ui.display() instead
            IO.display("Error, No GUI under that name found");
        }
    }

}
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

public abstract class IO implements UserInterface{
    public static final int GUI_1 = 1;
    public static final int GUI_2 = 2;
    public static final int GUI_3 = 3;

    private UserInterface ui;

    public void display(String s)
    {
        ui.display();
    }

    public String getLine(String s)
    {
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
        if(i == GUI_1)
            new GUI_1().display();
        else if(i == GUI_2)
            new GUI_1().display();
        else if(i == GUI_3)
            new GUI_1().display();
        else
            System.out.println("Error, No GUI under that name found");
    }

}

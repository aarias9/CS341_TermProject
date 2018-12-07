/**
 *  Alfonso Arias
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part III
 *
 *  GAMETESTER.java
 *
 *
 *
 */

import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;

public class GameTester {

    public static void main(String[] args)
    {
    	//UserInterface gui_3 = new GUI_3();
    	//gui_3.switchVisibility();
    	
        PrintInfo AA = new PrintInfo();
        AA.PrintName();

        try
        {
            System.out.println("Please enter a GDF File to begin");
            Scanner FILE = new Scanner(new File(keyboardScanner.getKeyboardScan().nextLine()));

            Game falloutv2 = new Game(FILE);

            falloutv2.Play();
        }

        catch(Exception Ex)
        {
            Ex.printStackTrace();
        }


        return;
    }//main
}

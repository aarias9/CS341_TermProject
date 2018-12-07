/*
 *  Juan Zambrano
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part V
 *
 *  TxtInterface.java

*/

import java.util.Scanner;

public class TxtInterface implements UserInterface {

    @Override
    public String getLine() {
        Scanner scanner = keyboardScanner.getKeyboardScan();
        String input = scanner.nextLine();
        return input;
    }

    @Override
    public void display()
    {
        System.out.println();
    }
}
/**
 *  Alfonso Arias
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part IV
 *
 *  KEYBOARDSCANNER.java
 *
 */

import java.util.Scanner;

public class keyboardScanner {

    private static Scanner keyboardScan;

    private keyboardScanner()
    {
        keyboardScan = null;
    }

    static Scanner getKeyboardScan()
    {
        if(keyboardScan == null)
            keyboardScan = new Scanner(System.in);

        return keyboardScan;
    }
}

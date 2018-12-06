/**
 *  Alfonso Arias
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part IV
 *
 *  UI.java
 *
 *
 */

import java.util.Scanner;

public class UI implements DecisionMaker {

    public UI(){}

    public Move getMove(Character c, Place p)
    {
        Scanner cmd = keyboardScanner.getKeyboardScan();
        String line;

        //System.out.println(c.name() + ", it is your turn.");

        p.display();

        System.out.print("$ ");
        line = cmd.nextLine();
        line = line.trim();

        if(line.equalsIgnoreCase("EXIT") || line.equalsIgnoreCase("QUIT")
                || line.equalsIgnoreCase("Q"))
            return  new Quit(c, p);

        if(line.equalsIgnoreCase("LOOK"))
            return new Look(c,p);

        if(line.equalsIgnoreCase("INVE") || line.equalsIgnoreCase("INVENTORY"))
            return new Inventory(c,p);

        if(line.length() > 4 && line.substring(0, 4).equalsIgnoreCase("GET "))
            return new Get(c, p, line.substring(4).trim());

        if(line.length() > 4 && line.substring(0, 5).equalsIgnoreCase("DROP "))
            return new Drop(c, p, line.substring(5).trim());

        if(line.length() > 4 && line.substring(0, 4).equalsIgnoreCase("USE "))
            return new Use(c, p, line.substring(4).trim());

        if(line.length() > 4 && line.substring(0, 3).equalsIgnoreCase("GO "))
            return new Go(c, p, line.substring(3).trim());

        if(line.length() > 4 && line.substring(0, 7).equalsIgnoreCase("ATTACK "))
            return new Attack(c, p, line.substring(7).trim());

        if(line.length() > 4 && line.substring(0, 5).equalsIgnoreCase("HEAL "))
            return new Heal(c, p, line.substring(5).trim());
        else
            return new Go(c, p, line);
    }

}

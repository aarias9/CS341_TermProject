/**
 *  Alfonso Arias
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part IV
 *
 *  NPC.java extends Character
 *
 */

import java.util.Scanner;

public class NPC extends Character {

    public NPC(){}

    public NPC(Scanner scan, float version, int spawnPoint)
    {
        super(scan, version, spawnPoint);

        isPLaying = true;
        decider = new AI( );
        //nPlayers++;
    }

    public int getID()
    {
        return this.ID;
    }

    public void makeMove()
    {
        if(isPLaying)
        {
            try{
                decider.getMove(this, current).execute();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

            System.out.println(name + " is currently in " + current.name() +"\n");

        }
        return;
    }
}

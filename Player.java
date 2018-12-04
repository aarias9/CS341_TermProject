/**
 *  Alfonso Arias
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part IV
 *
 *  Player.java
 *  extends Character
 *
 */

import java.util.Scanner;

public class Player extends Character {

    public Player(Scanner scan, float version, int spawnPoint)
    {
        super(scan, version, spawnPoint);

        isPLaying = true;
        isFriendly = true;
        decider = new UI( );
        gui = new GUI_1();
        nPlayers++;
    }

    public int getID()
    {
        return this.ID;
    }

    public void makeMove()
    {
        if(isPLaying)
        {
            Move move = decider.getMove(this, current);
            try{
                move.execute();
            }

            catch (Exception ex)
            {
                ex.printStackTrace();
            }

            if(move instanceof Get || move instanceof Drop)
                displayArtifacts();
        }
        return;
    }
}

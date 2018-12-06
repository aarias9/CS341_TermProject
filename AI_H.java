/**
 *  Alfonso Arias
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part IV
 *
 *  AI_H.java
 *
 *
 */

import java.util.Random;

public class AI_H extends  AI{

    public AI_H (){}

    public Move getMove(Character c, Place p)
    {
        Random r = new Random();
        int choice = r.nextInt(100);

        if(choice < 50)
            return new Go(c, p, p.getRandomDirection() );
        else if(choice < 60)
            return new Attack(c, p, p.getRandomItem());
        else if(choice < 70)
            return new Get(c, p, p.getRandomItem() );
        else if(choice < 80)
            return new Drop(c, p, c.getRandomItem() );
        else if(choice < 90)
            return new Use(c, p, c.getRandomItem() );
        return new Look(c, p);
    }
}

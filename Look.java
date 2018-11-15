/**
 *  Robert Barrera
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part IV
 *
 *  MOVE.java
 *
 */

public class Look extends Move
{
    private Place p;
    private Character c;

    public Look(Character c, Place p)
    {
        this.p = p;
        this.c = c;
    }

    @Override
    public void execute()
    {
        p.display();
    }

}

/**
 *  Robert Barrera
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part IV
 *
 *  MOVE.java
 *
 */

public class Go extends Move {

    private Character c;
    private Place p, current, previous;
    private String s;

    public Go(Character c, Place p, String s)
    {
        this.c = c;
        this.p = p;
        this.s = s;
        current = null;
        previous = null;
    }

    @Override
    public void execute()
    {
        previous = p;
        current = p.followDirection(s);

        if(previous == current)
        {
            if(current.directionLocked(s))
                IO.display("The path was locked\n");
            else
                IO.display("That direction doesn't Exists.\n");
        }
        else
        {
            c.moveTo(current);
        }
    }
}

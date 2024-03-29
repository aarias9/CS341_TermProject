/**
 *  Robert Barrera
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part IV
 *
 *  MOVE.java
 *
 */

public class Get extends Move {
    private Character c;
    private Place p;
    private String s;

    public Get(Character c, Place p, String s)
    {
        this.c = c;
        this.p = p;
        this.s = s;
        return;
    }

    @Override
    public void execute( ) {
        Artifact a = p.removeArtifactByName( s );
        if(a != null)
        {
            c.addItem(a);
            IO.display(c.name() + " picked up " + a.name());
        }
        else
            IO.display("Sorry, " + c.name + ", there is no " + s + " here\n");

        return;
    }
}

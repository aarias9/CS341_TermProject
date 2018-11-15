/**
 *  Robert Barrera
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part IV
 *
 *  MOVE.java
 *
 */

public class Drop extends Move {

    private Character c;
    private Place p;
    private String s;

    public Drop(Character c, Place p, String s)
    {
        this.c = c;
        this.p = p;
        this.s = s;
    }
    @Override
    public void execute()
    {
        Artifact a = c.getArtifact(s);
        if(a != null)
        {
            c.dropItem(s);
            System.out.println(c.name + " Has Dropped " + s + " in " + p.name() +"\n");
        }
        else
            System.out.println(c.name + " You do not have " + s + " item to drop.\n");

        return;
    }



}

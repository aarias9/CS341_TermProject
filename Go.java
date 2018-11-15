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
            if(current.directionLocked(s))	// No method in place, did you mean direction class?
            {
                System.out.println("The path was locked\n");
            }
            else
            {
                System.out.println("That direction doesn't Exists.\n");
            }
        }
        else
        {
            c.moveTo(p);
        }
    }
}

public class Get extends Move{
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
            System.out.println(c.name() + " picked up " + a.getName());
        }
        else
            System.out.println("Sorry, " + c.name + ", there is no " + s + "here\n");

        return;
    }
}

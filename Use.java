public class Use extends Move{
    private Character c;
    private Place p;
    private String s;

    public Use(Character c, Place p, String s)
    {
        this.c = c;
        this.p = p;
        this.s = s;
        return;
    }

    @Override
    public void execute()
    {
        Artifact a = c.getArtifact(s);
        if(a != null)
            a.use(c, p);
        else
            System.out.println("Sorry, " + c.name + ", you cannot use, " + s + "that here\n");
        return;
    }
}

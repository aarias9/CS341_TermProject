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

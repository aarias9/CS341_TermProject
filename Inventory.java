public class Inventory extends Move {

    private Character c;
    private Place p;

    public Inventory(Character c, Place p)
    {
        this.c = c;
        this.p = p;
    }

    @Override
    public void execute()
    {
        c.display();
    }
}

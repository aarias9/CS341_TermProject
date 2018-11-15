public class Quit extends Move {

    private Character c;
    private Place p;

    public Quit(Character c, Place p)
    {
        this.c = c;
        this.p = p;
    }

    @Override
    public void execute()
    {
        c.dropAllItems();
        p.removeCharacter(c);
    }


}

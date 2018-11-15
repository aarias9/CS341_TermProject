public class Heal extends Move {

    private Artifact a;
    private Character c;
    private Place p;
    private String s;

    public Heal(Character c, Place p, String s)
    {
        this.c = c;
        this.p = p;
        this.s = s;
    }

    @Override
    public void execute()
    {
        Character partner = p.getCharacterByName(s);

        if(partner.isFriendly())
        {
            c.dropItem(a.name());
            partner.useHealth(a.value());
        }

    }

}

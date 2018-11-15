import java.util.Random;

public class AI_F extends  AI{

    public AI_F (){}

    public  Move getMove(Character c, Place p)
    {
        Random r = new Random();
        int choice = r.nextInt(100);

        if(choice < 40)
            return new Go(c, p, p.getRandomDirection() );
        else if(choice < 50)
            return new Heal(c, p, p.getRandomItem());
        else if(choice < 60)
            return new Attack(c, p, p.getRandomItem());
        else if(choice < 70)
            return new Get(c, p, p.getRandomItem() );
        else if(choice < 80)
            return new Drop(c, p, c.getRandomItem() );
        else if(choice < 90)
            return new Use(c, p, c.getRandomItem() );
        return new Look(c, p);
    }
}

/**
 *  Robert Barrera
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part IV
 *
 *  MOVE.java
 *
 */

public class Attack extends Move {
    private Character c;
    private Place p;
    private String s;

    public Attack(Character c, Place p, String s)
    {
        this.c = c;
        this.p = p;
        this.s = s;
    }

    @Override
    public void execute()
    {
        /**
         * get character from place with string
         *      >Find the character by name<
         *  find if hostile or not
         *  Once found deal damage to character
        */
        Character victim = p.getCharacterByName(s);

        if(victim.isHostile())
        {
            victim.useAttack(c.getAttack());
        }
        else
        {
            IO.display("What are you doing! You can't attack Friendlies!");
        }
    }
}

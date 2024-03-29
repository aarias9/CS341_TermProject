import java.util.Scanner;

public class Hostile extends NPC {

    public Hostile(Scanner scan, float version, int spawnPoint)
    {
        super(scan, version, spawnPoint);
        isPLaying = true;
        isHostile = true;
        isFriendly = false;
        decider = new AI_H();
        //Character.nPlayers++;
    }

    public void makeMove()
    {
        if(isPLaying)
        {
            try
            {
              decider.getMove(this, current).execute();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            IO.display(name + " is currently in " + current.name() +"\n\n");

        }
    }

}

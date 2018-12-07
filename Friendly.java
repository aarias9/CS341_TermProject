import java.util.Scanner;

public class Friendly extends NPC {
    public Friendly(Scanner scan, float version, int spawnPoint)
    {
        super(scan, version, spawnPoint);
        isPLaying = true;
        isFriendly = true;
        isHostile = false;
        decider = new AI_F();
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

/**
 *  Alfonso Arias
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part III
 *
 *  CHARACTER.java
 *
 *
 */

import java.util.*;

public abstract class Character {
    protected int ID, placeID, DescriptionNUM, health, attack;
    private float version;
    protected String name, playerType, line;
    private  Scanner lineScanner;
    private String[] description;
    private static TreeMap<Integer, Character> characters = new TreeMap<>();
    private ArrayList<Artifact> items;
    protected Place current, previous, SpawnPoint;
    private Artifact item;
    protected static int nPlayers;
    protected DecisionMaker decider;
    protected Boolean isPLaying, isFriendly, isHostile;

    public  Character(){}

    public Character(int ID, String name, int desNum, String[] description)
    {
        items = new ArrayList<>();
        current = null;
        previous = null;

        this.ID = ID;
        this.name = name;
        this.description = new String[desNum];

        for(int i = 0; i < this.description.length; i++ )
            this.description[i] = description[i];

        nPlayers++;

    }

    public Character(Scanner scan, float version, int spawnPoint)
    {
        item = null;
        current = null;
        previous = null;

        this.version = version;
        this.placeID = spawnPoint;

        if(placeID > 0)
            current = Place.getPlaceById(placeID);
        else if (placeID == 0)
            current = Place.getPlaceById(0);
        else
        {
            System.err.println("Error, Character needs to Spawn in a valid Location.");
            System.exit(-1);
        }

        current.addCharacter(this);

        line = CleanLineScanner.getCleanLine(scan);
        lineScanner = new Scanner(line);
        ID = lineScanner.nextInt();
        characters.put(ID, this);
        items = new ArrayList<>();

        name = lineScanner.nextLine().trim();

        line = CleanLineScanner.getCleanLine(scan);
        lineScanner = new Scanner(line);
        health = lineScanner.nextInt();
        attack = lineScanner.nextInt();

        line = CleanLineScanner.getCleanLine(scan);
        lineScanner = new Scanner(line);
        DescriptionNUM = lineScanner.nextInt();
        description = new String[DescriptionNUM];

        for(int i = 0; i < description.length; i++)
        {
            line = CleanLineScanner.getCleanLine(scan);
            lineScanner = new Scanner(line);
            description[i] = lineScanner.nextLine();
        }

    }

    public int getID()
    {
        return this.ID;
    }

    public String name()
    {return name;}

    public static Character getCharacterBYID(int ID)
    {
        if(ID < 0)
            ID = ID * -1;

        for(Map.Entry<Integer, Character> entry: characters.entrySet())
        {
            Integer Key = entry.getKey();
            if(Key == ID)
            {
                Character character = entry.getValue();
                return character;
            }
        }
        return null;
    }

    public static void removeCharacter( Character c)
    {
        c.isPLaying = false;
        if(c instanceof Player)
        {
            if(--nPlayers <= 0)
            {
                System.out.println("That's the Final Player, Game Over");
                System.exit(0);
            }
        }
    }

    public boolean isPlaying()
    {
        return isPLaying;
    }

    public boolean isFriendly()
    {
        return isFriendly;
    }

    public boolean isHostile()
    {
        return isHostile;
    }

    public void moveTo(Place p)
    {
        current.removeCharacter(this);
        current = p;
        if(!current.name().equals("EXIT"))
        {
            System.out.println("thanks for playing " + name + ".");
            dropAllItems();
            removeCharacter(this);
        }
        else
        {
            current.addCharacter(this);
            System.out.println(name + " Moved to " + current.name() + ".");
        }
        return;
    }

    public  static Iterator<Character> getIterator()
    {
        return characters.values().iterator();
    }

    public abstract void makeMove();


    public void display()
    {
        System.out.println(this.name);
        for(int i = 0; i < this.description.length; i++)
            System.out.println(this.description[i]);
    }

    public void displayArtifacts()
    {
        for(int i = 0; i < items.size(); i++)
        {
            System.out.println("Name: " + this.items.get(i).name() + "\n" +
                    "Value " + this.items.get(i).value() + "\n" +
                    "Weight: " + this.items.get(i).weight() + "\n");
        }
    }

    public void addItem(Artifact item)
    {
        this.items.add(item);
    }

    public Artifact getArtifact(String s)
    {
        for(Artifact a : items)
        {
            if(a.name().equalsIgnoreCase(s))
                return a;
        }
        return null;
    }

    public String getRandomItem()
    {
        Random rand = new Random();
        if(items.size() <= 0)
            return "None";
        else
            return items.get(rand.nextInt(items.size())).name();
    }

    public void dropItem(String name) {
        for(Artifact a : items)
        {
            if(a.name().equalsIgnoreCase(name)) {
                items.remove(a);
                current.addArtifact(a);
                System.out.println(this.name + " dropped " + name + " in " + current.name());
                return;
            }
        }
    }

    public void dropAllItems()
    {
        for(Artifact a : items)
        {
            System.out.println("Dropping " + a.name());
            if(true)
                current.addArtifact(a);
            else
            {
                Place p = Place.getPlaceById(0);
                p.addArtifact(a);
            }
        }
        items = null;
    }

    public void useHealth(int i)
    {
        this.health += i;
    }

    public int getAttack()
    {
        return attack;
    }

    public void useAttack(int a)
    {
        health -= a;
    }

}

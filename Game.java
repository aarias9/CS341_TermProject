/**
 *  Alfonso Arias
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part III
 *
 *  GAME.java
 *
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Game
{
    private String GameName;
    private float GameVersion;
    private ArrayList <Place> places;
    private ArrayList <Artifact> artifacts;
    private ArrayList <Character> players;
    private Place current;
    private Place previous;
    private Artifact item;
    private Scanner scan;
    private int number;

    public Game(Scanner scan)
    {
        try {
            String input = CleanLineScanner.getCleanLine(scan);
            Scanner lineScanner = new Scanner(input);

            if(lineScanner.next().equalsIgnoreCase("GDF")) {
                this.places = new ArrayList<>();
                this.artifacts = new ArrayList<>();
                this.players = new ArrayList<>();

                this.GameVersion = Float.parseFloat(lineScanner.next());
                this.GameName = lineScanner.nextLine().trim();

                if(GameVersion < 4.0) {
                    this.current = null;
                    this.previous = null;
                    this.item = null;
                    this.number = 0;
                }
            }
            else
                return;

            while (scan.hasNextLine()) {
                input = CleanLineScanner.getCleanLine(scan);

                if(input == null)
                    break;

                String [] line = input.split(" ");

                if (line[0].equalsIgnoreCase("PLACES")) {
                    number = Integer.parseInt(line[1]);
                    for(int i= 0; i < number; i++) {
                        if(this.GameVersion < 4.0)
                            this.places.add(new Place(scan, this.GameVersion));
                        else
                            new Place(scan, this.GameVersion);
                    }
                }

                //Adds Directions
                if (line[0].equalsIgnoreCase("DIRECTIONS")) {
                    number = Integer.parseInt(line[1]);
                    for (int i = 0; i < number; i++) {
                        new Direction(scan, this.GameVersion);
                    }
                }

                //Adds Characters
                if(line[0].equalsIgnoreCase( "CHARACTERS"))
                {
                    number = Integer.parseInt(line[1]);
                    for(int i = 0; i < number; i++)
                    {
                        input = CleanLineScanner.getCleanLine(scan);
                        lineScanner = new Scanner(input);
                        String type = lineScanner.next();

                        input = CleanLineScanner.getCleanLine(scan);
                        lineScanner = new Scanner(input);
                        int spawnPoint = lineScanner.nextInt();

                        if(type.equalsIgnoreCase("PLAYER"))
                            new Player(scan, GameVersion, spawnPoint);
                        if(type.equalsIgnoreCase("NPC"))
                            new NPC(scan, GameVersion, spawnPoint);
                        if(type.equalsIgnoreCase("HOSTILE"))
                            new Hostile(scan, GameVersion, spawnPoint);
                        if(type.equalsIgnoreCase("FRIENDLY"))
                            new Friendly(scan, GameVersion, spawnPoint);
                    }
                }

                //Adds Artifacts
                if (line[0].equalsIgnoreCase("ARTIFACTS")) {
                    number = Integer.parseInt(line[1]);
                    for (int i = 0; i < number; i++)
                        new Artifact(scan, this.GameVersion);
                }
            }
            scan.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public String getGameName()
    {
        return this.GameName;
    }


    public void Play()
    {
        if(this.GameVersion < 4.0)
        {
            /**
            System.out.println("TO PLAY: Please enter:\n" +
                    "LOOK: To get your Bearings\n" +
                    "GO fallowed by a Direction (NORTH, SOUTH, EAST, WEST) to MOVE\n" +
                    "GET fallowed by the name of the ITEM To pick up items in the game, if available\n" +
                    "DROP fallowed by the name of the ITEM To Drop it in the Current Room\n" +
                    "INVENTORY or INVE to see what you have picked up in the game\n" +
                    "USE and the Name of the ITEM to use it\n" +
                    "EXIT or QUIT to close the game\n" +
                    "HELP to repeat these Instructions\n");

            System.out.println("Now lets enter into the world of " + getGameName() + "\n");

            //Gets the Location of the Starting room
            current = places.get(0);

            while (true) {
                scan = new Scanner(System.in);
                //If player is in a Room called EXIT -> Game Ends
                if (current.getName().equalsIgnoreCase("EXIT")) {
                    current.display();
                    continue;
                }
                current.display();
                System.out.println("Enter a Command\n");

                String cmd = scan.nextLine().toUpperCase();
                String[] input = cmd.split(" ", 2);

                // Checks if the exit/ quit to stop the loop or if the player enters a room called "EXIT" will also stop the loop
                // AKA quit the game
                if (input[0].equals("EXIT") || input[0].equals("QUIT"))
                {
                    break;
                }
                else
                {
                    if (input[0].equals("LOOK")) {
                        continue;
                    }

                    // Allows the player to change to a new room if possible
                    if (input[0].equals("GO")) {
                        previous = current;
                        //input = scan.nextLine().toUpperCase();
                        current = current.followDirection(input[1]);

                        // Explains why the room hasn't changed.
                        if (previous == current) {
                            if (current.directionLocked(input[1])) {
                                System.out.println("The path was Lock\n");
                                continue;
                            } else {
                                System.out.println("That direction doesn't Exists.\n");
                                continue;
                            }
                        } else {
                            if (!current.getName().equals("EXIT"))
                                System.out.println("You moved to a NEW Location\n");
                            continue;
                        }
                    }

                    // Allows player to unlock a path, can be changed for later.
                    if (input[0].equals("USE")) {
                        //gets the Artifact from the player
                        for (int i = 0; i < this.artifacts.size(); i++) {
                            if (input[1].equalsIgnoreCase(this.artifacts.get(i).getName())) {
                                this.item = this.artifacts.get(i);
                                break;
                            } else
                                this.item = null;
                        }
                        // uses Artifact
                        if (item != null)
                            this.current.useKey(item);
                        else
                            System.out.println("This Item " + input[1] + " is not in your Inventory");

                        continue;
                    }
                    if (input[0].equals("GET")) {
                        //input = scan.nextLine();
                        this.item = this.current.removeArtifactByName(input[1]);
                        if (item == null) {
                            System.out.println("No Item was picked up");
                            continue;
                        } else {
                            System.out.println("You have picked up the: " + item.getName() + "\n");
                            this.artifacts.add(item);
                            continue;
                        }
                    }

                    if (input[0].equals("DROP")) {
                        //gets the Artifact from the player
                        //String x = scan.nextLine();
                        for (int i = 0; i < this.artifacts.size(); i++) {
                            if (input[1].equalsIgnoreCase(this.artifacts.get(i).getName()))
                                this.item = this.artifacts.get(i);
                            else
                                this.item = null;
                        }


                        if (this.item == null) {
                            System.out.println("No Item was dropped");
                            continue;
                        } else {
                            //adds item to the current place
                            this.current.addArtifacts(this.item);
                            String name = this.item.getName();
                            //removes item/ Artifact from the player
                            for (int i = 0; i < this.artifacts.size(); i++) {
                                if (name.equalsIgnoreCase(this.artifacts.get(i).getName()))
                                    this.artifacts.remove(this.artifacts.get(i));
                            }
                            continue;
                        }
                    }

                    if (input[0].equals("INVENTORY") || input[0].equals("INVE")) {
                        if (!this.artifacts.isEmpty()) {
                            System.out.println("You Have");
                            for (int i = 0; i < this.artifacts.size(); i++) {
                                System.out.println("Name: " + this.artifacts.get(i).getName() + "\n" +
                                        "Value " + this.artifacts.get(i).Value() + "\n" +
                                        "Weight: " + this.artifacts.get(i).Weight() + "\n");
                            }
                            continue;
                        } else {
                            System.out.println("Your Inventory is Empty");
                            continue;
                        }
                    }

                    // Displays the HELP Menu
                    if (input[0].equals("HELP"))
                        System.out.println("TO PLAY: Please enter:\n" +
                                "LOOK: To get your Bearings\n" +
                                "GO fallowed by a Direction (NORTH, SOUTH, EAST, WEST) to MOVE\n" +
                                "GET fallowed by the name of the ITEM To pick up items in the game, if available" +
                                "DROP fallowed by the name of the ITEM To Drop it in the Current Room " +
                                "INVENTORY or INVE to see what you have picked up in the game." +
                                "USE and the Name of the ITEM to use it" +
                                "EXIT or QUIT to close the game\n" +
                                "HELP to repeat these Instructions\n");
                    else
                        System.out.println("Invalid Command, Please try again\n");

                }//else
            }//while
            */

        }// If game version is < 4.0

        else
        {
            System.out.println("Now lets enter into the world of " + getGameName() + "\n");

            while(true)
            {
                Iterator<Character> characters = Character.getIterator();
                while( characters.hasNext())
                {
                    Character c = characters.next();
                    if(c.isPlaying())
                    {
                        System.out.println(c.name() + ", Is now making it's turn.");
                        c.makeMove();
                    }
                }

            }
        }// Else() playing on version 4.0 and UP

        System.out.println("Game Over\nThank You for playing.");
    }


}//Place

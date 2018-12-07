/**
 * name: Juan C. Zambrano
 * ACCCid: jzambr7
 **/

import java.util.*;

public class Place 
{
	private Vector<Direction> directions = new Vector<Direction>();
    private Vector<Character> characters = new Vector<Character>();
	
	private int ID; 
    private String name;
    private String description;
    private boolean radiation = false;
    
    private ArrayList<Artifact> artifacts;
    static private HashMap<Integer, Place> places = new HashMap<Integer, Place>();
    
    /**
     * Scanner constructor
     **/
    public Place(Scanner sc, float version) {
        // Get ID and name
        String line = CleanLineScanner.getCleanLine(sc);
        Scanner lineScanner = new Scanner(line);
        ID   = lineScanner.nextInt();
        name = lineScanner.nextLine().trim();

        // Get number of description lines
        int count = sc.nextInt();

        // Complete description
        String desc = "";
        int i = 0;
        while(i<count) {
        	desc += (CleanLineScanner.getCleanLine(sc) + "\n");
        	i++;
        }
        description = desc;
        artifacts = new ArrayList<>();

        // Add the place to the collection of places.
        places.put(ID, this);
    }
    
    public void addArtifact(Artifact a) {
    	artifacts.add(a);
    }
    
    public void addCharacter(Character c){
        characters.add(c);
    }
    
    public void removeCharacter(Character c){
        characters.remove(c);
    }
    
    //uses key to unlock door, pattern MUST match
    public void useKey(Artifact a) {
        for(Direction d : directions) {
            if(a.getKeyPattern() == d.getLockPattern()) {
                d.unlock();
                return;
            }
            else if (a.getKeyPattern() < 0) {
            	d.unlock();
            	return;
            }
        }
        IO.display("Nothing happened...");
    }
    
    Place(int ID, String name, String description){
    	this.ID = ID;
    	this.name = name;
    	this.description = description;
        places.put(ID, this);
    }
    
    public String name(){
        return name;
    }

    public String description(){
        return description;
    }
    
    //adds direction to adjacent places
    public void addDirection(Direction dir){
        directions.add(dir);
    }
    
    //boolean to determine if place is an EXIT
    public boolean isExit(){
        return ID == 1;
    }
    
    //loops through characters by matching name
    public Character getCharacterByName(String string) {
    	Character result = null;
        for(Character c : characters) {
            if(c.name().equalsIgnoreCase(string)) {
            	result = c;
                return result;
            }
        }
		return null;
    }
    
    static public Place getPlaceById(Integer id) {
        if(id < 0)
            id *= -1;

        if(id == 0)
        {
            Random r = new Random();
            List<Integer> index = new ArrayList<>(places.keySet());
            id = index.get(r.nextInt(index.size()));

            return Place.places.get(id);
        }
        else
            return Place.places.get(id);
    }
    
    static public int getPlaceSize() {
        return Place.places.size();
    }    
    
    //Check to the illumination of the current place
    public boolean isRadiation() {
		return this.radiation;
	}
    
    //Setter of radiation
	public void setRadiation(boolean radiation) {
		this.radiation = radiation;
	}
    
	//display/print info
    public void display(){
        IO.display(name);
        IO.display(description);
    }
    
    public void print(){
        IO.display(">>================<<");
        IO.display("~Place Information~");
        IO.display(">>================<<");
        IO.display("Name:        " + this.name);
        IO.display("ID:          " + this.ID);
        IO.display("Description: " + this.description);
        IO.display(">>================<<");
        for(Direction d : this.directions) {
            IO.display("Direction ID: " + d.getID());
            IO.display("Direction:    " + d.getDirection());
        }
        for(Artifact a : this.artifacts)
            a.display();
    }
    
    /** 
     * followDirection( String ) : Place  Checks to see if this place has a valid unlocked Direction
     * corresponding to the String passed, and if so, returns the Place arrived at by following that
     * Direction. Otherwise it simply returns itself, i.e. this
     **/
    public Place followDirection(String s){
        for(Direction d: directions){
            if (d.match(s)){
                return d.follow();
            }
            IO.display("Can't go this way. Try again!");
        }
        return this;
    }

    public int id(){
        return this.ID;
    }
    
    public void removeArtifact(Artifact a) {
        artifacts.remove(a);
    }


    public String getRandomItem()
    {
        Random rand = new Random();
        if(artifacts.size() <= 0)
            return "None";
        else
            return artifacts.get(rand.nextInt(artifacts.size())).name();
    }

    public String getRandomDirection()
    {
        Random rand = new Random();
        if(directions.size() <= 0)
            return "LOOK";
        else
            return directions.get(rand.nextInt(directions.size())).toString();

    }
    
    public Place getRandomPlace(){
    	Random rand = new Random();

        //Select random number for place
        int rand_int = rand.nextInt(places.size());
        int counter = 0;
        
        for (Place p : places.values()) {
            if (counter == rand_int && (p.id() != 0 || p.id() != 1)) {
                return p;
            } else if (counter == rand_int && (p.id() == 0 || p.id() == 1)) {
                counter = 0;
                rand_int = rand.nextInt(places.size());
            }

            counter++;
        }
        return null; 
    }

    // Checks if the path is locked.
    public boolean directionLocked(String dir)
    {
        String x = String.valueOf(dir.toUpperCase());
        for (int i = 0; i < directions.size(); i++) {
            if (directions.get(i).match(x)) {
                return directions.get(i).isLocked();
            }
        }
        return false;
    }

    public Artifact removeArtifactByName(String name)
    {
        for(int i = 0; i < artifacts.size(); i++)
        {
            if(name.equalsIgnoreCase(this.artifacts.get(i).name()) && this.artifacts.get(i).weight() != -1)
            {   Artifact Item = this.artifacts.get(i);
                artifacts.remove(artifacts.get(i));
                return Item;
            }
            if(this.artifacts.get(i).weight() == -1)
                IO.display("This Item cannot be picked up, Its too HEAVY");
            else
                return null;
        }
        return null;
    }

}
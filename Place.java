/**
 * name: Juan C. Zambrano
 * ACCCid: jzambr7
 **/
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

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
        ID   = sc.nextInt();
        name = sc.nextLine().split("//")[0].trim();

        // Get number of description lines
        int count = sc.nextInt();

        // Complete description
        String desc = "";
        int i = 0;
        while(i<count) {
        	desc += (CleanLineScanner.getCleanLine(sc) + "\n");
        	i++;
        }
        desc = description;

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
        System.out.println("Nothing happened...");
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
        System.out.println(name);
        System.out.println(description);
    }
    
    public void print(){
        System.out.println(">>================<<");
        System.out.println("~Place Information~");
        System.out.println(">>================<<");
        System.out.println("Name:        " + this.name);
        System.out.println("ID:          " + this.ID);
        System.out.println("Description: " + this.description);
        System.out.println(">>================<<");
        for(Direction d : this.directions) {
            System.out.println("Direction ID: " + d.getID());
            System.out.println("Direction:    " + d.getDirection());
        }
        for(Artifact a : this.artifacts) a.print();		// No display method in artifact, using print for now
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
            System.out.println("Can't go this way. Try again!");
        }
        return this;
    }  
    
    public void removeArtifact(Artifact a) {
        artifacts.remove(a);
    }

}
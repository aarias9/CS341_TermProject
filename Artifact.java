/* ------------------------------------------------
* Author: Robert L Barrera
* NetId: rbarre4	ACCC: rbarrera
* Class: CS 342, Fall 2018
* Term Project Part 4: Artifact Class
* System: Windows 10, Eclipse
* November 14, 2018
* -------------------------------------------------
*/

import java.util.*;

public class Artifact {
	private int ID; 			// ID of artifact
	private String name;		// Name of artifact
	private String description;	// Description of artifact
	private int value;			// Value of artifact
	private int mobility;		// Size or Weight of artifact
	private int keyPattern;		// 0+ if artifact is a key, else 0
	private int healthPoints;	// Health points
	private int damagePoints;	// Damage points
	private int armorPoints;	// Armor points
	
	// Constructor for a Artifact
	public Artifact(Scanner passed, int version) {
		String line = CleanLineScanner.getCleanLine(passed);	// Get a clean line
		Scanner cleanedLine = new Scanner(line);	// New scanner for parsing line
		int descNum = 0;
		int i = 0;
		int placeOrCharID = 0;
		damagePoints = 0;
		armorPoints = 0;
		
		placeOrCharID = cleanedLine.nextInt();	// Get place ID for place
		line = CleanLineScanner.getCleanLine(passed);	// Get next line
		cleanedLine.close();
		cleanedLine = new Scanner(line);
		ID = cleanedLine.nextInt();			// Get ID
		value = cleanedLine.nextInt();		// Get value
		mobility = cleanedLine.nextInt();	// Get mobility/weight/size
		keyPattern = cleanedLine.nextInt();	// Get keyPattern
		name = "";	
		while(cleanedLine.hasNext()) {		// Get name till end of line
			name += cleanedLine.next() + " ";
		}
		
		line = CleanLineScanner.getCleanLine(passed);	
		cleanedLine.close();
		cleanedLine = new Scanner(line);
		descNum = cleanedLine.nextInt();		// Get number of lines of description
		description = "";
		while(i < descNum) {
			description += CleanLineScanner.getCleanLine(passed) + "\n";
			i++;
		}
		
		if (ID > 0 && ID < 101){
			healthPoints = 0;
		}
		else if (ID > 100 && ID < 201){
			healthPoints = ID - 101;
		}
		
		if(placeOrCharID < 0) {	// Add artifact to character's artifacts
			Character.getCharacterBYID(placeOrCharID).addItem(this);
		}
		else {
			Place.getPlaceByID(placeOrCharID).addArtifact(this);	// Add this artifact to it's place
		}
		
		
		cleanedLine.close();
	}
	
	// Returns the value of the artifact
	public int value() {
		return value;
	}
	
	// Returns the movability value
	public int weight() {
		return mobility;
	}
	
	// Returns name of artifact
	public String name() {
		return name;
	}
	
	// Returns the description of artifact
	public String description() {
		return description;
	}
	
	// Uses artifact depending on type
	public void use(Character character, Place place) {
		if (keyPattern > 0) {
			place.useKey(this);
		}
		else if (healthPoints > 0){
			//character.usehealth(this);
		}
		else {
			System.out.println("Artifact was not used!");
		}
				
	}
	
	// Returns keyPattern of artifact (Not in assignment writeup)
	public int getKeyPattern() {
		return keyPattern;
	}
	
	// Returns healthPoints of artifact
	public int getHealthPoints() {
		return healthPoints;
	}
	
	// Returns damagePoints of artifact
	public int getDamagePoints() {
		return damagePoints;
	}
	
	// Returns armourPoints of artifact
	public int getArmorPoints() {
		return armorPoints;
	}
	
	// Returns true if string matches name
	public boolean match(String name) {
		return this.name.equalsIgnoreCase(name);
	}
	
	// Prints out artifact information
	public void print() {
		System.out.println("Name is: " + name + ", " + "ID is: " + ID);
		System.out.print("Description is: " + description);
		System.out.println("Value is: " + value + ", Mobility is: " + mobility);
		System.out.println("KeyPattern is: " + keyPattern);
		System.out.println("HealthPoints is: " + healthPoints);
		System.out.println("\n");
	}
}

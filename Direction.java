/**
 * name: Juan C. Zambrano
 * ACCCid: jzambr7
 * Class that defines the Direction objects.
 * Two objects are held - 'to' and 'from' - 
 * to determine location placement of characters
 **/

import java.util.Scanner;

public class Direction {

    private enum DirType {
        //19 Directions: 16 Compass, Up, Down, & NONE
        NONE("None",""), U("Up", "U"), D("Down", "D"),
        N("North", "N"), NE("Northeast", "NE"), NNE("North-Northeast", "NNE"),   //North-based
        NW("Northwest", "NW"), NNW("North-Northwest","NNW"),
        S("South","S"), SE("Southeast", "SE"), SSE("South-Southeast","SSE"),      //South-based
        SW("Southwest","SW"), SSW("South-Southwest","SSW"),
        E("East","E"), ENE("East-Northeast","ENE"), ESE("East-Southeast","ESE"), //East-based
        W("W","West"), WNW("West-Northwest","WNW"), WSW("West-Southwest","WSW"); //West-based

        private String textF, abbrF; // direction fields
        DirType (String str1, String str2) {
            abbrF = str1;
            textF = str2;
        }
        
        //String toString( ) returns the text field..
        public String toString() {
            return this.textF;
        }
        
         // boolean match( String ) returns true if the given string matches either the text or the
         // abbreviation, ignoring case.
        public boolean match(String s) {
            if (s.equalsIgnoreCase(abbrF) || s.equalsIgnoreCase(textF)) return true;
            else return false;
        }
    }
    
	//VARIABLES
	private DirType direction;
    private boolean locked;
    private Place from;
    private Place to;
	private int ID;
	private int lockPattern;
	private Scanner lineScanner;
	protected String line;
	
	
    //GETTERS [SELF-EXPLANATORY]
    public String getName(){
        return this.direction.toString();
    }

    public int getID() {
        return this.ID;
    }
    
    public boolean match(String dir){
    	return this.direction.match(dir);	
	}
    
    public int getLockPattern() { 
    	return this.lockPattern; 
    }
    
    public String getDirection() { 
    	return this.direction.toString(); 
    }

    public void lock(){
        if (!locked) this.locked = true;
    }
    
    public void unlock(){
        if (locked) this.locked = false;
    }

    public boolean isLocked(){
        return this.locked;
    }

    
    public Place follow(){
        if (!locked)
            return this.to;
        else
            return this.from;
    }
    //end GETTERS
    
    public boolean useKey(Artifact artifact) {
    	//unlock if lockPattern == 0
    	if (this.lockPattern == 0) return !(this.locked);
    	//unlock if keyPattern matches lockPattern
    	else if(artifact.getKeyPattern() > 0){
    		if (artifact.getKeyPattern() == this.getLockPattern()) {
    			this.locked = !(this.locked);
    		}
    	}
    	//else lock stays locked
		return this.locked;
    }
    
    //Scanner constructor
    public Direction(Scanner sc, float version) {
    	line = CleanLineScanner.getCleanLine(sc);
        lineScanner = new Scanner(line);
        
        ID = lineScanner.nextInt();
        int fromID = lineScanner.nextInt();
        this.from = Place.getPlaceById(fromID);
        direction = DirType.valueOf(lineScanner.next());
        int toID = lineScanner.nextInt();
        this.to = Place.getPlaceById(toID);
        lockPattern = lineScanner.nextInt();
        
        if(lockPattern!= 0) this.lock();
        else this.unlock();
        
        Place.getPlaceById(fromID).addDirection(this);
    }
    

    public void print(){
        IO.display(">>====================<<");
        IO.display("~Direction Information~");
        IO.display(">>====================<<");
        IO.display("ID:         " + this.ID);
        IO.display("From Place: " + this.from.name());
        IO.display("To Place:   " + this.to.name());
        IO.display("Direction:  " + this.direction.toString());
        if (this.isLocked()) {
            IO.display("Direction is locked... ");
        }
        else {
            IO.display("Direction is unlocked! ");
        }
        IO.display(">>====================<<");
    }

}

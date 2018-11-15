/**
 * name: Juan C. Zambrano
 * ACCCid: jzambr7
 **/

import java.util.Scanner;

public class RadiatedPlace extends Place {
	
	public RadiatedPlace(Scanner scan, float version)
    {
        super(scan, version);
        super.setRadiation(true);
        
    }
	
	public void radDamage(Character c)
    {
		if (c.isPLaying) {
			c.health -= 5;
			System.out.println(c.current + " is radiated. You suffer\n5 health from open contact.");
		}
    }
	
}

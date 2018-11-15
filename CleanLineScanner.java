/**
 *  Alfonso Arias
 *  U. of Illinois, Chicago
 *  CS 342, Fall 2018
 *  Term Project: Part III
 *
 *  CLEANLINESCANNER.java
 *
 */

import java.util.Scanner;

public class CleanLineScanner {
    public static String getCleanLine(Scanner Scan)
    {
        while(Scan.hasNext())
        {
            String line = Scan.nextLine();
            if(!line.isEmpty())
            {
                String[] result = line.split("//");
                line = result[0].trim();
                if(line.length() > 0)
                    return line;
            }
        }
        return null;
    }

}

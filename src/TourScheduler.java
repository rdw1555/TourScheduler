// Rick Wallert
// Tour Scheduler V1.0
// March 22nd, 2022

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TourScheduler {
    /**
     * main - Runner for program
     * @param args the command line arguments, filename of data file
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Read in data filename from system arguments
        String filename = args[0];

        // Create an instance of the TourScheduler object
        TourScheduler ts = new TourScheduler(filename);
    }

    public TourScheduler(String filename) throws FileNotFoundException {
        // Print out that the program is starting
        System.out.println("Tour Guide Availability Scheduler\n");

        // Create a scanner for the file
        Scanner in = new Scanner(new File(filename));

        // Skip past very first line
        in.nextLine();

        // Loop through file, parse based off of lines / commas
        while(in.hasNext()){
            // Read in current line
            String tempLine = in.nextLine();

            // Print out the line
            System.out.println(tempLine);

            // PARSE UP THE LINE BASED OFF OF COMMAS, CHECK FOR QUOTATIONS INDICATING THAT THE FOLLOWING IS A STRING LITERAL - NOT A SEPARATE PIECE OF DATA
            String[] almostParsed = tempLine.split(",");

            // boolean flag to check for quotations
            boolean flag = false;

            for(int i = 0; i < almostParsed.length; i++){
                // Look at the current string, check to see if there is a quotation mark in the first character or last character
                // If there is, set a boolean flag and move to the next item
                // On next item, check to see if boolean flag is raised, and if so check to see if there is a quotation mark
                // If there is one, that marks the end of that string literal, so the insides will be a singular string - not separate ones

                // Pull out the current string
                String tempEntry = almostParsed[i];

                System.out.println("\n" + tempEntry);

                // First, check if the flag is raised
                if(flag){
                    // The flag is raised, so we need to check if it's the end yet
                    if(tempEntry.charAt(tempEntry.length()-1) == '\"'){
                        System.out.println("Entry " + i + " ends a string group");
                        // Lower the flag
                        flag = false;
                    }
                    else{
                        System.out.println("Entry " + i + " is in the middle of a string grouping");
                        // If so, just move on to the next iteration
                    }
                }
                else{
                    // Look at the first position
                    if(tempEntry.charAt(0) == '\"'){
                        System.out.println("Entry " + i + " starts a string group");
                        // Raise the flag
                        flag = true;
                    }
                    else{
                        // If the flag isn't raised, and there is no quotation mark starting in the string, then the entry is normal
                        System.out.println("Entry " + i + " is normal");
                    }
                }
            }
        }
    }
}
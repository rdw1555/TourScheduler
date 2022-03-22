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

            for(int i = 0; i < almostParsed.length; i++){
                // Look at the current string, check to see if there is a quotation mark in it
                // If there is, set a boolean flag and move to the next item
                // On next item, check to see if boolean flag is raised, and if so check to see if there is a quotation mark
                // If there is one, that marks the end of that string literal, so the insides will be a singular string - not separate ones
                System.out.println("Implement this");
            }
        }
    }
}
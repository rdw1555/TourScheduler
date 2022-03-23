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

        // Parse out the first line for labeling purposes
        String firstLine = in.nextLine();

        // Break up the data on commas to save for the labels of each entry
        String[] labels = firstLine.split(",");

        String[] weekLabels = new String[labels.length-3];

        if (weekLabels.length >= 0) System.arraycopy(labels, 3, weekLabels, 0, weekLabels.length);

        // Create a list of all of the tour Guides
        List<Guide> tourGuides = new ArrayList();

        // Loop through file, parse based off of lines / commas
        while(in.hasNext()){
            // Read in current line
            String tempLine = in.nextLine();

            // Print out the line
            System.out.println(tempLine);

            // PARSE UP THE LINE BASED OFF OF COMMAS, CHECK FOR QUOTATIONS INDICATING THAT THE FOLLOWING IS A STRING LITERAL - NOT A SEPARATE PIECE OF DATA
            String[] almostParsed = tempLine.split(",");

            // ArrayList to store the strings that make up a grouped one, needs to be stored locally to the line loop but globally to the almostParsed loop
            List<String> grouping = new ArrayList<>();

            // boolean flag to check for quotations
            boolean flag = false;

            // Create an ArrayList to store all of the Guide's information in
            List<String> guideInfo = new ArrayList<>();

            for(int i = 0; i < almostParsed.length; i++){
                // Look at the current string, check to see if there is a quotation mark in the first character or last character
                // If there is, set a boolean flag and move to the next item
                // On next item, check to see if boolean flag is raised, and if so check to see if there is a quotation mark
                // If there is one, that marks the end of that string literal, so the insides will be a singular string - not separate ones

                // Pull out the current string
                String tempEntry = almostParsed[i];

                // First, check if the flag is raised
                if(flag){
                    // The flag is raised, so we need to check if it's the end yet
                    if(tempEntry.charAt(tempEntry.length()-1) == '\"'){
                        // Ends a string group
                        // Take out the quotation and add it to the grouping list
                        grouping.add(almostParsed[i].substring(0,almostParsed[i].length()-1));

                        // Concatenate all of grouping's contents into one string, and add that to guideInfo
                        StringBuilder groupingConcat = new StringBuilder();
                        for (String s : grouping) {
                            groupingConcat.append(s);
                        }
                        guideInfo.add(groupingConcat.toString());

                        // Lower the flag
                        flag = false;

                        // Finally, clear the information out of grouping to prepare it for more possible quotation-based strings
                        grouping.clear();
                    }
                    else{
                        // Inside a string group
                        // Add the word to the grouping list, along with a comma for readability (and potential further parsing)
                        grouping.add((almostParsed[i] + ","));
                    }
                }
                else{
                    // Look at the first position
                    if(tempEntry.charAt(0) == '\"'){
                        // Starts a string group
                        // Raise the flag
                        flag = true;

                        // Take out the quotation and add it to the grouping list
                        // Add a comma at the end to increase readability (and allow for further parsing if necessary)
                        String fixedString = almostParsed[i].substring(1) + ",";
                        grouping.add(fixedString);
                    }
                    else{
                        // If the flag isn't raised, and there is no quotation mark starting in the string, then the entry is normal
                        // Since the word is normal, all that's left is to add it to guideInfo
                        guideInfo.add(almostParsed[i]);
                    }
                }
            }
            // Now that we've parsed the proper information, clean it up
            // Remove the first element in guideInfo as it is irrelevant
            guideInfo.remove(0);

            // Pass labels and guideInfo into a separate method to create an individual tour Guide for this information
            Guide newGuide = createGuide(weekLabels, guideInfo);

            // Add that Guide to the tourGuides list
            tourGuides.add(newGuide);
        }

        // Now that we're out of that loop, we should have all of the tour guide info in place
    }

    public Guide createGuide(String[] weekLabels, List<String> guideInfo){
        // First, pull the guide availability out of guideInfo in order to convert it to a String[]
        String[] availabilities = new String[guideInfo.size()-2];
        for(int i = 0; i < availabilities.length; i++){
            availabilities[i] = guideInfo.get(i+2);
        }

        // Pull out some more string constants for the Guide object to be made
        String email = guideInfo.get(0);
        String name = guideInfo.get(1);

        // Create the Guide object
        Guide tempGuide = new Guide(email, name, weekLabels, availabilities);

        // return the created guide
        return tempGuide;
    }
}
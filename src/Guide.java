// Tour Guide object
// Should store the name of the tour guide (Primary Key) and their availabilities

public class Guide {
    // Variables for use of each guide
    // String to store the name of the tour guide
    private final String email;
    private final String name;
    private final String[] weekLabels;
    private final String[] availabilities;

    /**
     * Guide - constructor
     * Creates a new tour Guide object
     * @param email - email of the tour guide
     * @param name - name of the tour guide
     */
    public Guide(String email, String name, String[] weekLabels, String[] availabilities) {
        // Set the private global variables
        this.email = email;
        this.name = name;
        this.weekLabels = weekLabels;
        this.availabilities = availabilities;
    }

    /**
     * Guide - overloaded constructor / default constructor
     * Creates a blank tour Guide with no information
     */
    public Guide(){
        this.email = "";
        this.name = "";
        this.weekLabels = new String[0];
        this.availabilities = new String[0];
    }

    /**
     * getEmail() - getter method for Guide email
     * @return - email of the tour guide
     */
    public String getEmail(){ return email; }

    /**
     * getName() - getter method for Guide name
     * @return - name of the tour guide
     */
    public String getName(){ return name; }

    /**
     * getLabels() - getter method for the week labels
     * @return - labels of all of the weeks, regardless of availability or not
     */
    public String[] getLabels() { return weekLabels; }

    /**
     * getAvailability() - getter method for the tour guide's availability
     * @return - all of the tour guide's availability
     */
    public String[] getAvailability() { return availabilities; }

    /**
     * toString() - returns string representation of the Guide object
     * @return string representation of the Guide object
     */
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Name: ").append(name);
        result.append("\nEmail: ").append(email);

        result.append("\nDays and Availabilities:");

        for(int i = 0; i < weekLabels.length; i++){
            result.append("\n\t").append(weekLabels[i]).append(":\t").append(availabilities[i]);
        }

        return result.toString();
    }
}

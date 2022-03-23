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
     * toString() - returns string representation of the Guide object
     * @return string representation of the Guide object
     */
    public String toString(){ return "Name: " + name + "\nEmail: " + email; }
}

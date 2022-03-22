// Tour Guide object
// Should store the name of the tour guide (Primary Key) and their availabilities

public class Guide {
    // Variables for use of each guide
    // String to store the name of the tour guide
    private final String name;

    /**
     * Guide - constructor
     * Creates a new tour Guide object
     * @param name - name of the tour guide
     */
    public Guide(String name) {
        // Set the private global variables
        this.name = name;
    }

    /**
     * getName() - getter method for Guide name
     * @return - name of the tour guide
     */
    public String getName(){ return name; }

    /**
     * toString() - returns string representation of the Guide object
     * @return string representation of the Guide object
     */
    public String toString(){ return "Name: " + name; }
}

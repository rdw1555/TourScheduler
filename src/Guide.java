// Tour Guide object
// Should store the name of the tour guide (Primary Key) and their availabilities

public class Guide {
    // Variables for use of each guide
    // String to store the name of the tour guide
    private final String email;
    private final String name;

    /**
     * Guide - constructor
     * Creates a new tour Guide object
     * @param name - name of the tour guide
     */
    public Guide(String email, String name) {
        // Set the private global variables
        this.email = email;
        this.name = name;
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

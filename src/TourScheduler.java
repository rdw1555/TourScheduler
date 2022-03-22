// Rick Wallert
// Tour Scheduler V1.0
// March 22nd, 2022

public class TourScheduler {
    /**
     * main - Runner for program, checks for user input (shouldn't be any)
     * @param args
     */
    public static void main(String[] args) {
        // Create an instance of the TourScheduler object
        String testData = args[0];

        //System.out.println(testData);

        TourScheduler ts = new TourScheduler(testData);
    }

    public TourScheduler(String data){
        // Bulk of program goes here
        System.out.println("Tour Guide Availability Scheduler\n");

        //Guide Rick = new Guide("Rick");

        //System.out.println(Rick.toString());
        System.out.println(data);
    }
}
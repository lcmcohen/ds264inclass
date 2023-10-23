package ds264.intro.lnklstwaze;

/**
 * Application that maintains Routes, which are built out of ordered Segments.
 */
public class WazeApp {
    public static void main(String[] args) {

        Route rt = new Route("Elite Cafe"); // Create new route - will calculate segments
        System.out.println(rt);             // print out route

        Boolean insertedOK = rt.insertWaypoint("75th Ave", "Simcha Palace");

        if (insertedOK)
            System.out.println(rt);             // print out route
        else
            System.out.println("Could not find existing location to insert after");
    }
}

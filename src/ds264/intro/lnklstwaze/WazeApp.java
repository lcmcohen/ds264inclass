package ds264.intro.lnklstwaze;

/**
 * Application that maintains Routes, which are built out of ordered Segments.
 */
public class WazeApp {
    public static void main(String[] args) {

        Route rt = new Route("Elite Cafe"); // Create new route - will calculate segments
        System.out.println(rt);             // print out route
    }
}

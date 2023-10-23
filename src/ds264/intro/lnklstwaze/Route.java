package ds264.intro.lnklstwaze;

import java.util.Date;

import static ds264.intro.lnklstwaze.Segment.WAYPOINT_LENGTH;

/**
 * The Route to a particular destination, represented by multiple ordered segments
 */
public class Route {
    String destinationName;
    Date lastCalc;              // when this route was last calculated
    Segment[] segments;         // the various segments, e.g. stops, roads to drive on


    /**
     * Construct a Route, containing necessary segments
     *
     * @param dest Name of the destination
     */
    public Route(String dest) {
        destinationName = dest;
        segments = new Segment[20];     // todo how many could we have ?
        reCalculate();                  // figure out the segments
    }


    /**
     * Calculate (or recalc) the segments needed to get to the destination.
     */
    public void reCalculate() {
        // hard code route to Elite Cafe
        segments[0] = new Segment("Lander", WAYPOINT_LENGTH);
        segments[1] = new Segment("150th Street", 20);
        segments[2] = new Segment("75th Ave", 300);
        segments[3] = new Segment("Main Street", 600);
        segments[4] = new Segment("Elite Cafe", 0);
        lastCalc = new Date();
    }


    /**
     * Create string representing entire Route and its segments
     */
    @Override
    public String toString() {
        String str = String.format("Route for %s calculated at %s\n",
                destinationName, lastCalc);
        // add in each segment
        for (Segment seg : segments) {
            if (seg != null) {
                str += seg + "\n";
            }
        }
        return str;
    }
}

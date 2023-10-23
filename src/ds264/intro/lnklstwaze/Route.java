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

    /**
     * Insert a new location (waypoint) as a new segment after an existing location
     *
     * @param existingLocation after which to place the new location
     * @param newLocation      to be inserted after the specified existing location
     * @return Boolean indicating if able to find existing location and insert after it.
     */
    public Boolean insertWaypoint(String existingLocation, String newLocation) {

        // Make a new segment object that represents the new location to be added
        Segment newSegment = new Segment(newLocation, WAYPOINT_LENGTH);

        // Find the existing location
        Segment existingSeg = null;
        for (int ix = 0; ix < segments.length && segments[ix] != null; ix++) {
            if (segments[ix].location.equals(existingLocation)) {
                existingSeg = segments[ix];
                break;
            }
        }

        // If we couldn't find existing segment, return null
        if (existingSeg == null)
            return false;

        System.out.println("Will add new location after this segment:" + existingSeg);

        // now insert new segment after existing segment
        /*
          TODO: OY VEY - need to shift all subsequent segments forward, and may also run out
          of space and have to make a new array and copy everything
               AIN'T NO ONE GOT TIME FOR THAT
         */


        return true;
    }
}

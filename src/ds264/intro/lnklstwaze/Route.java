package ds264.intro.lnklstwaze;

import java.util.Date;

import static ds264.intro.lnklstwaze.Segment.WAYPOINT_LENGTH;

/**
 * The Route to a particular destination, represented by multiple ordered segments
 */
public class Route {
    String destinationName;
    Date lastCalc;              // when this route was last calculated
    Segment segments;           // First node of the various segments, e.g. stops, roads to drive on


    /**
     * Construct a Route, containing necessary segments
     *
     * @param dest Name of the destination
     */
    public Route(String dest) {
        destinationName = dest;
        segments = null;
        reCalculate();                  // figure out the segments
    }


    /**
     * Calculate (or recalc) the segments needed to get to the destination.
     */
    public void reCalculate() {
        // hard code route to Elite Cafe
        Segment newSeg, prevSeg;    // temporary references to segments

        // First segment is a special case - must be 'anchored' by Route
        newSeg = new Segment("Lander", WAYPOINT_LENGTH);
        this.segments = newSeg;  // make Route object point to first segment

        prevSeg = newSeg;       // Keep a reference to new seg, which will now be 'previous'
        newSeg =  new Segment("150th Street", 20);  // get new segment
        prevSeg.setNextSegment(newSeg);             // point prev seg to new seg

        prevSeg = newSeg;
        newSeg = new Segment("75th Ave", 300);
        prevSeg.setNextSegment(newSeg);

        prevSeg = newSeg;
        newSeg = new Segment("Main Street", 600);
        prevSeg.setNextSegment(newSeg);

        prevSeg = newSeg;
        newSeg = new Segment("Elite Cafe", 0);
        prevSeg.setNextSegment(newSeg);

        // TODO: all of the above could be shortened with a generalized add() method

        newSeg.setNextSegment(null);
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
        for (Segment seg = this.segments; seg != null; seg = seg.getNextSegment()) {
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
        for (Segment seg = this.segments; seg != null; seg = seg.getNextSegment())  {
            if (seg.location.equals(existingLocation)) {
                existingSeg = seg;
                break;
            }
        }

        // If we couldn't find existing segment, return null
        if (existingSeg == null)
            return false;

        System.out.println("Will add new location after this segment:" + existingSeg);

        // now insert new segment after existing segment

        // point the new segments 'next' pointer to the same next node pointed to by existing node
        newSegment.setNextSegment(existingSeg.getNextSegment());

        // point the existing segment's next to the new segment
        existingSeg.setNextSegment(newSegment);

        return true;
    }
}

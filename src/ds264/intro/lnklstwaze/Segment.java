package ds264.intro.lnklstwaze;

/**
 * Represent one segment of a route. A segment really should have a starting and end point,
 * but for simplicity we just give a street name.
 * A segment can be a street to travel, or can represent a starting/stopping/waypoint.
 * A segment can point to the next segment in the linked list of segments, or be null for end.
 */
public class Segment {
    static final int WAYPOINT_LENGTH = 0;
    String location;      // the street to ride on, or a location/place
    long length;         // how long, e.g. in feet, zero if a stop/waypoint
    long timeEst;        // most recently recalculated estimate of time in seconds
    Segment nextSegment;    // reference to next segment in route, or null if end.

    /**
     * Construct a segment
     *
     * @param name   the name of a waypoint or street
     * @param length length of street, or 0 if a waypoint
     */
    public Segment(String name, int length) {
        this.location = name;
        this.length = length;
    }


    /**
     * Create string representing a segment
     */
    @Override
    public String toString() {
        return String.format("\t %s: \t%s %s",
                length > WAYPOINT_LENGTH ? "Street" : "waypoint", location,
                length > WAYPOINT_LENGTH ? "for " + length + " feet" : "");
    }

    /**
     * Get the next segment pointed to by this segment
     * @return the next segment
     */
    public Segment getNextSegment() {
        return nextSegment;
    }

    /**
     * Set this segment to point to another segment that is the next segment in a list
     * @param nextSegment the segment that this object should point to
     */
    public void setNextSegment(Segment nextSegment) {
        this.nextSegment = nextSegment;
    }
}

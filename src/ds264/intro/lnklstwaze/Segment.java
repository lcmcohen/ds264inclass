package ds264.intro.lnklstwaze;

/**
 * Represent one segment of a route. A segment really should have a starting and end point,
 * but for simplicity we just give a street name.
 * A segment can be a street to travel, or can represent a starting/stopping/waypoint.
 */
public class Segment {
    static final int WAYPOINT_LENGTH = 0;
    String location;      // the street to ride on, or a location/place
    long length;         // how long, e.g. in feet, zero if a stop/waypoint
    long timeEst;        // most recently recalculated estimate of time in seconds

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
}

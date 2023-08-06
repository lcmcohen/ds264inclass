package ds264.bigdata.storage;

import ds264.bigdata.Storeable;

/**
 * Implement all Storeable operations using Arrays. Use 2 parallel arrays, one for the issue ID
 * and one for the corresponding issue description at that same index.
 */
public class StoreInArray implements Storeable {
    protected String[] descriptions;
    protected String[] IDs;

    int nextIndex;  // next free index into array, also represents number of items in array

    /**
     * Constructor - allocate storage for desired number of rows, initialize counters.
     *
     * @param maxrows
     */
    public StoreInArray(int maxrows) {
        descriptions = new String[maxrows];
        IDs = new String[maxrows];
        nextIndex = 0;
    }

    @Override
    public Boolean addRow(String issueID, String issueDesc) {
        IDs[nextIndex] = issueID;
        descriptions[nextIndex] = issueDesc;

        nextIndex++;
        return true; //TODO add bounds check?
    }

    @Override
    public int getNumRows() {
        return nextIndex;
    }

    @Override
    public String getDescByID(String issueID) {
        // Search IDs array for index of desired issue ID
        for (int ix = 0; ix < nextIndex; ix++) {
            if (issueID.equals(IDs[ix])) {
                return descriptions[ix];    // get the description at corresponding index
            }
        }
        return null;    // couldn't be found
    }
}

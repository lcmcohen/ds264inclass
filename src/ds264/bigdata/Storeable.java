package ds264.bigdata;

/**
 * Declare capabilities of all classes used to store/manipulate 311 issue data
 *
 */
public interface Storeable {
    /**
     * Add a row to the loadable class
     * @param issueID This field will be the lookup key
     * @param issueDesc
     * @return True if success
     */
    Boolean addRow(String issueID, String issueDesc);

    /**
     * Get the numbers of rows loaded so far
     * @return
     */
    int getNumRows();


    /**
     * Get a row using issue ID as lookup key
     * @param issueID
     * @return the description for the issue referenced by issueID
     */
    String getDescByID(String issueID);

}

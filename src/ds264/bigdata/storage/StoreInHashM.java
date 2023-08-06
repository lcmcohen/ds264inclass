package ds264.bigdata.storage;

import ds264.bigdata.Storeable;

import java.util.HashMap;

/**
 * Implement all Storeable operations using HashMap.
 */
public class StoreInHashM implements Storeable {
    HashMap<String, String> issues;


    /**
     * Constructor - allocate storage for desired number of rows.
     *
     * @param maxrows
     */
    public StoreInHashM(int maxrows) {
        issues = new HashMap<>(maxrows, 0.75f);
    }

    @Override
    public Boolean addRow(String issueID, String issueDesc) {
        issues.put(issueID, issueDesc);
        return true;    //TODO add any error checking ?
    }

    @Override
    public int getNumRows() {
        return issues.size();
    }

    @Override
    public String getDescByID(String issueID) {
        return issues.get(issueID);
    }
}

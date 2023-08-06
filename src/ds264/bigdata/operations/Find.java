package ds264.bigdata.operations;

import ds264.bigdata.Storeable;

/**
 * Utility methods to execute various 'find' operations and report their execution time
 */
public class Find {

    /**
     * Search for issue by an ID
     *
     * @param data    what data structure class to search
     * @param issueID the issue ID to search for
     */
    protected static void searchItems(Storeable data, String issueID) {
        String msgFormat = "Search by ID: Class %s took %4d MSec to find Issue: %s %s%n";
        long startTime, endTime;
        String issueDescr;

        startTime = System.currentTimeMillis();
        issueDescr = data.getDescByID(issueID);
        endTime = System.currentTimeMillis();

        System.out.printf((msgFormat), data.getClass().getSimpleName(), (endTime - startTime), issueID, issueDescr);
    }
}

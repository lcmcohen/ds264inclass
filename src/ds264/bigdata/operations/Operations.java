package ds264.bigdata.operations;

import ds264.bigdata.BigdataApp;
import ds264.bigdata.Storeable;

import java.io.Console;

/**
 * Manage all operations that can be tested/benchmarked,
 * provides canned operations and a parse-execute for commands from console.
 */
public class Operations {

    /**
     * Execute a group of predefined operations as a quick test of all data structures.
     * Same series of tests are executed/reported 4 times
     */
    public void doCannedOperations() {

        for (int ntimes = 1; ntimes <= 4; ntimes++) {
            System.out.println("Canned Operations - iteration #" + ntimes);

            // Search all data structures for early-occurring value
            for (Storeable storeable : BigdataApp.storeables) {
                Find.searchItems(storeable, BigdataApp.firstLastIDs[0]);
            }

            // Search all data structures for late-occurring value
            for (Storeable storeable : BigdataApp.storeables) {
                Find.searchItems(storeable, BigdataApp.firstLastIDs[1]);
            }
        }

        System.out.println();
    }


    /**
     * Read and parse commands from console, and execute the appropriate operations against the
     * specified data structure. Will not work in an IDE.
     * Keeps reading in a loop until terminated.
     */
    public void parseAndExec() {
        String cmdLine;
        String[] fields = null;
        Console console = System.console();
        if (console == null) {
            throw new UnsupportedOperationException("No Console available in IDE");
        }

        while ((cmdLine = console.readLine("\nEnter a request consisting of:  OPERATION  DATACLASS VALUE\n")) != null) {
            Storeable dataClass;
            try {
                fields = cmdLine.split(" ");

                switch (fields[0].toUpperCase()) {
                    case "CANNED":
                        doCannedOperations();
                        break;
                    case "GET":
                        if ((fields.length < 3) || (dataClass = getStoreable(fields[1])) == null) {
                            console.printf("Invalid parameters for command %\n", fields[0]);
                            continue;
                        }
                        Find.searchItems(dataClass, (fields[2]));
                        break;
                    default:
                        System.out.println("Unknown Operation: " + fields[0]);
                }

            } catch (Exception ex) {
                console.printf("Exception %s inside of command line processor\n", ex.getLocalizedMessage());
            }

        }
    }

    /**
     * Find a class whose name contains the requested storename (partial match)
     *
     * @param storename - part or all of the name of a Storeable class to find
     * @return
     */
    private Storeable getStoreable(String storename) {
        for (Storeable storeable : BigdataApp.storeables) {
            if (storeable.getClass().getSimpleName().toLowerCase().contains(storename))
                return storeable;   // found a Storeable class that at least partially matches
        }
        System.out.printf("A class corresponding to %s was not found\n", storename);
        return null;    // not found
    }
}

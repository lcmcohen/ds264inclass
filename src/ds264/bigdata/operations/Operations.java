package ds264.bigdata.operations;

import ds264.bigdata.BigdataApp;
import ds264.bigdata.Storeable;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Manage all operations that can be tested/benchmarked,
 * provides canned operations and a parse-execute for commands from stdin.
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
     * Read and parse commands from stdin, and execute the appropriate operations against the
     * specified data structure. Keeps reading in a loop until terminated.
     */
    public void parseAndExec() {
        String cmdLine;
        final String prompt = """
                \nEnter request consisting of:  OPERATION [VALUE [DATACLASS]]
                    OPERATION := CANNED | GET
                    GET is followed by: keyValue data-class-to-use""";
        String[] fields;

        System.out.println(prompt);
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader breader = new BufferedReader(isr)) {
            while ((cmdLine = breader.readLine()) != null) {
                fields = cmdLine.split(" ", 2); // get operation, and the rest
                String operator = fields[0].toUpperCase();
                Storeable dataClass;

                switch (operator) {
                    case "CANNED" -> doCannedOperations();
                    case "GET" -> {
                        // Expecting value of key/ID, and class to use for GET operation
                        fields = fields[1].split(" ");
                        if ((fields.length != 2) || (dataClass = getStoreable(fields[1])) == null) {
                            System.out.printf("Invalid parameters for command %s %n", operator);
                            continue;
                        }
                        Find.searchItems(dataClass, (fields[0]));
                    }
                    default -> System.out.println("Unknown Operation: " + fields[0]);
                }

                System.out.println(prompt);
            }

        } catch (Exception ex) {
            System.out.printf("Exception %s inside of command line processor\n", ex.getLocalizedMessage());
        }
    }

    /**
     * Find a class whose name contains the requested storename (partial match)
     *
     * @param storename - part or all of the name of a Storeable class to find
     * @return A Storeable class if match is found, else null
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

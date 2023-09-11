package ds264.bigdata;

import ds264.bigdata.load.LoadData;
import ds264.bigdata.operations.Operations;
import ds264.bigdata.storage.StoreInArray;
import ds264.bigdata.storage.StoreInHashM;

import java.util.ArrayList;
import java.util.List;

/**
 * Application that loads a large data file into one or more data structures and
 * reports the timing of various operations that can be done on the data.
 * Uses an abstraction called Storeable to represent all data structures being tested.
 * <p>
 * DataSource: <a href="https://data.cityofnewyork.us/City-Government/311-Call-Center-Inquiry/wewp-mm3p">...</a>
 * Typical command line:
 *   java -cp out/production/ds264inclass ds264.ds264.bigdata.BigdataApp   /Users/mcohen/Downloads/311_Calls_10M.csv  10000000
 * Or, if running from IDE and the data file is in your 'java working directory', specify the
 * following in the Run Configuration as arguments/parameters for application:
 *   311_Calls_10M.csv  10000000
 */
public class BigdataApp {
    private static Integer inMaxRows = Integer.MAX_VALUE;   // max rows to input, default to 2**32
    private static String inFileName;   // input file name
    public static String[] firstLastIDs = new String[2];   // keep track of lowest, highest keys
    public static List<Storeable> storeables = new ArrayList<>();   // list of data structure implementations


    /**
     * @param args filename [maxrows]
     */
    public static void main(String[] args) {

        BigdataApp app = new BigdataApp();  // instantiate ourselves

        app.parseArgs(args);                // parse arguments, set variables
        app.init(inFileName);               // initialize and load data structures

        Operations ops = new Operations();
        ops.doCannedOperations();           // do stuff with the data
        ops.parseAndExec();
    }

    /**
     * Parse arguments and set necessary properties
     *
     * @param args filename [maxrows]
     */
    private void parseArgs(String[] args) {
        if (args.length < 1) {
            System.err.println("Invalid num args: " + args.length);
            System.exit(4);
        }
        inFileName = args[0];

        if (args.length >= 2)
            inMaxRows = Integer.valueOf(args[1]);
    }

    /**
     * Initialize and load data structures with data
     *
     * @param inFileName Name of data file to get data from
     */
    private void init(String inFileName) {

        // Instantiate list of Storeable classes we wish to populate, and put in a list
        storeables.add(new StoreInArray(inMaxRows));
        storeables.add(new StoreInHashM(inMaxRows));

        // pass list of Storeable classes to Loader, will load all data into all classes
        LoadData loader = new LoadData(storeables);
        loader.load(inFileName, inMaxRows, firstLastIDs);
    }


}
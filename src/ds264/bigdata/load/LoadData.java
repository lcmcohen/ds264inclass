package ds264.bigdata.load;

import ds264.bigdata.Storeable;

import java.io.*;
import java.util.Arrays;
import java.util.List;


/**
 * Load data from a file (with NYC 311 Call Center data) into 1 or more data structures
 */
public class LoadData {
    /**
     * The 311 Call Center Inquiry file has 9 fields, we are just interested in the unique ID and
     * two other data fields that we concatenate
     */
    public static final int FLD_ID = 0;
    public static final int FLD_AGENCY = 4;
    public static final int FLD_DESC = 7;

    /**
     * List of objects of various data structures that we will load data into
     */
    List<Storeable> storeables;

    /**
     * Constructor
     *
     * @param storeables List of objects of various data structures that we will load data into
     */
    public LoadData(List<Storeable> storeables) {
        this.storeables = storeables;
    }

    /**
     * Load data from specified file
     *
     * @param inFileName   Name of input file to read from
     * @param maxRows      max num of rows to read in (file may have more or less). Not including header row
     * @param firstLastIDs
     */
    public void load(String inFileName, int maxRows, String[] firstLastIDs) {
        int rowNum = 0;
        String[] fields = null;
        long _startTimeMS = System.currentTimeMillis();

        System.out.println("LOAD: starting...");

        try (BufferedReader br = new BufferedReader(new FileReader(inFileName))) {
            String currLine;
            while ((currLine = br.readLine()) != null) {
                fields = currLine.split(",");

                if (rowNum == 0) {
                    // 1st row is a header, make sure valid
                    if (!fields[FLD_ID].equals("UNIQUE_ID")) {
                        System.out.println("Invalid Header Row: " + Arrays.toString(fields));
                        throw new InvalidObjectException("Invalid Header Row: " + Arrays.toString(fields));
                    }
                } else {
                    // for each data structurestoreables = {ArrayList@703}  size = 2 class, pass current row to it
                    for (Storeable storeable : storeables) {
                        storeable.addRow(fields[FLD_ID], fields[FLD_AGENCY] + ":" + fields[FLD_DESC]);

                        if (rowNum == 1)
                            firstLastIDs[0] = fields[FLD_ID];   // keep track of first ID
                    }
                }

                if (rowNum++ >= maxRows)
                    break;

                if ((rowNum % 10000) == 0)
                    System.out.println("LOAD: Progress. Rows: " + rowNum);
            }
        } catch (FileNotFoundException e) {
            System.out.println("LOAD: Could not find/open file: " + inFileName);
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (rowNum > 0)
            firstLastIDs[1] = fields[FLD_ID];   // keep track of last ID
        long _endTimeMS = System.currentTimeMillis();

        System.out.println("LOAD: Completed. Rows: " + (rowNum - 1));
        System.out.println("LOAD: first ID is " + firstLastIDs[0]);
        System.out.println("LOAD: last  ID is " + firstLastIDs[1]);
        System.out.println("LOAD: elapsed time_ms: " + (_endTimeMS - _startTimeMS));
        System.out.println();
    }
}

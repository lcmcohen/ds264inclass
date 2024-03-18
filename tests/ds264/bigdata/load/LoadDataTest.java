package ds264.bigdata.load;

import org.junit.jupiter.api.Test;

import java.io.CharArrayReader;
import java.io.Reader;
import static org.junit.jupiter.api.Assertions.*;

class LoadDataTest {
   Reader fr;
    @Test
    void loadFromArrayNormal() {
        String hdrRow = "UNIQUE_ID,DATE,TIME,DATE_TIME,AGENCY,AGENCY_NAME,INQUIRY_NAME,BRIEF_DESCRIPTION,CALL_RESOLUTION";

        fr = new CharArrayReader(hdrRow.toCharArray());

        LoadData ld = new LoadData(null);
        ld.load(fr, 1, new String[2]);
    }

    @Test
    void loadFromArrayBadField() {
        String hdrRow = "UNIQUE_XX,DATE,TIME,DATE_TIME,AGENCY,AGENCY_NAME,INQUIRY_NAME,BRIEF_DESCRIPTION,CALL_RESOLUTION";

        fr = new CharArrayReader(hdrRow.toCharArray());

        LoadData ld = new LoadData(null);
        ld.load(fr, 1, new String[2]);
    }
}
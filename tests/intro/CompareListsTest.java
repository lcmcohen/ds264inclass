package intro;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareListsTest {
    /**
     * First doe with both AL
     * Then switch 2nd to LL
     * Then also switch 1st to LL
     */
    @Test
    void compareLists() {

        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();

        l1.add("LCM");
        l2.add("YU");

        assertEquals(l1, l2);


    }
}

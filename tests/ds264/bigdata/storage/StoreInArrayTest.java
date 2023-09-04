package ds264.bigdata.storage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StoreInArrayTest {

    @Test
    void addRow() {
    }

    @Test
    void getNumRows_empty() {
        StoreInArray sia = new StoreInArray(3);
        assertEquals(0, sia.getNumRows(), "Didnt get 0 for getNumRows on new/empty object");
    }

    @Test
    void getDescByID() {
    }
}
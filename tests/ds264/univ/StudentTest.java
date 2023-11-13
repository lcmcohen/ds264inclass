package ds264.univ;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    /**
     * set up a student to be used in all tests
     */
    final Student mainStudent = new Student("Baruch", 20, 11101);
    @Test
    void studentsEqual() {

        assertEquals(mainStudent, mainStudent, "I expect mainStudent to be equal to itself");

        Student testStudent = new Student("Baruch", 20, 11101);

        // how can we make sure two objects representing same students are treated as equal
        assertEquals(mainStudent, testStudent, "I expect mainStudent to be equal to another object repres same student");
    }
}
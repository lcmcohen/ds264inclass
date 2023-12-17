package ds264.univ;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentRegistrationTest {

    StudentRegistration reg;

    /**
     * Each test will be atomic, all tests idempotent
     */
    @BeforeEach
    void setUp() {
        reg = new StudentRegistration();
    }

    @Test
    void enrollStudent() {
        // arrange
        String newStudent = "Moshe";
        int howMany = reg.howManyStudentsLeft();

        // act
        reg.enrollStudent(newStudent);

        //assert - that our size increased
        assertEquals(howMany + 1, reg.howManyStudentsLeft());

        // assert what we added is highest pr since there should only be one
        assertEquals(newStudent, reg.getNextHighestPriStudent());
    }

    @Test
    void getNextHighestPriStudent() {

        String firstStudent = "EarlyBird, GetsTheWorm";
        reg.enrollStudent(firstStudent);
        reg.enrollStudent("Middle, Manny");
        reg.enrollStudent("Alas, AlwaysLast");

        // assert - the first student to register has the highest priority
        assertEquals(firstStudent, reg.getNextHighestPriStudent());
    }
}
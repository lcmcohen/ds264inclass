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
        String newStudent = "Jones, Moshe";
        int howMany = reg.howManyStudentsLeft();

        // act
        reg.enrollStudent(newStudent);

        //assert - that our size increased
        assertEquals(howMany + 1, reg.howManyStudentsLeft());

        // assert what we added is highest pr since there should only be one
        assertEquals(newStudent, reg.getNextHighestPriStudent());
    }

    /**
     * TODO will have to decide what is real priority for student registration
     */
    @Test
    void getNextHighestPriStudent() {

        String expectedNextToRegister;
        reg.enrollStudent((expectedNextToRegister = "EarlyBird, GetsTheWorm"));
        reg.enrollStudent("Middle, Manny");
        reg.enrollStudent("Alas, AlwaysLast");

        // assert - the first student to register has the highest priority
        assertEquals(expectedNextToRegister, reg.getNextHighestPriStudent());
    }
}
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
        LanderStudent newStudent = new LanderStudent("Jones, Moshe", 1960);
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

        LanderStudent expectedNextToRegister;

        reg.enrollStudent(expectedNextToRegister = new LanderStudent("EarlyBird, GetsTheWorm", 2005));
        reg.enrollStudent(new LanderStudent("Middle, Manny", 2004));
        reg.enrollStudent(new LanderStudent("Alas, AlwaysLast", 2000)); // would be Expected

        // assert - the first student to register has the highest priority
        assertEquals(expectedNextToRegister, reg.getNextHighestPriStudent());  //TODO would have to adjust what is our priority
    }
}
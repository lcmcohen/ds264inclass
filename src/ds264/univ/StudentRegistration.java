package ds264.univ;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Manage the student registration process, by allowing students to enroll
 * in the school, and then letting a student register for limited courses
 * based on their 'priority'.
 * TODO priority definition is TBD. Currently in order of registration
 */
public class StudentRegistration {
    Queue<LanderStudent> studentRegQueue;

    StudentRegistration(Queue<LanderStudent> studentQueue) {
        studentRegQueue = studentQueue;
    }


    /**
     * Enroll a new student in school by adding them to some collection.
     *
     * @param student a student to enroll
     */
    void enrollStudent(LanderStudent student) {
        // add the student to the registration queue
        studentRegQueue.offer(student);
    }

    /**
     * Get next highest priority student in line for registration for limited courses, and
     * remove from collection.
     *
     * @return The next student to have choice of limited courses.
     */
    LanderStudent getNextHighestPriStudent() {
        return studentRegQueue.poll();
    }

    int howManyStudentsLeft() {
        return studentRegQueue.size();
    }

}

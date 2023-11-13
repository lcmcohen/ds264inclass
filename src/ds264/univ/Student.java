package ds264.univ;


/**
 * Represent a student in the university
 */
public class Student extends Person {
    Integer StudentID;

    public Student(String sname, int age, int id) {
        super(sname, age);
        this.StudentID = id;
    }

}

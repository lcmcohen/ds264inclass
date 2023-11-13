package ds264.univ;

/**
 * abstraction of all people
 */
public abstract class Person {
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

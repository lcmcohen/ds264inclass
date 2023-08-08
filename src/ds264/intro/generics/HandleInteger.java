package ds264.intro.generics;

/**
 * Class to handle all of our Integers
 */
public class HandleInteger {
    Integer theValueToHandle;

    public HandleInteger(Integer val) {
        theValueToHandle = val;
    }

    public void print() {
        System.out.println(this.getClass().getSimpleName() + ":: Value of " + theValueToHandle.getClass().getSimpleName() + " is: " + theValueToHandle);
    }
}

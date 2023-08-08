package ds264.intro.generics;

/**
 * Class to handle all of our Strings
 */
public class HandleString {
    String theValueToHandle;

    public HandleString(String val) {
        theValueToHandle = val;
    }

    public void print() {
        System.out.println(this.getClass().getSimpleName() + ":: Value of " + theValueToHandle.getClass().getSimpleName() + " is: " + theValueToHandle);
    }
}

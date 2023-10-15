package ds264.intro.generics;

import java.util.Arrays;

/**
 * Class to handle all of our values in a generic fashion
 * The class def accepts formal type parameter T
 */
public class HandleVals<T> {
    T theValueToHandle;

    /**
     * Constructor that accepts a value that must conform to the formal type in
     * the "generic type invocation" - where the variable of this class type is declared.
     * @param val
     */
    public HandleVals(T val) {
        theValueToHandle = val;
    }

    public void print() {

        System.out.print(this.getClass().getSimpleName() + ":: Value of " + theValueToHandle.getClass().getSimpleName() + " is: ");
        System.out.println(theValueToHandle.getClass().isArray() ? Arrays.toString((Object[]) theValueToHandle) : theValueToHandle);
    }

}

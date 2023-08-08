package ds264.intro.generics;

import java.util.Arrays;

/**
 * Class to handle all of our values in a generic fashion
 */
public class HandleVals<T> {
    T theValueToHandle;

    public HandleVals(T val) {
        theValueToHandle = val;
    }

    public void print() {

        System.out.print(this.getClass().getSimpleName() + ":: Value of " + theValueToHandle.getClass().getSimpleName() + " is: ");
        System.out.println(theValueToHandle.getClass().isArray() ? Arrays.toString((Object[]) theValueToHandle) : theValueToHandle);
    }

}

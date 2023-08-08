package ds264.intro.generics;

public class PrintVal <T> {
    T theThingToPrint;
    public PrintVal(T val) {
        theThingToPrint = val;
    }

    public void print() {
        System.out.println(this.getClass().getSimpleName() + ":: Value of " + theThingToPrint.getClass().getSimpleName() + " is: " + theThingToPrint);
    }
}

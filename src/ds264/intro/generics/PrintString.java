package ds264.intro.generics;

public class PrintString {
    String theThingToPrint;
    public PrintString(String val) {
        theThingToPrint = val;
    }

    public void print() {
        System.out.println(this.getClass().getSimpleName() + ":: Value of " + theThingToPrint.getClass().getSimpleName() + " is: " + theThingToPrint);
    }
}

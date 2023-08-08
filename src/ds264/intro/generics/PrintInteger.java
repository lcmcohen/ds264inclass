package ds264.intro.generics;

public class PrintInteger {
    Integer theThingToPrint;
    public PrintInteger(Integer val) {
        theThingToPrint = val;
    }

    public void print() {
        System.out.println(this.getClass().getSimpleName() + ":: Value of " + theThingToPrint.getClass().getSimpleName() + " is: " + theThingToPrint);
    }
}

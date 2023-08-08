package ds264.intro.generics;

import java.util.ArrayList;

/**
 * Demonstrate value of Generics.
 * Assumption: we want some degree of type-checking across application for all variables we declare
 * PreReq: Understand compile-time versus runtime checking
 */
public class Printing {
    public static void main(String[] args) {


        //Step one: declaring many specialized classes versus one Generic class (that still enforces type)


        // Let's do stuff like printing with a class that handles Integers
        HandleInteger integerHandler = new HandleInteger(5);
        integerHandler.print();


        // Let's do stuff like printing with a class that handles Strings
        HandleString stringHandler = new HandleString("Cohen");
        stringHandler.print();


        // How about Boolean Floats and other java wrapper types?, how about Arrays, ...
        // Will we make a class for each one ???

        // Use one Generic class that enforces expected type (at compile time)
        HandleVals<Integer> iHandler = new HandleVals<>(10);
        iHandler.print();

        HandleVals<String> sHandler = new HandleVals<>("Prof Cohen");
        sHandler.print();

        HandleVals<Double[]> arrayHandler = new HandleVals<>(new Double[]{98.6, 22.0 / 7.0});
        arrayHandler.print();

// Step 2: Generic for Collections - Better than allowing a collection to be 'general'


        ArrayList myValues = new ArrayList();
        myValues.add(1);
        myValues.add(2.0);  // I meant to put an integer
        System.out.println("Check myValues for consistency: " + myValues);

        // Hmmm, suppose some other code that consumes that array assumes it contains only Integers
        //// Won't allow this, so instead ...
        /////Integer getSomeValue = myValues.get(0);

        ///// ... do this
        Integer getSomeValue = (Integer) myValues.get(0);    // That will  work OK
        System.out.println("getSomeValue #1 == " + getSomeValue);

        getSomeValue = (Integer) myValues.get(1);    //   that compiles fine but will crash
        System.out.println("getSomeValue #2 == " + getSomeValue);

        /// to correct runtime crash:    ArrayList myValues<Integer> = new ArrayList();

    }


}

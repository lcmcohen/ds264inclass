package ds264.intro.generics;

import java.util.ArrayList;

/**
 * Demonstrate value of Generics
 */
public class Printing {
    public static void main(String []args) {

        PrintInteger integerPrinter = new PrintInteger(6);
        integerPrinter.print();




        PrintString stringPrinter = new PrintString("Cohen");
        stringPrinter.print();






        PrintVal <Integer> iPrinter = new PrintVal<>(8);
        iPrinter.print();

        PrintVal <String> sPrinter = new PrintVal<>("Prof Cohen");
        sPrinter.print();


        // Generic - Better than allowing a collection to be 'general'

        ArrayList myValues = new ArrayList();
        myValues.add(1);
        myValues.add(2.0);  // I meant to put an integer
        System.out.println("Check myValues: " + myValues);

        //// wont allow this, so instead ...
       /////Integer getSomeValue = myValues.get(0);

        ///// ... do this
        Integer getSomeValue = (Integer) myValues.get(0);    // That will  work OK
        System.out.println("getSomeValue #1 == " + getSomeValue);

        getSomeValue = (Integer) myValues.get(1);    //   that compiles fine but will crash
        System.out.println("getSomeValue #2 == " + getSomeValue);

                /// to correct runtime crash:    ArrayList myValues<Integer> = new ArrayList();

    }


}

package ds264.intro;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class contains various sample usages of simple data structures for Intro lecture
 */
public class IntroSamples {
    public static void main(String[] args) {
        System.out.println("Welcome to Data Structures");

        // let's play with arrays - my PPT 1st example
        try {
            arrayPlay_1();
        }
        catch (Exception ex)
        {
            System.out.println("Problem with arrayPlay_1 - " + ex);
        }



        // let's play with arrays
        try {
            arrayPlay_2();
        }
        catch (Exception ex)
        {
            System.out.println("Problem with arrayPlay_2 - " + ex);
        }



        // let's play with ArrayList
        try {
            arrListPlay_1();
        }
        catch (Exception ex)
        {
            System.out.println("Problem with arrListPlay_1 - " + ex);
        }
    }

    private static void arrayPlay_1() {

        int[]  favNums = new int[] {34, 21, 2, 66, 567};

        int thirdNum = favNums[2];
        System.out.println ("Third Favorite Num is: " + thirdNum);

        favNums[2] = 9999;
        System.out.println ("Third Favorite Num is: " + thirdNum);

        favNums[300000] = 0;

    }


    /**
     * Simple playing with Java Array
     * [[also show debug, bytecode views (constant reference cost)]]
     */
    static void arrayPlay_2() {
        String[] studentNames;                  // declare variable of particular DS
        studentNames = new String[5];           // allocate space (instantiate Array object)
        studentNames[4] = "Gene Krupa";         // Fill in one slot

        System.out.println(studentNames.length);    // how "big" is it?

        System.out.println(studentNames);           // What's in there?

        System.out.println(Arrays.toString(studentNames));  // What's really in there?

        studentNames[700] = "Far Out Dude";         // Can we expand it ?

        System.out.println(studentNames.length);    // did it get bigger? Are we even here?

    }


    /**
     * Simple playing with ArrayList
     * [[also show debug, bytecode views (constant reference cost)]]
     */
    static void arrListPlay_1() {
        ArrayList studentNames;                  // declare variable of particular DS
        studentNames = new ArrayList();           // allocate space (instantiate ArrayList object)
        studentNames.add("Gene Krupa");         // Fill in one slot

        System.out.println(studentNames.size());    // how "big" is it?

        System.out.println(studentNames);           // What's in there?

        studentNames.add("Buddy Rich");         // Can we expand it ?

        System.out.println(studentNames.size());    // did it get bigger?
        System.out.println(studentNames);           // What's in there?

        studentNames.add(0, "Vic Moore"); // Can we expand it in the beginning?

        studentNames.add(2, "Alfred Hall"); // Can we expand it in the middle?

        System.out.println(studentNames);           // What's in there?

        studentNames.add(700, "Far Out Dude");         // Can we expand it way out?

        System.out.println(studentNames.size());    // did it get bigger?

    }
}
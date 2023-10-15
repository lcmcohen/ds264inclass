package ds264.intro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntroIterator {

    public static void main(String[] args) {
        System.out.println("Welcome to Data Structures");

        // let's play with list iterator
        try {
            listIter();
        } catch (Exception ex) {
            System.out.println("Problem with listIter - " + ex);
        }
        System.exit(0);
    }

    static void listIter() {

        List studentNames;                  // declare variable of particular DS
        studentNames = new ArrayList();           // allocate space (instantiate ArrayList object)
        studentNames.add("Gene Krupa");
        studentNames.add("Buddy Rich");
        studentNames.add("Steve Gadd");

        System.out.println(studentNames);           // What's in there?

        for (int ix = 0; ix < studentNames.size(); ix++ )
        {
            System.out.println("FOR got " + studentNames.get(ix)  + "   at index: " + ix );

            /*** remove one - by INDEX
            if (studentNames.get(ix).equals("Buddy Rich"))
                studentNames.remove(ix);
             /**/
        }


        for (Object student: studentNames) {
            System.out.println("FOREACH got " + student);
            /*** remove one - by VALUE
            if (student.equals("Buddy Rich"))
                studentNames.remove(student);
             /**/

           // if (student.equals("Buddy Rich"))
             //   studentNames.remove(0);
        }

        Iterator sIter = studentNames.iterator();

        while (sIter.hasNext()) {
            System.out.println("Da next one is: " + sIter.next());
        }

        // RE-ITERATE
        sIter = studentNames.iterator();

        while (sIter.hasNext()) {
            //System.out.println("Da next one is: " + sIter.next());
            String student = (String) sIter.next();
            System.out.println("RE-ITER - Da next one is: " + student);
            /*** remove CURRENT one - based on  VALUE retrieved */
             if (student.equals("Buddy Rich"))         // also do remove of 0, Gene
                studentNames.remove(student);     // also do remove of 0, Gene
             /**/
        }

        System.out.println(studentNames);



    }

}

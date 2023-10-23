package ds264.intro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

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
             //   studentNames.remove(0);  // gotta know which
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
             if (student.equals("Gene Krupa"))         // also demo prob with 0, Gene
                // BAD studentNames.remove(0);  /*prob*/   // also demo prob with 0, Gene
                 sIter.remove();
             /**/
        }

        System.out.println(studentNames);



        Lander data = new Lander("abcdefg");

         for (Object s: data) {
             System.out.println("Lander iterator = next is: " + s);

         }


    }

    private static class Lander implements Iterable {
        String internalData;
        int cursor = 0;
        public Lander(String str) {
            this.internalData = str;
        }


        @Override
        public Iterator iterator() {
            return new Iterator() {
                @Override
                public boolean hasNext() {
                    return cursor < internalData.length();
                }

                @Override
                public Object next() {
                    System.out.println("iterator " + this.getClass() + " was called when cursor = " + cursor);
                    return internalData.toCharArray()[cursor++];
                }

                @Override
                public void remove() {
                    Iterator.super.remove();
                }

                @Override
                public void forEachRemaining(Consumer action) {
                    Iterator.super.forEachRemaining(action);
                }
            };


        }
    }
}

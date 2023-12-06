package ds264.intro.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class CafeteriaDeque {
    Deque<Tray> trays;

    public static void  main (String[] args) {

        CafeteriaDeque cafeteria = new CafeteriaDeque();

        cafeteria.setupTrays();

    }

    private  void setupTrays() {

        trays = new ArrayDeque<>();

        trays.add(new Tray("bottom", true));
        trays.add(new Tray("middle", false));
        trays.add(new Tray("top", false));

      //  Tray tray = trays.get(0);

        System.out.println(this.toString());

     //   System.out.println(tray);

       // String top = trays.pop();


    }

    @Override
    public String toString() {
        String str = "Here is the stack of Cafeteria trays" + "\n";

        /*** iteration will give undsired order
        for (Tray tray : trays) {
            str += tray.toString();
        }
        ***/

      //  for (int ix = trays.size() -1 ; ix >= 0; ix--)
     //       str += trays.get(ix);

        return str;
    }


}

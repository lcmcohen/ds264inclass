package ds264.intro.stacks;

import java.util.Random;
import java.util.Stack;

public class Cafeteria {
    Stack <Tray>trays;

    public static void  main (String[] args) {

        Cafeteria cafeteria = new Cafeteria();

        cafeteria.setupTrays();

        Tray t = cafeteria.takeTray();
        System.out.println("took this tray: \n" + t);

    }

    private  void setupTrays() {

        trays = new Stack();

        trays.add(new Tray("bottom", true));   // ooh lets me do an add, versus a push
        trays.add(new Tray("middle", false));
        trays.add(new Tray("top", false));

        Tray tray = trays.get(0);

        System.out.println("after setup trays:\n" + this.toString());

        // peek ?

    }


    /**
     * Take a tray from the stack of trays
     *
     * @return tray
     */
    Tray takeTray() {
        Tray tray = trays.pop();
        System.out.println("after take (pop) a  tray:\n" + this.toString());
        return tray;
    }



    @Override
    public String toString() {
        String str = "Here is the stack of Cafeteria trays" + "\n";

        /*** iteration will give undesired order
        for (Tray tray : trays) {
            str += tray.toString();
        }
        ***/

        for (int ix = trays.size() -1 ; ix >= 0; ix--)
            str += trays.get(ix);

        return str + "\n";
    }


}

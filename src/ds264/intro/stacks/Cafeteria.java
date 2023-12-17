package ds264.intro.stacks;

import java.util.Stack;

public class Cafeteria {
    static Stack <Tray>trays;

    public static void  main (String[] args) {

        Cafeteria cafeteria = new Cafeteria();

        cafeteria.setupTrays();

        Tray t = cafeteria.takeTray();
        System.out.println("took this tray: \n" + t);

        // What does next tray look like? should I go eat elsewhere?
        if (trays.peek().isDirty) {
            System.out.println("next tray is dirty: " + trays.peek().name);
        } else
            System.out.println("next tray is not dirty: " + trays.peek().name);

        t = cafeteria.takeTray();
        System.out.println("took this tray: \n" + t);

        // What does next tray look like? should I go eat elsewhere?
        if (trays.peek().isDirty) {
            System.out.println("next tray is dirty: " + trays.peek().name);
        } else
            System.out.println("next tray is not dirty: " + trays.peek().name);

    }

    private  void setupTrays() {

        trays = new Stack<>();

        trays.add(new Tray("BOTTOM TRAY", true));   // ooh! lets me do an add, versus a push
        trays.add(new Tray("MIDDLE TRAY", false));
        trays.add(new Tray("TOP TRAY", false));

        Tray tray = trays.get(0);  // ooh! lets me do this

        System.out.println("after setup trays:\n" + this);
    }


    /**
     * Take a tray from the stack of trays
     *
     * @return tray
     */
    Tray takeTray() {
        Tray tray = trays.pop();
        System.out.println("after take (pop) a  tray:\n" + this);
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

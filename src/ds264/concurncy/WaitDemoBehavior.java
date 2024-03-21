package ds264.concurncy;

/**
 * Demo how wait() behaves with no sync, or with no corresponding notifier
 */
public class WaitDemoBehavior {
    static public void main(String[] argc) throws InterruptedException {

        WaitDemoBehavior prog = new WaitDemoBehavior();

        System.out.println(("starting stuff"));
        prog.stuff();

        System.out.println("back from stuff");
    }

    private void stuff() throws InterruptedException {
        System.out.println(
                Thread.currentThread().getId() + " " + Thread.currentThread().getName());

       /**  synchronized (this) **/ {
            this.wait(4000);
        }
    }


}

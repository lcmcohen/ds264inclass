package ds264.synch;

public class JunkProgram {
    public static void main(String[] args) {
        JunkProgram prog = new JunkProgram();
        prog.doStuff();
    }
    private void doStuff() {

        Thread curThread = Thread.currentThread();
        System.out.println(curThread.getName() + " " + curThread.getPriority() + " " + curThread.threadId());

        Thread otherThread = new Thread( new JunkThread(this));
        otherThread.start();

        synchronized (this) {
            try {
                System.out.println("start to wait");
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("Exc in wait");
                throw new RuntimeException(e);
            } catch (Exception exc) {
                System.out.println("Exc in wait " + exc.getLocalizedMessage());
                throw new RuntimeException(exc);
            }
        }
        System.out.println("back from wait");
    }
}

package ds264.synch;

public class JunkThread implements Runnable{
    Object lock;
    JunkThread(Object lock) {
        this.lock = lock;
        Thread curThread = Thread.currentThread();
        System.out.println(curThread.getName() + " " + curThread.getPriority() + " " + curThread.getId());
    }


    @Override
    public void run() {
        Thread curThread = Thread.currentThread();
        System.out.println(curThread.getName() + " " + curThread.getPriority() + " " + curThread.getId());

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (lock)  {
            lock.notify();
        }
    }
}

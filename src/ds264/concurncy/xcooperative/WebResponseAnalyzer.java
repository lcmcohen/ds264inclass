package ds264.concurncy.xcooperative;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Formerly Waiter class - analyze/save web data when it becomes available
 */
class WebResponseAnalyzer implements Runnable {

    final public Content content;
    BufferedWriter writer;

    public WebResponseAnalyzer(Content content) {
        this.content = content;

    }

    /**
     * Constantly analyze and write out data from pages whenever it is available
     */
    public void run() {
        try {
            writer = new BufferedWriter(new FileWriter("output.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            synchronized (content) {
                System.out.println("WebResponseAnalyzer is now waiting on the lock");
                while (content.contents == null) {
                    try {
                        content.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("WebResponseAnalyzer just got notified!, counter = " + content.counter);
                System.out.println(content.contents);

                try {
                    writer.write(content.contents);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    Thread.sleep(2 * 1000);  // so we dont hammer the website
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (content) {
                    content.contents = null;
                    content.notify();
                }
            }
        }
    }
}

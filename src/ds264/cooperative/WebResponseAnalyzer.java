package ds264.cooperative;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Formerly Waiter class - analyze/save web data when it becomes available
 */
class WebResponseAnalyzer implements Runnable {

    final public Content content;
    BufferedWriter writer;

    public WebResponseAnalyzer(Content content)  {
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
                try {
                    System.out.println("WebResponseAnalyzer is now waiting on the lock");
                    content.wait();
                    System.out.println("WebResponseAnalyzer just got notified!");
                    System.out.println(content.contents);
                    writer.write(content.contents);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
package ds264.concurncy.producerConsumer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

/**
 * Formerly Waiter class - analyze/save web data when it becomes available. This is a Consumer.
 */
class WebResponseAnalyzer implements Runnable {
    BufferedWriter writer;
    BlockingQueue<Content> contentBlockingQueue;

    /**
     * Construct a WebResponseAnalyzer, should be safe & possibly useful to construct several, as needed.
     *
     * @param queue A queue that will be shared by all producers and consumers for all content
     */
    public WebResponseAnalyzer(BlockingQueue<Content> queue) {
        this.contentBlockingQueue = queue;
    }

    /**
     * Constantly analyze and write out data from pages whenever it is available
     */
    public void run() {
        Content content;
        try {
            writer = new BufferedWriter(new FileWriter("output.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                System.out.println("WebResponseAnalyzer is now waiting for content from queue");
                content = contentBlockingQueue.take();
                System.out.println("WebResponseAnalyzer just got content from queue, counter = " + content.counter);
                System.out.println(content.contents);
                writer.write(content.contents);
                Thread.sleep(3 * 1000);  //
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
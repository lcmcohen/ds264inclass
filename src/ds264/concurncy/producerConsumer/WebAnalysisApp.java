package ds264.concurncy.producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Application that concurrently reads data from web, writing it out to a file.
 */
public class WebAnalysisApp {
    /**
     * Queue for producers and consumers to share
     */
    static BlockingQueue<Content> contentBlockingQueue;
    public static void main(String[] args) {

        // Create an unlimited thread-safe blocking queue for all producers and consumers to share.
        contentBlockingQueue = new LinkedBlockingQueue<>();

        Thread consumer_1 = new Thread(new WebResponseAnalyzer(contentBlockingQueue));
        consumer_1.start();

        Thread consumer_2 = new Thread(new WebResponseAnalyzer(contentBlockingQueue));
        consumer_2.start();

        Thread producer_1 = new Thread(new WebReader(contentBlockingQueue));
        producer_1.start();
    }
}
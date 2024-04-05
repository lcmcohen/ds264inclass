package ds264.concurncy.producerConsumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Formerly the Notifier class, reads from Web, notifies when done. This is a Producer
 */
class WebReader implements Runnable {
    BlockingQueue<Content> contentBlockingQueue;
    AtomicInteger reqCounter = new AtomicInteger(1);  // for marking each content object with uniq #

    /**
     * Construct a WebReader, should be safe & possibly useful to construct several, as needed.
     * @param queue A queue that will be shared by all producers and consumers for all content
     */
    public WebReader(BlockingQueue<Content> queue) {
        this.contentBlockingQueue = queue;
    }

    /**
     * constantly read from web and notify anyone who is interested
     */
    public void run() {
        Content content;
        while (true) {
            try {
                Thread.sleep(2 * 1000);  // so we dont hammer the website
                content = new Content();
                content.contents = readWeb();
                content.counter = reqCounter.getAndIncrement();
                System.out.println("Producer: We have Read # " + content.counter + " -->About to enqueue content...");
                contentBlockingQueue.put(content);
                System.out.println("Producer: Done notifying the waiter.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * Do one read from one URL
     *
     * @return string with HTML content from URL
     */
    private String readWeb() {
        StringBuilder htmlContent = new StringBuilder();
        String line;
        try {
            // Create a URL object
            URL url = new URL("https://blog.airbrake.io/blog/http-errors/301-moved-permanently");
            // Open a connection to the URL
            URLConnection connection = url.openConnection();
            // Set user-agent (optional)
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            // Create a BufferedReader to read the HTML content
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // Read the HTML content line by line
            while ((line = reader.readLine()) != null) {
                htmlContent.append(line);
            }
            // Close the BufferedReader
            reader.close();

            // DBUG System.out.println(htmlContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return htmlContent.toString();
    }
}
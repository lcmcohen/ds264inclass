package ds264.concurncy.xcooperative;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Formerly the Notifier class, reads from Web, notifies when done.
 */
class WebReader implements Runnable {

    public Content content;

    public WebReader(Content content) {
        this.content = content;
    }

    /**
     * constantly read from web and notify anyone who is interested
     */
    public void run() {
        while (true) {
            synchronized (content) {
                while (content.contents != null) {
                    System.out.println("WebReader: wait for empty buffer...");
                    try {
                        content.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("WebReader: back from wait buffer");
                }
                System.out.println("WebReader: buffer now empty");
            }

            content.contents = readWeb();

            try {
                Thread.sleep(2 * 1000);  // so we dont hammer the website
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            content.counter++;

            synchronized (content) {
                System.out.println("We have Read # " + content.counter + " -->About to notify the waiter...");
                content.notify();
                System.out.println("WebReader: Done notifying the waiter.");
            }
        }
    }


    /**
     * Do one read from one URL
     *
     * @return
     */
    private String readWeb() {
        StringBuilder htmlContent = new StringBuilder();
        String line;
        try {
            // Create a URL object
            URL url = new URL(content.url);
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
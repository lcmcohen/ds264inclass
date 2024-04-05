package ds264.concurncy.xcooperative;

/**
 * Application that concurrently reads data from web, writing it out to a file.
 */
public class WebAnalysisApp {

    public static void main(String[] args) {
        String urlString = "https://blog.airbrake.io/blog/http-errors/301-moved-permanently";
        Content content = new Content();
        content.counter = 0;
        content.url = urlString;

        Thread waiter = new Thread(new WebResponseAnalyzer(content));
        waiter.start();
        Thread notifier = new Thread(new WebReader(content));
        notifier.start();
    }

}
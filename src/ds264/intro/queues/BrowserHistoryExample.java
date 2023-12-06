package ds264.intro.queues;

public class BrowserHistoryExample {
    public static void main(String[] args) {
        BrowserHistoryManager historyManager = new BrowserHistoryManager(5);

        // Simulate visiting pages
        historyManager.visitPage("Page 1");
        historyManager.visitPage("Page 2");
        historyManager.visitPage("Page 3");
        historyManager.visitPage("Page 4");
        historyManager.visitPage("Page 5");

        // Simulate going back and forth in history

        String backPage = historyManager.goBack();

        historyManager.visitPage("Page 6");
        historyManager.visitPage("Page 7");

        // Print the final history
        historyManager.printHistory("At end of program");
    }
}
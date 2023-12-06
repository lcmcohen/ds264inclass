package ds264.intro.queues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Manage history of Browser pages, keeping only certain number of page links around,
 * and allowing to go back in history. A separate Forward Queue may be needed.
 */
class BrowserHistoryManager {
    private final Deque<String> browserHistory = new ArrayDeque<>();
    private final int maxHistorySize;     // how much history to keep

    /** Construct a history manager for a Browser Window
     *
     * @param maxHistorySize how much history is to be kept
     */
    public BrowserHistoryManager(int maxHistorySize) {
        this.maxHistorySize = maxHistorySize;
    }

    /**
     * handle visiting page, keep track of, get rid of old items if necessary
     * @param page the new page just visited
     */
    public void visitPage(String page) {

        browserHistory.offerFirst(page); // Add  visited page to  front of  history

        // Check if the history size exceeds the maximum allowed
        if (browserHistory.size() > maxHistorySize) {
            // Remove the oldest pages from the end until the size is within the limit
       /***** Presence of regular List methods could be dangerous !!!!!
            Iterator<String> iterator = browserHistory.iterator();
            while (browserHistory.size() > maxHistorySize && iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
       *****/
            // --> correct code
            browserHistory.pollLast();
        }
        printHistory("after visit " + page);
    }


    /**
     * Handle press of Back Button in browser
     * @return Page to go back to, will be removed from 'back' history
     */
    public String goBack() {
        String recentPage = browserHistory.pollFirst(); // take off, maybe add to Forward queue

        // Print the most recent page visited
        System.out.println("Went back to: " + recentPage);
        return recentPage;
    }

    public void printHistory(String asofMsg) {
        System.out.println("Browser History as of '" + asofMsg + "' " + browserHistory);
    }
}



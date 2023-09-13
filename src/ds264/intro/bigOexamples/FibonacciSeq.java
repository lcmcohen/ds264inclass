package ds264.intro.bigOexamples;

/**
 * Some non-DS-intensive examples of varied Big O behavior
 */
public class FibonacciSeq {
    public static void main(String[] args) {
        long startTime, endTime;
        long result;

        final long testNum = 5;

        startTime = System.currentTimeMillis();
        result = getFibRecursive(testNum);
        endTime = System.currentTimeMillis();
        System.out.println("got next (from 1) fibonacci number for " + testNum + " via Recursive: " + result + " milliSecs= " + (endTime - startTime));
    }

    /**
     * Compute   Fibonacci  sequence (based from 1) for some number - using brute force recursive alg.
     *
     * @param nth - The nTh number to which we calculate the sequence for
     * @return fibonacci sequence number for the nth sequence
     */

    private static long getFibRecursive(long nth) {
        if ((nth == 0) || (nth == 1))
            return nth;
        else
            return getFibRecursive(nth - 1) + getFibRecursive(nth - 2);
    }


}

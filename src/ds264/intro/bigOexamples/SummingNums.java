package ds264.intro.bigOexamples;

/**
 * Some non-DS-intensive examples of varied Big O behavior
 */
public class SummingNums {
    public static void main(String[] args) {
        long startTime, endTime;
        long result;

        // MJC roughly largest w/o BigInt        final long testNum = 4_100_000_000L;
        final long testNum = 5;

        /**
         * Sum up sequence of nums via loop versus Gauss formula
         */
        startTime = System.currentTimeMillis();
        result = sumNumsLoop(testNum);
        endTime = System.currentTimeMillis();
        System.out.println("got result via loop:  " + result + " milliSecs= " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = sumNumsGauss(testNum);
        endTime = System.currentTimeMillis();
        System.out.println("got result via Gauss: " + result + " milliSecs= " + (endTime - startTime));
    }

    /**
     * Sum up all numbers from 1 to some number, using a loop
     *
     * @param extent extent of numbers to sum up
     * @return sum of numbers from 1 upto/incl extent
     */
    private static long sumNumsLoop(long extent) {
        long sum = 0;
        for (long num = 1; num <= extent; num++) {
            sum = sum + num;
        }
        return sum;
    }


    /**
     * Sum up all numbers from 1 to some number, using Gauss formula
     *
     * @param extent extent of numbers to sum up
     * @return sum of numbers from 1 upto/incl extent
     */
    private static long sumNumsGauss(long extent) {
        return extent * (extent + 1) / 2;

        // Support larger numbers - here only supported for intermediate large (multiplied) value
        // return  BigInteger.valueOf(extent).multiply(BigInteger.valueOf(extent + 1)).divide(BigInteger.valueOf(2)).longValue();
    }
}

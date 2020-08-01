package mv.workspace.snipplets.hackerrank.interview.greedy;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/greedy-florist/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 */
public class GreedyFlorist {

    public static void main(String[] args) {
        int k = 2;
        int[] c = new int[]{2, 5, 6};
        System.out.println(getMinimumCost(k, c));
    }

    private static int getMinimumCost(int k, int[] c) {
        int[] sortedPrices = Arrays.stream(c).sorted().toArray();

        int loopCount = c.length / k;
        final int originalLoopCount = loopCount;
        int lastLoopCount = c.length % k;
        int sum = 0;
        while (loopCount > 0) {
            for (int i = (originalLoopCount == 1 || loopCount > 1) ? c.length - 1 : lastLoopCount; i >= 0; i--) {
                sum += ((originalLoopCount - loopCount) + 1) * sortedPrices[i];
            }
            loopCount--;
        }
        return sum;
    }
}

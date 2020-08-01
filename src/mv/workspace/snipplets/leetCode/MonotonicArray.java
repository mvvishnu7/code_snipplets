package mv.workspace.snipplets.leetCode;

/**
 * https://leetcode.com/problems/monotonic-array/
 */
public class MonotonicArray {

    public static void main(String[] args) {
        System.out.println(new MonotonicArray().isMonotonic(new int[]{-1,-2,-2}));
    }

    public boolean isMonotonic(int[] A) {
        if (A.length < 2) {
            return true;
        }
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < A.length; i++) {
            if (isDecreasing || isIncreasing) {
                if (A[i - 1] > A[i]) {
                    isIncreasing = false;
                }

                if (A[i - 1] < A[i]) {
                    isDecreasing = false;
                }
            } else {
                return false;
            }
        }

        return isDecreasing || isIncreasing;
    }
}

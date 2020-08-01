package mv.workspace.snipplets.leetCode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) return 0;

        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            n = n ^ nums[i];
        }
        return n;
    }
}

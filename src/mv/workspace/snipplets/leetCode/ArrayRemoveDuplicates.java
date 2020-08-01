package mv.workspace.snipplets.leetCode;

import java.util.Arrays;

public class ArrayRemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 2, 2, 3};
        System.out.println(new ArrayRemoveDuplicates().removeDuplicates(arr));
        Arrays.stream(arr).forEach(e -> System.out.print(e + ","));
    }

    public int removeDuplicates(int[] nums) {
        int len = 1;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] != nums[i - 1])
                nums[len++] = nums[i];
        return len;
//        if (nums.length == 0) return 0;
//
//        int len = 1;
//        int swapPos = -1;
//        int current = Integer.MIN_VALUE;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != nums[i - 1] && swapPos > 0 &&swapPos != i) {
//                nums[swapPos] = nums[i];
//                swapPos = swapPos + 1;
//                current = nums[i];
//                len++;
//            } else if (nums[i] == nums[i - 1]) {
//                if (current != nums[i]) {
//                    swapPos = i;
//                    current = nums[i];
//                }
//            } else {
//                len++;
//            }
//        }
//
//        return len;
    }
}

package mv.workspace.snipplets.leetCode;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstLastPositionSortedArray {
    public static void main(String[] args) {
        int[] range = new FirstLastPositionSortedArray().searchRange(new int[]{0, 1, 2, 3, 4, 4, 4}, 4);
        System.out.println(range[0] + " : " + range[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{
                searchIndex(nums, target, 0, nums.length, SearchType.FIRST),
                searchIndex(nums, target, 0, nums.length, SearchType.LAST)
        };
    }

    private int searchIndex(int[] nums, int target, int left, int right, SearchType type) {
        if (nums.length == 0 || left > right) {
            return -1;
        }

        int mid = left + ((right - left) / 2);

        if (mid >= nums.length) return -1;

        if (nums[mid] == target) {
            if (SearchType.FIRST.equals(type)
                    && mid - 1 >= 0
                    && nums[mid] == nums[mid - 1])
                return searchIndex(nums, target, left, mid - 1, type);

            if (SearchType.LAST.equals(type)
                    && mid + 1 < nums.length
                    && nums[mid] == nums[mid + 1])
                return searchIndex(nums, target, mid + 1, right, type);

            return mid;
        } else if (nums[mid] < target) {
            return searchIndex(nums, target, mid + 1, right, type);
        } else {
            return searchIndex(nums, target, left, mid - 1, type);
        }
    }

    public enum SearchType {
        FIRST,
        LAST
    }
}

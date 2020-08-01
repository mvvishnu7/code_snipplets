package mv.workspace.snipplets.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {

    public static void main(String[] args) {
        List<List<Integer>> subsets = new Subsets().subsets(new int[]{1, 2, 3});
        System.out.println(subsets.toString());
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, 0, new ArrayList<>());
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, int index, List<Integer> current) {
        result.add(new ArrayList<>(current));
        for(int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            dfs(result, nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}

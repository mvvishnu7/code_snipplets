package mv.workspace.snipplets.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 */
public class Permutations2 {

    public static void main(String[] args) {
        int[] input = {3, 3, 0, 3};
        List<List<Integer>> permutations = new Permutations2().permuteUnique(input);
        System.out.println(permutations);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutations = new ArrayList<>();
        dfs(permutations, nums, new ArrayList<>(), new boolean[nums.length]);
        return permutations;
    }

    private void dfs(List<List<Integer>> permutations,
                     int[] nums,
                     ArrayList<Integer> current,
                     boolean[] visited) {
        if (current.size() == nums.length) {
            permutations.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            current.add(nums[i]);
            dfs(permutations, nums, current, visited);
            visited[i] = false;
            current.remove(current.size() - 1);

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}

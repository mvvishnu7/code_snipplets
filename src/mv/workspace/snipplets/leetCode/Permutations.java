package mv.workspace.snipplets.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> permutations = new Permutations().permute(new int[]{1, 2, 3});
        System.out.println(permutations);
    }

    public List<List<Integer>> permute(int[] nums) {
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
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            current.add(nums[i]);
            dfs(permutations, nums, current, visited);
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
}

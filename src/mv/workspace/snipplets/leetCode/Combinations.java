package mv.workspace.snipplets.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 */
public class Combinations {

    public static void main(String[] args) {
        List<List<Integer>> result = new Combinations().combine(4, 2);
        System.out.println(result);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void dfs(List<List<Integer>> result, ArrayList<Integer> current,
                     int index, int n, int k) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i <= n; i++) {
            current.add(i);
            dfs(result, current, i + 1, n, k);
            current.remove(current.size() - 1);
        }
    }
}

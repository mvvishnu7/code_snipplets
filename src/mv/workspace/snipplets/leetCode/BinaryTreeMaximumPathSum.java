package mv.workspace.snipplets.leetCode;

import mv.workspace.snipplets.leetCode.ds.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
    private Integer max = null;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode current) {
        if(current == null) return 0;

        int left = dfs(current.left);
        int right = dfs(current.right);

        int maxStraight = Math.max(Math.max(left, right) + current.val, current.val);
        int maxCase2 = Math.max(maxStraight, current.val + left + right);

        max = Math.max(maxCase2, max);

        return maxStraight;
    }
}

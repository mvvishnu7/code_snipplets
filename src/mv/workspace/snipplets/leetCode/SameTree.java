package mv.workspace.snipplets.leetCode;

import mv.workspace.snipplets.leetCode.ds.TreeNode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/same-tree/
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (Objects.isNull(p) && Objects.isNull(q)) return true;

        if (Objects.isNull(p) || Objects.isNull(q) || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

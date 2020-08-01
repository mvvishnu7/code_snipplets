package mv.workspace.snipplets.leetCode;

import mv.workspace.snipplets.leetCode.ds.TreeNode;
import mv.workspace.snipplets.leetCode.util.BTreeUtil;

import java.util.Objects;

import static mv.workspace.snipplets.leetCode.util.BTreeUtil.printTreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LCABinaryTree {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode treeNode = BTreeUtil.createBTreeFromArr(arr);
        printTreeNode(treeNode);
        TreeNode lowestCommonAncestor = new LCABinaryTree()
                .lowestCommonAncestor(treeNode, null, null);
        System.out.println(lowestCommonAncestor.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode l, TreeNode s) {
        if (Objects.isNull(root) || Objects.isNull(l) || Objects.isNull(s)) return null;

        if (root.val == l.val || root.val == s.val) return root;

        TreeNode leftNode = lowestCommonAncestor(root.left, l, s);
        TreeNode rightNode = lowestCommonAncestor(root.right, l, s);

        if (Objects.nonNull(leftNode) && Objects.nonNull(rightNode)) return root;
        if (Objects.nonNull(leftNode)) return leftNode;
        if (Objects.nonNull(rightNode)) return rightNode;

        return null;
    }
}

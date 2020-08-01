package mv.workspace.snipplets.leetCode;

import mv.workspace.snipplets.leetCode.ds.TreeNode;
import mv.workspace.snipplets.leetCode.util.BTreeUtil;

import java.util.Objects;

import static mv.workspace.snipplets.leetCode.util.BTreeUtil.printTreeNode;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = BTreeUtil.createBTreeFromArr(arr);
        printTreeNode(treeNode);
    }

    public int maxDepth(TreeNode root) {
        if(Objects.isNull(root)) return 0;

        if(Objects.isNull(root.left) && Objects.isNull(root.right)) return 1;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
}

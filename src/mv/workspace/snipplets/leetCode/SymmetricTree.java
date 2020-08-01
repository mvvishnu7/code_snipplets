package mv.workspace.snipplets.leetCode;

import mv.workspace.snipplets.leetCode.ds.TreeNode;

import java.util.Objects;
import java.util.Stack;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return Objects.isNull(root) || isSymmetricRecursive(root.left, root.right);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        if(Objects.isNull(root))
            return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.right);
        stack.push(root.left);

        while(!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();

            if(Objects.isNull(node1) && Objects.isNull(node2)) {
                continue;
            }

            if(Objects.isNull(node1) || Objects.isNull(node2) || node1.val != node2.val) {
                return false;
            }

            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }

        return true;
    }

    public boolean isSymmetricRecursive(TreeNode right, TreeNode left) {
        if (Objects.isNull(right) && Objects.isNull(left)) {
            return true;
        }
        if (Objects.isNull(right) || Objects.isNull(left)) {
            return false;
        }

        if (right.val == left.val) {
            return isSymmetricRecursive(right.left, left.right)
                    && isSymmetricRecursive(right.right, left.left);
        }

        return false;
    }
}

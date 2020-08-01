package mv.workspace.snipplets.leetCode;

import mv.workspace.snipplets.leetCode.ds.TreeNode;

import java.util.Arrays;

import static mv.workspace.snipplets.leetCode.util.BTreeUtil.printTreeNode;

/**
 * https://leetcode.com/problems/maximum-binary-tree/
 */
public class MaximumBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{1, 2, 3});
        printTreeNode(treeNode);

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums ==null || nums.length <1) return null;

        int maxPos = findLargestPos(nums);

        TreeNode treeNode = new TreeNode(nums[maxPos]);
        if (maxPos > 0) {
            treeNode.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxPos ));
        }

        if (maxPos <= nums.length - 1) {
            treeNode.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxPos + 1, nums.length));
        }

        return treeNode;
    }

    private int findLargestPos(int[] arr) {
        int pos = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                pos = i;
            }
        }
        return pos;
    }
}

package mv.workspace.snipplets.leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        new SerializeAndDeserializeBinaryTree().testIt();
    }

    public void testIt() {
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);

        TreeNode n3 = new TreeNode(3);
        n3.left = n4;
        n3.right = n5;

        TreeNode n2 = new TreeNode(2);

        TreeNode n1 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;

        String dataString = serialize(n1);
        System.out.println(dataString);

        TreeNode deserialized = deserialize(dataString);
        System.out.println("DONE");
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "X,";

        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);
        max(1, 3);
        return root.val + "," + leftSerialized + rightSerialized;
    }

    //     Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    public TreeNode deserialize(Queue<String> queue) {
        String current = queue.remove();

        if ("X".equals(current)) return null;

        TreeNode currentNode = new TreeNode(Integer.valueOf(current));
        currentNode.left = deserialize(queue);
        currentNode.right = deserialize(queue);

        return currentNode;
    }

    //      Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

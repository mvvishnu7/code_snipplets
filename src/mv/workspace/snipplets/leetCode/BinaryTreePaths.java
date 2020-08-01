package mv.workspace.snipplets.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 5};
        TreeNode treeNode = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            insert(treeNode, arr[i]);
        }
        System.out.println(new BinaryTreePaths().binaryTreePaths(treeNode));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if(Objects.isNull(root)) {
            return Collections.emptyList();
        }

        final List<String> paths = new ArrayList<>();

        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            paths.add(Integer.toString(root.val));
            return paths;
        }

        if (Objects.nonNull(root.right)) {
            binaryTreePaths(root.right).forEach(path -> {
                paths.add(root.val + "->" + path);
            });
        }

        if (Objects.nonNull(root.left)) {
            binaryTreePaths(root.left).forEach(path -> {
                paths.add(root.val + "->" + path);
            });
        }

        return paths;
    }

    static void insert(TreeNode temp, int key) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new TreeNode(key);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new TreeNode(key);
                break;
            } else
                q.add(temp.right);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

package mv.workspace.snipplets.leetCode.util;

import mv.workspace.snipplets.leetCode.ds.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;

public class BTreeUtil {

    public static TreeNode createBTreeFromArr(Integer[] arr) {
        if (isNull(arr) || arr.length < 1) return null;

        TreeNode root = new TreeNode(arr[0]);
        IntStream.range(1, arr.length).forEach(i -> {
            insertIntoNode(root, arr[i]);
        });

        return root;
    }


    public static TreeNode insertIntoNode(TreeNode node, Integer val) {
        if (isNull(val)) return null;
        if (isNull(node)) return new TreeNode(val);

        if (val < node.val) {
            node.left = insertIntoNode(node.left, val);
        } else {
            node.right = insertIntoNode(node.right, val);
        }

        return node;
    }

    public static void printTreeNode(TreeNode root) {
        int maxLevel = BTreeUtil.maxLevel(root);

        printTreeNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printTreeNodeInternal(List<TreeNode> TreeNodes, int level, int maxLevel) {
        if (TreeNodes.isEmpty() || BTreeUtil.isAllElementsNull(TreeNodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreeUtil.printWhitespaces(firstSpaces);

        List<TreeNode> newTreeNodes = new ArrayList<TreeNode>();
        for (TreeNode TreeNode : TreeNodes) {
            if (TreeNode != null) {
                System.out.print(TreeNode.val);
                newTreeNodes.add(TreeNode.left);
                newTreeNodes.add(TreeNode.right);
            } else {
                newTreeNodes.add(null);
                newTreeNodes.add(null);
                System.out.print(" ");
            }

            BTreeUtil.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < TreeNodes.size(); j++) {
                BTreeUtil.printWhitespaces(firstSpaces - i);
                if (TreeNodes.get(j) == null) {
                    BTreeUtil.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (TreeNodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreeUtil.printWhitespaces(1);

                BTreeUtil.printWhitespaces(i + i - 1);

                if (TreeNodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreeUtil.printWhitespaces(1);

                BTreeUtil.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printTreeNodeInternal(newTreeNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode TreeNode) {
        if (TreeNode == null)
            return 0;

        return Math.max(BTreeUtil.maxLevel(TreeNode.left), BTreeUtil.maxLevel(TreeNode.right)) + 1;
    }

    private static boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
package mv.workspace.snipplets.hackerrank.interview.search;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/swap-nodes-algo/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
 */
public class SwapNodes {

    public static void main(String[] args) {

        int[][] indexes = new int[][]{
                {2, 3},
                {-1, -1},
                {-1, -1}
        };
        Node treeFrom2DArray = createTreeFrom2DArray(indexes);
        System.out.println("Done !!!");
    }
//
//    private static int[][] swapNodes(int[][] indexes, int[] queries) {
//        /*
//         * Write your code here.
//         */
//
//    }

    private static Node createTreeFrom2DArray(int[][] indexes) {
        Node root = new Node(1, null, null);
        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(1);

        int n = 0;

        while (n < indexes.length) {
            queue.add(indexes[n][0]);
            queue.add(indexes[n][1]);
            n++;
        }

        root.left = populateTree(queue);
        root.right = populateTree(queue);
//        List<Integer> nodes = new ArrayList<>();
//        nodes.add

        List<List<Integer>> levelOrderLists = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();

        levelOrderLists.addAll(stack);

        return root;
    }

    private static Node populateTree(Queue<Integer> queue) {
        Integer current = queue.poll();

        if ((current == null || current == -1)) return null;

        Node node = new Node(current, null, null);
        node.left = populateTree(queue);
        node.right = populateTree(queue);

        return node;
    }

    private static class Node {
        int index;
        Node left;
        Node right;

        public Node(Integer index, Node left, Node right) {
            this.index = index;
            this.left = left;
            this.right = right;
        }
    }
}

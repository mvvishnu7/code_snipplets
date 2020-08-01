package mv.workspace.snipplets.leetCode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers2 {

    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(3, null);
        ListNode listNode4_1 = new ListNode(4, listNode3);
        ListNode listNode2 = new ListNode(2, listNode4_1);

        ListNode listNode4_2 = new ListNode(4, null);
        ListNode listNode6 = new ListNode(6, listNode4_2);
        ListNode listNode5 = new ListNode(5, listNode6);

        ListNode result = new AddTwoNumbers2().addTwoNumbers(listNode2, listNode5);
        do {
            System.out.println(result.val);
            result = result.next;
        } while (Objects.nonNull(result));
    }


    public ListNode addTwoNumbers(final ListNode l1, ListNode l2) {
        ListNode previousNode = null;
        ListNode firstNode = null;
        int overflow = 0;
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;
        while (!Objects.isNull(currentNode1) || !Objects.isNull(currentNode2)) {
            int val1 = 0;
            int val2 = 0;

            if (Objects.nonNull(currentNode1)) {
                val1 = currentNode1.val;
                currentNode1 = currentNode1.next;
            }
            if (Objects.nonNull(currentNode2)) {
                val2 = currentNode2.val;
                currentNode2 = currentNode2.next;
            }

            int sum = val1 + val2 + overflow;
            int reminder = sum == 0 ? 0 : sum % 10;
            overflow = sum == 0 ? 0 : sum / 10;

            ListNode currentSumNode = new ListNode(reminder);

            if (Objects.isNull(firstNode)) {
                firstNode = currentSumNode;
            }

            if (Objects.nonNull(previousNode)) {
                previousNode.next = currentSumNode;
            }

            previousNode = currentSumNode;
        }

        if (overflow > 0) {
            previousNode.next = new ListNode(overflow);
        }

        return firstNode;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

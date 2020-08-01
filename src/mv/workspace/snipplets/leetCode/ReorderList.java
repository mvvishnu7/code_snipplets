package mv.workspace.snipplets.leetCode;

import mv.workspace.snipplets.leetCode.ds.ListNode;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode input =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5, null)))));

        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(input);
        System.out.println(input.toString());
    }

    public void reorderList(ListNode head) {
        ListNode secondHalf = getMiddle(head);
        ListNode reversedSecondHalf = reverse(secondHalf);
        merge(head, reversedSecondHalf);
    }

    private ListNode getMiddle(ListNode node) {
        ListNode fast = node, slow = node, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode headOfReversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return headOfReversed;
    }

    private void merge(ListNode curr, ListNode reversed) {
        ListNode l1 = curr, l2 = reversed, prev = null;
        while (l1 != null) {
            ListNode next1 = l1.next, next2 = l2.next;
            l1.next = l2;
            l2.next = next1;
            prev = l2;
            l1 = next1;
            l2 = next2;
        }
        if (prev != null) {
            prev.next = l2;
        }
    }
}

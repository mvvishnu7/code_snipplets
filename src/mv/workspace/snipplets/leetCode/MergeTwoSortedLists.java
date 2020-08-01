package mv.workspace.snipplets.leetCode;

import java.util.Objects;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    // Input: 1->2->4, 1->3->4
    // Output: 1->1->2->3->4->4

    public static void main(String[] args) {
        ListNode node14 = new ListNode(5);
        ListNode node13 = new ListNode(4, node14);
        ListNode node12 = new ListNode(2, node13);
        ListNode node11 = new ListNode(1, node12);

        ListNode node23 = new ListNode(4);
        ListNode node22 = new ListNode(2, node23);
        ListNode node21 = new ListNode(1, node22);

        ListNode result = new MergeTwoSortedLists().mergeTwoLists(node11, node21);
        do {
            System.out.println(result.val);
            result = result.next;
        } while (Objects.nonNull(result));
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(Objects.isNull(l1)) {
            return l2;
        }
        if(Objects.isNull(l2)) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
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

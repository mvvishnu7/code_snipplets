package mv.workspace.snipplets.leetCode.ds;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        String result = this.val + " ";
        if (next != null) {
            result += next.toString();
        }
        return result;
    }
}

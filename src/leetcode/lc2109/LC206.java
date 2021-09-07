package leetcode.lc2109;

public class LC206 {
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        ListNode next = head.next,node;
        head.next = null;
        while (next != null) {
            node = head;
            head = next;
            next = next.next;
            head.next = node;
        }
        return head;

    }
}

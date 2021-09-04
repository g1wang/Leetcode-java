package leetcode.lc2109;

/*
https://leetcode.com/problems/sort-list/
 */
public class LC148 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode head2 = findMid(head);
        head = sortList(head);
        head2 = sortList(head2);
        return merge(head, head2);

    }

    private ListNode findMid(ListNode head) {
        ListNode headLow = null, headFast = head;
        while (headFast != null && headFast.next != null) {
            headFast = headFast.next.next;
            headLow = headLow == null ? head : headLow.next;
        }
        head = headLow.next;
        headLow.next = null;
        return head;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode cur = new ListNode(), head = cur;
        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                cur.next = head2;
                head2 = head2.next;
            } else {
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }
        if (head1 != null) cur.next = head1;
        if (head2 != null) cur.next = head2;
        return head.next;


    }

}

package leetcode.lc300;



/**
 * 206. Reverse Linked List
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/1
 */
public class LC0206 {
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        ListNode next = head.next, node;
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

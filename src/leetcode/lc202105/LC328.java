package leetcode.lc202105;

/**
 * 328. Odd Even Linked List
 * https://leetcode.com/problems/odd-even-linked-list/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/17
 */
public class LC328 {
    public ListNode oddEvenList(ListNode head) {

        if (head == null) return null;
        ListNode oddNode = head, evenNode = head.next, evenHead = evenNode;
        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = evenNode.next.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
        return head;
    }
}

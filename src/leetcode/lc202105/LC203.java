package leetcode.lc202105;

/**
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/20
 */
public class LC203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(), ans = node;
        node.next = head;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else node = node.next;
        }
        return ans.next;
    }
}

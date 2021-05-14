package leetcode.lc202105;

/**
 * 237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/14
 */
public class LC237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

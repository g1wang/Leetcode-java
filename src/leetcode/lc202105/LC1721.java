package leetcode.lc202105;

/**
 * 1721. Swapping Nodes in a Linked List
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/13
 */
public class LC1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode loNode = head, kNode = head, ekNode = head;
        int count = 1;
        while (loNode != null) {
            if (count<k) count++;
            else if (count == k) {
                kNode = loNode;
                count++;
            }else ekNode =ekNode.next;
            loNode = loNode.next;
        }
        int tmp = kNode.val;
        kNode.val= ekNode.val;
        ekNode.val= tmp;
        return head;

    }

}

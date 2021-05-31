package leetcode.lc202105;


/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/29
 */
public class LC21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(), curNode = ans;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        if (l1 != null) curNode.next = l1;
        if (l2 != null) curNode.next = l2;
        return ans.next;
    }
}

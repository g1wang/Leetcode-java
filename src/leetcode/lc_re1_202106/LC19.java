package leetcode.lc_re1_202106;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/28
 */
public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(), ans = pre;
        pre.next = head;
        ListNode cur = head;
        int idx = 0;
        while (cur != null) {
            if (idx < n) {
                idx++;
            } else pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return ans.next;
    }

}

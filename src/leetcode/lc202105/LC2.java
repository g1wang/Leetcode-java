package leetcode.lc202105;


/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/25
 */
public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = l1, pre = null;
        while (l1 != null && l2 != null) {
            pre = l1;
            int val = l1.val + l2.val + carry;
            carry = val / 10;
            l1.val = val % 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            pre.next = l2;
            l1 = pre.next;
        }
        while (l1 != null) {
            pre = l1;
            int val = l1.val + carry;
            carry = val / 10;
            l1.val = val % 10;
            l1 = l1.next;
        }
        if (carry > 0) {
            pre.next = new ListNode(1);
        }
        return ans;
    }
}

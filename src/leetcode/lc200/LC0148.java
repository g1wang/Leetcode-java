package leetcode.lc200;



import java.util.Stack;

/**
 * Sort List
 * O(N*N)
 * @author CodeX
 * @version 1.0
 * @date 2021/4/30
 */
public class LC0148 {
    public ListNode sortList(ListNode head) {

        if (head==null) return null;
        ListNode sortHead = head;
        ListNode ans = sortHead;
        ListNode pre;
        head = head.next;
        sortHead.next = null;
        while (head != null) {
            ans = sortHead;
            pre = null;
            boolean sort = false;
            while (sortHead != null) {
                if (head.val <= sortHead.val) {
                    if (pre == null) {
                        ans = head;
                        pre = head;
                        head = head.next;
                        pre.next = sortHead;
                    } else {
                        pre.next = head;
                        head = head.next;
                        pre.next.next = sortHead;
                    }
                    sort = true;
                    break;
                }
                pre = sortHead;
                sortHead = sortHead.next;
            }
            if (!sort) {
                pre.next = head;
                head = head.next;
                pre.next.next =null;
            }
            sortHead = ans;

        }
        
        return ans;
    }

}

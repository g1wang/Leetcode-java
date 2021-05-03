package leetcode.lc202103;
/*
24. Swap Nodes in Pairs
Medium

3421

208

Add to List

Share
Given a linked list, swap every two adjacent nodes and return its head.



Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]


Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100


Follow up: Can you solve the problem without modifying the values in the list's nodes? (i.e., Only nodes themselves may be changed.)

 */

/*
solution:
1 将两个节点作为整体，先内部调换头尾，再接到新结点的尾部

 */

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/3/19 17:16
 */
public class LC0024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fn = new ListNode(0);
        ListNode pn = new ListNode(0);
        ListNode rn = fn;
        while (head != null && head.next != null) {
            pn = head.next;
            head.next = head.next.next;
            pn.next = head;
            fn.next = pn;
            fn = fn.next.next;
            head = head.next;
        }
        return rn.next;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

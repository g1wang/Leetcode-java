package leetcode.lc202103;


/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Follow up: Could you do this in one pass?



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

 */

public class LC0019 {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sNode = new ListNode(0);
        sNode.next = head;
        ListNode node = head;
        ListNode nthNode = sNode;
        while (n > 0) {
            node = node.next;
            n--;
        }
        while (node != null) {
            node = node.next;
            nthNode = nthNode.next;
        }
        nthNode.next = nthNode.next.next;
        return sNode.next;

    }


    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

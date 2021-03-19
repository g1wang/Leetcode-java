package leetcode.lc0025;

/*

25. Reverse Nodes in k-Group
Hard

3405

399

Add to List

Share
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

Follow up:

Could you solve the problem in O(1) extra memory space?
You may not alter the values in the list's nodes, only nodes itself may be changed.


Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
Example 3:

Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]
Example 4:

Input: head = [1], k = 1
Output: [1]


Constraints:

The number of nodes in the list is in the range sz.
1 <= sz <= 5000
0 <= Node.val <= 1000
1 <= k <= sz
 */
public class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode fn = new ListNode();
        ListNode pn = null, bfn = null, nn = null, rn = fn;
        int i = 1;
        while (head != null) {
            //下一节点 nn
            nn = head.next;
            if (i % k == 1) {
                //bfn 当前块的头结点
                bfn = head;
                //上一节点 pn
                pn = bfn;
            }
            if (i % k == 0) {
                bfn.next = head.next;
                fn.next = head;
                fn = bfn;
                i = 0;
            }
            //当前节点 head
            head.next = pn;
            pn = head;
            head = nn;
            i++;
        }
        //reverse
        if (i % k != 1) {
            head = pn;
            pn = nn;
            while (i > 1) {
                nn = head.next;
                head.next = pn;
                pn = head;
                head = nn;
                i--;
            }
        }
        return rn.next;

    }


    static class ListNode {
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        reverseKGroup(l1, 2);
    }
}



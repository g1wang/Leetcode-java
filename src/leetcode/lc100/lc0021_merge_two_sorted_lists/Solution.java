package leetcode.lc100.lc0021_merge_two_sorted_lists;

/*

21. Merge Two Sorted Lists
Easy

6305

739

Add to List

Share
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.



Example 1:


Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.


 */

/**
 * START
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/3/18 0:13
 */
/**
 *
 * END
 * @version 1.0
 * @author CodeX
 * @date 2021/3/18 0:24
 */


public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sNode = new ListNode(0);
        ListNode node = sNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        if (l1 != null) node.next = l1;
        if (l2 != null) node.next = l2;
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

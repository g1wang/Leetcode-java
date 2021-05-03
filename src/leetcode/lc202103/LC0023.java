package leetcode.lc202103;

/*
23. Merge k Sorted Lists
Hard

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
 */

/*
solution 1 compare ono by one
s2 priorityQueue queue.size==k
s3 Divide And Conquer
 */

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/3/18 23:21
 */
public class LC0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode sNode = new ListNode(0);
        ListNode mNode;
        ListNode fNode = lists[0];
        for (int i = 1; i < lists.length; i++) {
            mNode = sNode;
            ListNode listNode = lists[i];
            while (fNode != null && listNode != null) {
                if (fNode.val < listNode.val) {
                    mNode.next = fNode;
                    mNode = mNode.next;
                    fNode = fNode.next;
                } else {
                    mNode.next = listNode;
                    mNode = mNode.next;
                    listNode = listNode.next;
                }
                if (fNode != null) mNode.next = fNode;
                if (listNode != null) mNode.next = listNode;
            }
            fNode = sNode.next;
        }

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

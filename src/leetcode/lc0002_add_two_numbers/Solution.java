package leetcode.lc0002_add_two_numbers;

/*
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = l1;
        int i = 0;
        ListNode zNode = new ListNode(0);
        while (l1 != null) {
            int val = l1.val + l2.val + i;
            l1.val = val % 10;
            i = val / 10;
            if (l1.next == null || l2.next == null) {
                if (l1.next == null) {
                    l1.next = l2.next;
                    l2 = zNode;
                }
                if (l1.next == null) {
                    if (i == 1) {
                        l1.next = new ListNode(1);
                        return l3;
                    }
                } else if (l1.next.val + i < 10) {
                    l1.next.val += i;
                    return l3;
                }
            }
            l1 = l1.next;
            l2 = l2.next == null ? zNode : l2.next;
        }
        return l3;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}



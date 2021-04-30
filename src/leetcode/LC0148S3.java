package leetcode;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/1
 */
public class LC0148S3 {

    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode mid = getMid(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);
            return merge(left, right);
        }

        ListNode merge(ListNode list1, ListNode list2) {
            ListNode dummyHead = new ListNode();
            ListNode tail = dummyHead;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    tail.next = list1;
                    list1 = list1.next;
                    tail = tail.next;
                } else {
                    tail.next = list2;
                    list2 = list2.next;
                    tail = tail.next;
                }
            }
            tail.next = (list1 != null) ? list1 : list2;
            return dummyHead.next;
        }

        ListNode getMid(ListNode head) {
            ListNode midPrev = null;
            while (head != null && head.next != null) {
                midPrev = (midPrev == null) ? head : midPrev.next;
                head = head.next.next;
            }
            ListNode mid = midPrev.next;
            midPrev.next = null;
            return mid;
        }
    }

}

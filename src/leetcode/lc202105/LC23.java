package leetcode.lc202105;

/*
23. Merge k Sorted Lists
https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        //if (lists.length==0) return null;
        int mid = lists.length / 2;
        return mergeNode(mergeLists(lists, 0, mid-1), mergeLists(lists, mid, lists.length - 1));


    }

    private ListNode mergeNode(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(), curNode = ret;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = l1;
                curNode = curNode.next;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                curNode = curNode.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) curNode.next = l1;
        if (l2 != null) curNode.next = l2;
        return ret.next;
    }

    private ListNode mergeLists(ListNode[] lists, int l, int r) {
        if (l>r) return null;
        if (l == r) {
            return lists[l];
        }
        if (r - l == 1) {
            return mergeNode(lists[l], lists[r]);
        } else {
            int mid = l + (r - l) / 2;
            return mergeNode(mergeLists(lists, l, mid-1), mergeLists(lists, mid, r));
        }
    }


}

package leetcode;

/**
 * Sort List
 * time:O(n*n*k)，k<1 ?  跟快排不一样！！！
 * @author CodeX
 * @version 1.0
 * @date 2021/4/30
 */
public class LC0148S2 {
    public ListNode sortList(ListNode head) {

        return sort(head);
    }

    private ListNode sort(ListNode head) {

        ListNode ln =new ListNode(0);
        ListNode rn =new ListNode(0);
        if (head==null||head.next==null) return head;
        ListNode node =head;
        ListNode lh = ln,rh=rn;
        int hv=head.val;
        while (node.next!=null){
            if (node.next.val<=hv){
                ln.next = node.next;
                ln = ln.next;
            }else {
                rn.next = node.next;
                rn = rn.next;

            }
            node =node.next;
        }
        ln.next = head;
        head.next =null;
        rn.next = null;
        lh.next = sort(lh.next);
        rh.next=sort(rh.next);
        head.next = rh.next;
        return lh.next;
    }


}

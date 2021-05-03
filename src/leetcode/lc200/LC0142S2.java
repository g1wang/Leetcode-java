package leetcode.lc200;



/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/30
 */
public class LC0142S2 {
    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null)
            return null;
        ListNode fast = head ;
        ListNode slow = head ;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;

            }
        }

        return null;
    }
}

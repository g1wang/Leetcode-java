package leetcode;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/30
 */
public class LC0141S2 {
    public boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner!=null&&runner.next!=null){
            if (walker == runner.next) return true;
            walker = walker.next;
            runner = runner.next.next;
        }
        return false;

    }
}

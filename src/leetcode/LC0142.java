package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 142. Linked List Cycle II
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/30
 */
public class LC0142 {
    public ListNode detectCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if (set.contains(head)) return head;
            set.add(head);
            head = head.next;

        }
        return null;
    }
}

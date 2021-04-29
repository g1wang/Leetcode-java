package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/30 13:01
 */
public class LC0141 {
    public boolean hasCycle(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<>();
        int pos = 0;
        while (head!=null){
            if (!map.containsKey(head)){
                map.put(head,pos);
                pos++;
                head = head.next;
            }else return true;
        }
        return false;
    }
}

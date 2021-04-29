package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/30 13:12
 */
public class LC0138 {

    public Node copyRandomList(Node head) {

        Node temp = head;
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            map.put(head, new Node(head.val));
            head = head.next;
        }
        head = temp;
        while (head != null) {
            Node copyHead = map.get(head);
            copyHead.next = map.get(head.next);
            copyHead.random = map.get(head.random);
            head = head.next;
        }

        return map.get(temp);

    }


    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

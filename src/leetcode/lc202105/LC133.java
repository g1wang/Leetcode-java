package leetcode.lc202105;

import java.util.*;

/**
 * 133. Clone Graph
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/25
 */
public class LC133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Integer, Node> map = new HashMap<>();
        Node first = new Node(node.val);
        map.put(node.val, first);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node qNode = queue.poll();
            Node nodeClone = map.get(qNode.val);
            List<Node> list = qNode.neighbors;
            List<Node> listClone = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                int val = list.get(i).val;
                Node listNodeClone;
                if (!map.containsKey(val)) {
                    queue.offer(list.get(i));
                    listNodeClone = new Node(val);
                    map.put(val, listNodeClone);
                } else listNodeClone = map.get(val);
                listClone.add(listNodeClone);
            }
            nodeClone.neighbors = listClone;
        }
        return first;
    }
}

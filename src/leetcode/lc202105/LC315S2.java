package leetcode.lc202105;

import java.util.*;

/**
 * 315. Count of Smaller Numbers After Self
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * Time Limit Exceeded
 * @author CodeX
 * @version 1.0
 * @date 2021/5/18
 */
public class LC315S2 {
    class PriorityLinkedList {
        ListNode root;
        ListNode tail;

        public PriorityLinkedList() {
            root = new ListNode();
            tail =root;
        }

        int insertNode(int key) {
            ListNode node = root.next;
            ListNode pre = root;
            while (node != null) {
                if (key == node.key) {
                    node.cnt++;
                    return node.val;
                } else if (key < node.key) {
                    node.val++;
                    pre = node;
                    node = node.next;
                } else break;
            }
            ListNode insertNode = new ListNode(key, node == null ? 0 : node.val + node.cnt);
            pre.next = insertNode;
            insertNode.next = node;
            insertNode.cnt=1;
            if (node==null);
            tail=insertNode;
            return insertNode.val;
        }
    }


    class ListNode {
        int key;
        int val;
        int cnt;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public ListNode() {
        }

    }


    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ansList = new ArrayList<>();
        PriorityLinkedList root = new PriorityLinkedList();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            ansList.add(0, root.insertNode(nums[i]));
        }
        return ansList;
    }

    public static void main(String[] args) {
        LC315S2 lc315S2 = new LC315S2();
        List<Integer> list = lc315S2.countSmaller(new int[]{5, 2, 6, 1});
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

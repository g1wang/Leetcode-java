package leetcode.lc2109;


public class LC707 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }


        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static class MyLinkedList {
        ListNode head;
        ListNode tail;
        int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            head = new ListNode();
            tail = null;
            size = 0;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            ListNode node = head.next;
            if (index >= size) return -1;
            while (index > 0) {
                node = node.next;
                index--;
            }
            return node.val;

        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            node.next = head.next;
            head.next = node;
            if (tail == null) tail = node;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            if (tail == null) addAtHead(val);
            else {
                ListNode node = new ListNode(val);
                tail.next = node;
                tail = node;
                size++;
            }
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            ListNode node = head.next, pre = head;
            if (index > size) return;
            if (index == size) addAtTail(val);
            else {
                while (index > 0) {
                    pre = node;
                    node = node.next;
                    index--;
                }
                ListNode addNode = new ListNode(val);
                pre.next = addNode;
                addNode.next = node;
                size++;
            }

        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index >= size) return;
            ListNode node = head.next, pre = head;
            while (index > 0) {
                pre = node;
                node = node.next;
                index--;
            }
            pre.next = node.next;
            if (pre.next == null) tail = pre;
            size--;
            if (size == 0) tail = null;

        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(0);
        myLinkedList.addAtIndex(1, 4);
        myLinkedList.addAtTail(8);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtIndex(4, 3);
        myLinkedList.addAtTail(0);
        myLinkedList.addAtTail(5);
        myLinkedList.addAtIndex(6, 3);
        myLinkedList.deleteAtIndex(7);
        myLinkedList.deleteAtIndex(5);

    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}

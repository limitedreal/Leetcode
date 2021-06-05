package main.LeetCode.l707;

public class MyLinkedList {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }
    }

    ListNode head;
    ListNode tail;
    int length = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new ListNode();
        tail = head;
    }

    //public static void main(String[] args) {
    //    MyLinkedList linkedList = new MyLinkedList();
    //    linkedList.addAtHead(1);
    //    linkedList.addAtTail(3);
    //    linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
    //    linkedList.get(1);            //返回2
    //    linkedList.deleteAtIndex(1);  //现在链表是1-> 3
    //    linkedList.get(1);            //返回3
    //}

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode now = this.head;
        if (index >= length) {
            return -1;
        }
        for (int i = 0; i <= index; i++) {
            now = now.next;
        }
        return now.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        temp.next = head.next;
        head.next = temp;
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode now = head;
        while (now.next != null) {
            now = now.next;
        }
        now.next = new ListNode(val);
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
        } else if (index >= length) {
            addAtTail(val);
        } else {
            ListNode now = head;
            for (int i = 0; i <= index - 1; i++) {
                now = now.next;
            }
            ListNode t = new ListNode(val);
            t.next = now.next;
            now.next = t;
            length++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }
        ListNode now = head;
        for (int i = 0; i <= index - 1; i++) {
            now = now.next;
        }
        now.next = now.next.next;
        length--;
    }
}

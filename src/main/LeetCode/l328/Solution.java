package main.LeetCode.l328;

public class Solution {
    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        oddEvenList(listNode1);
    }

    public static ListNode oddEvenList(ListNode head) {

        if(head==null){
            return head;
        }
        ListNode end = head, pivot, result = head,second = head.next;//head进行到pivot就可以停止了
        while (end.next != null) {
            end = end.next;
        }
        pivot = end;
        //boolean con = true;
        while (head != second && head != pivot) {//这样正好验证完pivot停止
            end.next = head.next;
            head.next = head.next.next;
            end = end.next;
            head = head.next;
            end.next = null;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

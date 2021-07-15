package main;

import java.util.Arrays;

public class Solution {

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


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre=head;
        ListNode now = pre.next;
        while (now!=null){
            ListNode next=now.next;
            now.next=pre;
            pre=now;
            now=next;
        }
        head.next=null;
        return pre;
    }

}

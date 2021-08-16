package main.LeetCode.l21;

import java.util.List;

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


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode now = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                now.next = l2;
                now=l2;
                l2 = l2.next;
            } else if (l2 == null) {
                now.next = l1;
                now=l1;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    now.next = l1;
                    now=l1;
                    l1 = l1.next;
                } else {
                    now.next = l2;
                    now=l2;
                    l2 = l2.next;
                }
            }
        }
        return head.next;
    }

}

package main.LeetCode.l92;


public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;l3.next=l4;
        l4.next=l5;
        Solution s=new Solution();
        s.reverseBetween(l1,2,4);

    }

    static class ListNode {

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


    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode g = hair;
        for (int i = 0; i < left - 1; i++) {
            g = g.next;
        }
        ListNode p = g.next;
        for (int i = 0; i < right - left; i++) {
            ListNode removed=p.next;
            p.next=removed.next;
            removed.next=g.next;
            g.next=removed;

        }
        return hair.next;
    }
}

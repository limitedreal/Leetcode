package main.LeetCode.l25;

import java.util.ArrayList;
import java.util.List;

public class Solution {

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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution s = new Solution();
        s.reverseKGroup(l1, 2);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair=new ListNode(0);
        hair.next=head;
        ListNode pre=hair;
        ListNode now=pre;
        while (now!=null){
            for (int i = 0; i < k; i++) {
                now=now.next;
                if(now==null){
                    return hair.next;
                }
            }
            pre = reverse(pre, now.next);
            now=pre;
        }
        return hair.next;
    }
    public ListNode reverse(ListNode pre,ListNode tail){
        ListNode now=pre.next;
        ListNode result=pre.next;
        while (now.next!=tail){
            ListNode removed=now.next;
            now.next=removed.next;
            removed.next=pre.next;
            pre.next=removed;
        }
        return result;
    }
}






package main.LeetCode.l24;

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

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode result = pre;
        while (pre != null) {
            if (pre.next != null) {
                ListNode first = pre.next;
                if (first.next != null) {
                    //执行两两交换
                   ListNode second = first.next;
                   pre.next=second;
                   first.next=second.next;
                   second.next=first;
                   pre=first;
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        return result.next;
    }
}

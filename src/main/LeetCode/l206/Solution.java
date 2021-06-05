package main.LeetCode.l206;


public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode pre=head;
        head=head.next;
        pre.next=null;
        while (head!=null){
            ListNode t=head.next;
            head.next=pre;
            pre=head;
            head=t;
        }
        return head;
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
}

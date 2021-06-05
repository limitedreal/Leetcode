package main.LeetCode.l203;

class Solution {
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode();
        result.next=head;
        ListNode pre = result;
        while (pre.next!=null){
            head = pre.next;
            if(head.val==val){
                pre.next=head.next;
            }else{
                pre=pre.next;
            }
        }
        return result.next;
    }
}



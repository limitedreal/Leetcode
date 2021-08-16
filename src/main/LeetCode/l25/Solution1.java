package main.LeetCode.l25;


public class Solution1 {
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
        Solution1 s = new Solution1();
        s.reverseKGroup(l1, 2);
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

    public ListNode reverseKGroup(ListNode now, int k) {
        ListNode head=new ListNode();
        ListNode pre=head;
        head.next=now;
        while (true){
            ListNode[] reverse = reverse(pre, now, k);
            if(reverse==null){
                return head.next;
            }
            pre=reverse[0];
            now=reverse[1];
        }
    }

    public ListNode[] reverse(ListNode preNode,ListNode nowNode, int k){
        ListNode now=nowNode;
        ListNode last = now;
        for (int i = 0; i < k; i++) {
            if(last==null){
                return null;
            }
            last=last.next;
        }
        ListNode pre=preNode;
        ListNode next=now.next;
        for (int i = 0; i < k; i++) {
            next=now.next;
            now.next=pre;
            pre=now;
            now=next;
        }
        nowNode.next=last;
        preNode.next=pre;
        ListNode[] result={nowNode,last};
        return result;
    }
}

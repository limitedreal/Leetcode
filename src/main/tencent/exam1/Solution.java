package main.tencent.exam1;

public class Solution {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode solve(ListNode[] a) {
        ListNode result=new ListNode(1);
        ListNode head=result;
        while (true){
            boolean flag=true;
            for (int i = 0; i < a.length; i++) {
                if(a[i]!=null){
                    result.next=a[i];
                    result=result.next;
                    a[i]=a[i].next;
                    flag=false;
                }
            }
            if(flag){
                break;
            }
        }
        return head.next;
    }


}

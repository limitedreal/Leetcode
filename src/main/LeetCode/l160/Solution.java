package main.LeetCode.l160;


public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        int n1=0,n2=0;
        ListNode nowA=headA,nowB=headB;
        while (nowA!=null){
            n1++;
            nowA=nowA.next;
        }
        while (nowB!=null){
            n2++;
            nowB=nowB.next;
        }
        ListNode s=n1>n2?headB:headA,l=n1>n2?headA:headB;
        int sh=n1>n2?n2:n1,lo=n1>n2?n1:n2;
        while (sh<lo){
            l=l.next;
            lo--;
        }
        while (s!=null&&l!=null){
            if(s==l){
                return s;
            }
            s=s.next;
            l=l.next;
        }
        return null;
    }
}